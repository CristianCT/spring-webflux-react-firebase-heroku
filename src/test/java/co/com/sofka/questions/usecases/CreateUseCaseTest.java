package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

class CreateUseCaseTest {

    QuestionRepository questionRepository;
    CreateUseCase createUseCase;
    MapperUtils mapperUtils;

    @BeforeEach
    public void setup(){
        questionRepository = mock(QuestionRepository.class);
        mapperUtils = new MapperUtils();

        createUseCase = new CreateUseCase(mapperUtils, questionRepository);
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

        /*
        when(questionRepository.save(question)).thenReturn(Mono.just(question));
        StepVerifier.create(createUseCase.apply(questionDTO))
                .verifyComplete();

        verify(questionRepository).save(question);*/

    }
}