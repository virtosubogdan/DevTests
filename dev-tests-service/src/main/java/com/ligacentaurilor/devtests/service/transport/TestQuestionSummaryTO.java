package com.ligacentaurilor.devtests.service.transport;

/**
 *
 */
public class TestQuestionSummaryTO {

    private Long number;
    private Long testId;
    private Long questionId;
    private String status;
    private String identifier;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestQuestionSummaryTO that = (TestQuestionSummaryTO) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (testId != null ? !testId.equals(that.testId) : that.testId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (testId != null ? testId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestQuestionSummaryTO{" +
                "number=" + number +
                ", testId=" + testId +
                ", questionId=" + questionId +
                ", status='" + status + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
