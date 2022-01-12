package co.com.sofka.questions.usecases;

import co.com.sofka.questions.reposioties.AnswerRepository;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteUseCaseTest {

    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    DeleteUseCase deleteUseCase;

    @BeforeEach
    public void setup(){
        answerRepository = mock(AnswerRepository.class);
        questionRepository = mock(QuestionRepository.class);

        deleteUseCase = new DeleteUseCase(answerRepository, questionRepository);
    }

    @Test
    void getValidationTest(){

        String questionId = "xxxx";
        when(questionRepository.deleteById(questionId)).thenReturn(Mono.empty());
        when(answerRepository.deleteByQuestionId(questionId)).thenReturn(Mono.empty());

        StepVerifier.create(deleteUseCase.apply(questionId))
                .verifyComplete();

        verify(questionRepository).deleteById(questionId);
        verify(answerRepository).deleteByQuestionId(questionId);
    }
}