package co.com.sofka.questions.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VoteDTO {

    @NotNull
    @NotBlank
    private String userId;

    @NotNull
    @NotBlank
    private String questionId;

    @NotNull
    @NotBlank
    private String answerId;

    private Integer value;

    public VoteDTO() {
    }

    public VoteDTO(String userId, String questionId) {
        this.userId = userId;
        this.questionId = questionId;
    }

    public VoteDTO(String userId, String questionId, String answerId, Integer value) {
        this.userId = userId;
        this.questionId = questionId;
        this.answerId = answerId;
        this.value = value;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
