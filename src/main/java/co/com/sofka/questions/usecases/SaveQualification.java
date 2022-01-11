package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.QualificationDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveQualification {
    Mono<String> apply(@Valid QualificationDTO qualificationDTO);
}
