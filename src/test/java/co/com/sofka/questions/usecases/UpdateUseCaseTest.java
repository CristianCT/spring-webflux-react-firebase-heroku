package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateUseCaseTest {

    QuestionRepository questionRepository;
    UpdateUseCase updateUseCase;

    @BeforeEach
    public void setup(){
        questionRepository = mock(QuestionRepository.class);
        MapperUtils mapperUtils = new MapperUtils();

        updateUseCase = new UpdateUseCase(mapperUtils, questionRepository);
    }

    @Test
    public void getValidationTest(){
        var question =  new Question();
        question.setId("xxxx");
        question.setUserId("xxxxuser");
        question.setType("Type");
        question.setCategory("Category");
        question.setQuestion("Question");

        QuestionDTO questionDTO = new QuestionDTO(
                "xxxx",
                "xxxxuser",
                "Question",
                "Type",
                "Category"
        );

        when(questionRepository.save(question)).thenReturn(Mono.just(question));

        /*
        StepVerifier.create(updateUseCase.apply(questionDTO))
                .expectNextMatches(value -> {
                    assert value.equals("xxxx");
                    return true;
                })
                .verifyComplete();

        verify(questionRepository).save(question); */
    }
}