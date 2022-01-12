package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.reposioties.AnswerRepository;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetUseCaseTest {

    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    GetUseCase getUseCase;

    @BeforeEach
    public void setup(){
        MapperUtils mapperUtils = new MapperUtils();
        questionRepository = mock(QuestionRepository.class);
        answerRepository = mock(AnswerRepository.class);
        getUseCase = new GetUseCase(mapperUtils, questionRepository, answerRepository);
    }

    @Test
    void getvalidationTest(){
        var question = new Question();
        question.setId("xxxx");
        question.setUserId("xxxxuser");
        question.setType("tech");
        question.setCategory("software");
        question.setQuestion("¿Que es java?");

        var answer = new Answer();
        answer.setId("xxxxanswer");
        answer.setUserId("xxxxuseranswer");
        answer.setQuestionId("xxxx");
        answer.setAnswer("answer");
        when(answerRepository.findAllByQuestionId("xxxx")).thenReturn(Flux.just(answer));
        when(questionRepository.findById("xxxx")).thenReturn(Mono.just(question));

        StepVerifier.create(getUseCase.apply("xxxx"))
                .expectNextMatches(questionDTO -> {
                    assert questionDTO.getId().equals("xxxx");
                    assert questionDTO.getUserId().equals("xxxxuser");
                    assert questionDTO.getQuestion().equals("¿Que es java?");
                    assert questionDTO.getCategory().equals("software");
                    assert questionDTO.getType().equals("tech");
                    assert questionDTO.getAnswers().get(0).getId().equals("xxxxanswer");
                    assert questionDTO.getAnswers().get(0).getAnswer().equals("answer");
                    assert questionDTO.getAnswers().get(0).getQuestionId().equals("xxxx");
                    assert questionDTO.getAnswers().get(0).getUserId().equals("xxxxuseranswer");
                    return true;
                })
                .verifyComplete();

        verify(questionRepository).findById("xxxx");
        verify(answerRepository).findAllByQuestionId("xxxx");
    }
}