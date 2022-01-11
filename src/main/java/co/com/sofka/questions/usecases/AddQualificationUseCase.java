package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Qualification;
import co.com.sofka.questions.model.QualificationDTO;
import co.com.sofka.questions.reposioties.QualificationRepository;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@Validated
public class AddQualificationUseCase implements SaveQualification {
    private final QualificationRepository qualificationRepository;
    private final QuestionRepository questionRepository;
    private final MapperUtils mapperUtils;

    public AddQualificationUseCase(QualificationRepository qualificationRepository, QuestionRepository questionRepository, MapperUtils mapperUtils) {
        this.qualificationRepository = qualificationRepository;
        this.questionRepository = questionRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(QualificationDTO qualificationDTO) {
        return qualificationRepository.findByQuestionIdAndUserId(qualificationDTO.getQuestionId(), qualificationDTO.getUserId())
                .switchIfEmpty(qualificationRepository.save(mapperUtils.mapperToQualification().apply(qualificationDTO)))
                .flatMap(qualification -> {
                        qualification.setValue(qualificationDTO.getValue());
                        return qualificationRepository.save(qualification)
                                .flatMap(qualificationSaved ->questionRepository.findById(qualificationSaved.getQuestionId())
                                        .flatMap(question -> qualificationRepository.findByQuestionId(qualification.getQuestionId())
                                                .collect(Collectors.averagingDouble(Qualification::getValue))
                                                .flatMap(value -> {
                                                    question.setQualification(value);
                                                    return questionRepository.save(question);
                                                })
                                        )
                                ).flatMap(question -> Mono.just(question.getId()));
                });

    }
}
