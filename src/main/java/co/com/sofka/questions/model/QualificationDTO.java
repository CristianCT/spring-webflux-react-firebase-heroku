package co.com.sofka.questions.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QualificationDTO {

    @NotNull
    @NotBlank
    private String userId;

    @NotNull
    @NotBlank
    private String questionId;

    private Integer value;

    public QualificationDTO() {
    }

    public QualificationDTO(String userId, String questionId, Integer value) {
        this.userId = userId;
        this.questionId = questionId;
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
