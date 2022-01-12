package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.*;
import co.com.sofka.questions.model.*;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<AnswerDTO, Answer> mapperToAnswer() {
        return updateAnswer -> {
            var answer = new Answer();
            answer.setPosition(updateAnswer.getPosition());
            answer.setQuestionId(updateAnswer.getQuestionId());
            answer.setUserId(updateAnswer.getUserId());
            answer.setAnswer(updateAnswer.getAnswer());
            return answer;
        };
    }

    public Function<QuestionDTO, Question> mapperToQuestion(String id) {
        return updateQuestion -> {
            var question = new Question();
            question.setId(id);
            question.setUserId(updateQuestion.getUserId());
            question.setCategory(updateQuestion.getCategory());
            question.setQuestion(updateQuestion.getQuestion());
            question.setType(updateQuestion.getType());
            return question;
        };
    }

    public Function<VoteDTO, Vote> mapperToVote() {
        return updateVote -> {
            var position = new Vote();
            position.setQuestionId(updateVote.getQuestionId());
            position.setAnswerId(updateVote.getAnswerId());
            position.setUserId(updateVote.getUserId());
            position.setValue(updateVote.getValue());
            return position;
        };
    }

    public Function<UserDTO, User> mapperToUser(){
        return updateUser -> {
            var user = new User();
            user.setId(updateUser.getId());
            user.setName(updateUser.getName());
            user.setLastName(updateUser.getLastName());
            user.setEmail(updateUser.getEmail());
            return user;
        };
    }

    public Function<QualificationDTO, Qualification> mapperToQualification(){
        return updateQualification -> {
            var qualification = new Qualification();
            qualification.setQuestionId(updateQualification.getQuestionId());
            qualification.setUserId(updateQualification.getUserId());
            qualification.setValue(updateQualification.getValue());
            return qualification;
        };
    }

    public Function<Question, QuestionDTO> mapEntityToQuestion() {
        return entity -> new QuestionDTO(
                entity.getId(),
                entity.getUserId(),
                entity.getQuestion(),
                entity.getType(),
                entity.getCategory(),
                entity.getQualification()
        );
    }

    public Function<Answer, AnswerDTO> mapEntityToAnswer() {
        return entity -> new AnswerDTO(
                entity.getId(),
                entity.getQuestionId(),
                entity.getUserId(),
                entity.getAnswer(),
                entity.getPosition()
        );
    }

    public Function<User, UserDTO> mapEntityToUser() {
        return entity -> new UserDTO(
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail()
        );
    }
}
