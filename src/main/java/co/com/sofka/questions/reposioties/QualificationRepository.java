package co.com.sofka.questions.reposioties;

import co.com.sofka.questions.collections.Qualification;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QualificationRepository extends ReactiveCrudRepository<Qualification, String> {
    Flux<Qualification> findByQuestionId(String questionId);

    Mono<Qualification> findByQuestionIdAndUserId(String questionId, String UserId);
}
