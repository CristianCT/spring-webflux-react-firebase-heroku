package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Vote;
import co.com.sofka.questions.model.VoteDTO;
import co.com.sofka.questions.reposioties.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class DeleteVoteUseCase implements Function<VoteDTO, Mono<Void>> {

    private final VoteRepository voteRepository;

    public DeleteVoteUseCase(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Mono<Void> apply(VoteDTO voteDTO) {
        Objects.requireNonNull(voteDTO, "Los datos no pueden ser null");
        return voteRepository.deleteByUserIdAndQuestionId(voteDTO.getUserId(),voteDTO.getQuestionId());
    }
}
