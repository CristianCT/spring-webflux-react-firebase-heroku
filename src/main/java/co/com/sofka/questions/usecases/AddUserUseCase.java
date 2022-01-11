package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.User;
import co.com.sofka.questions.model.UserDTO;
import co.com.sofka.questions.reposioties.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class AddUserUseCase implements SaveUser {
    private final UserRepository userRepository;
    private final MapperUtils mapperUtils;

    public AddUserUseCase(UserRepository userRepository, MapperUtils mapperUtils) {
        this.userRepository = userRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<UserDTO> apply(UserDTO userDTO) {
        return userRepository
                .save(mapperUtils.mapperToUser().apply(userDTO))
                .flatMap(user -> Mono.just(mapperUtils.mapEntityToUser().apply(user)));
    }
}
