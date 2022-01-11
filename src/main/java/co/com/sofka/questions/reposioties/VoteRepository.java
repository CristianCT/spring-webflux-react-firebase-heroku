package co.com.sofka.questions.reposioties;

import co.com.sofka.questions.collections.Vote;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VoteRepository extends ReactiveCrudRepository<Vote, String> {
    Mono<Vote> findByUserIdAndQuestionId(String userId, String questionId);

    Flux<Vote> findByAnswerId(String answerId);

    Mono<Void> deleteByUserIdAndQuestionId(String userId, String questionId);
}
