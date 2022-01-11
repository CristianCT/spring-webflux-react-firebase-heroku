package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.AnswerRepository;
import co.com.sofka.questions.reposioties.UserRepository;
import co.com.sofka.questions.templates.TemplateGenerator;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

@Service
@Validated
public class AddAnswerUseCase implements SaveAnswer {
    private final AnswerRepository answerRepository;
    private final MapperUtils mapperUtils;
    private final UserRepository userRepository;
    private final GetUseCase getUseCase;
    private final  JavaMailSender javaMailSender;

    public AddAnswerUseCase(MapperUtils mapperUtils, GetUseCase getUseCase, AnswerRepository answerRepository, UserRepository userRepository, JavaMailSender javaMailSender) {
        this.answerRepository = answerRepository;
        this.getUseCase = getUseCase;
        this.mapperUtils = mapperUtils;
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
    }

    public Mono<QuestionDTO> apply(AnswerDTO answerDTO) {
        Objects.requireNonNull(answerDTO.getQuestionId(), "Id of the answer is required");



        return getUseCase.apply(answerDTO.getQuestionId()).flatMap(question ->
                answerRepository.save(mapperUtils.mapperToAnswer().apply(answerDTO))
                        .map(answer -> {
                            question.getAnswers().add(answerDTO);
                            userRepository.findById(answerDTO.getUserId()).flatMap(
                                    user -> {
                                        sendHTMLMessage(user.getEmail(), question.getQuestion(), answer.getAnswer());
                                        return Mono.just(user);
                                    }
                            ).subscribe();
                            return question;
                        })
        );
    }

    private void sendHTMLMessage(String email, String question, String answer) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, true,"UTF-8");

            TemplateGenerator template = new TemplateGenerator(question, answer);

            mail.setFrom("cridejecato@gmail.com");
            mail.setTo(email);
            mail.setSubject("Se ha agregado una nueva respuesta a tu pregunta");
            mail.setText(template.getTemplate(), true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
