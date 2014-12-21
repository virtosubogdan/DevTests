package com.ligacentaurilor.devtests.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 */
@Embeddable
public class TestQuestionPK implements Serializable {

    @Column
    private Long number;

    @ManyToOne
    @JoinColumn(name = "TEST_ID")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestQuestionPK that = (TestQuestionPK) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;
        if (test != null ? !test.equals(that.test) : that.test != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (test != null ? test.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestQuestionPK{" +
                "number=" + number +
                ", test=" + test +
                ", question=" + question +
                '}';
    }
}
