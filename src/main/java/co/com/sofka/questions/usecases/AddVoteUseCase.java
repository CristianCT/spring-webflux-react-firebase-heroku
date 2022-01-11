package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.collections.Vote;
import co.com.sofka.questions.model.VoteDTO;
import co.com.sofka.questions.reposioties.AnswerRepository;
import co.com.sofka.questions.reposioties.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@Validated
public class AddVoteUseCase implements SaveVote {
    private final VoteRepository voteRepository;
    private final AnswerRepository answerRepository;
    private final MapperUtils mapperUtils;

    public AddVoteUseCase(VoteRepository voteRepository, AnswerRepository answerRepository, MapperUtils mapperUtils) {
        this.voteRepository = voteRepository;
        this.answerRepository = answerRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(VoteDTO voteDTO) {

            return voteRepository.findByUserIdAndQuestionId(voteDTO.getUserId(), voteDTO.getQuestionId())
                    .switchIfEmpty(voteRepository.save(mapperUtils.mapperToVote().apply(voteDTO)))
                    .flatMap(vote -> {
                            vote.setValue(voteDTO.getValue());
                            vote.setAnswerId(voteDTO.getAnswerId());
                            return voteRepository.save(vote)
                                    .flatMap(voteSaved -> answerRepository.findAll()
                                            .flatMap(answer -> voteRepository.findByAnswerId(answer.getId())
                                                    .collect(Collectors.summingInt(Vote::getValue))
                                                    .flatMap(value -> {
                                                            answer.setPosition(value);
                                                            return answerRepository.save(answer);
                                                    })
                                            )
                                            .collectList()
                                    )
                                    .flatMap(voteResult -> Mono.just(voteDTO.getAnswerId()));
                    });
    }
}
