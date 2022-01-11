package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.UserDTO;
import co.com.sofka.questions.reposioties.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class GetUserUseCase implements Function<String, Mono<UserDTO>> {
    private final MapperUtils mapperUtils;
    private final UserRepository userRepository;

    public GetUserUseCase(MapperUtils mapperUtils, UserRepository userRepository) {
        this.mapperUtils = mapperUtils;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDTO> apply(String id){
        Objects.requireNonNull(id, "Id is required");
        return userRepository.findById(id)
                .map(mapperUtils.mapEntityToUser())
                .flatMap(Mono::just);
    }
}
