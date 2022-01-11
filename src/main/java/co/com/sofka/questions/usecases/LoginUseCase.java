package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.UserDTO;
import co.com.sofka.questions.reposioties.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class LoginUseCase {
    private final UserRepository userRepository;
    private final MapperUtils mapperUtils;

    public LoginUseCase(UserRepository userRepository, MapperUtils mapperUtils) {
        this.userRepository = userRepository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<UserDTO> apply(UserDTO userDTO) {

        return userRepository.findById(userDTO.getId())
                .switchIfEmpty(userRepository.save(mapperUtils.mapperToUser().apply(userDTO)))
                .flatMap(user -> Mono.just(mapperUtils.mapEntityToUser().apply(user)));

    }
}
