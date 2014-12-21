package com.ligacentaurilor.devtests.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AnswerPK implements Serializable {

    @Column(name = "ANSWER_NR")
    private Long answerNr;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(Long answerNr) {
        this.answerNr = answerNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerPK answerPK = (AnswerPK) o;

        if (answerNr != null ? !answerNr.equals(answerPK.answerNr) : answerPK.answerNr != null) return false;
        if (question != null ? !question.equals(answerPK.question) : answerPK.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = answerNr != null ? answerNr.hashCode() : 0;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AnswerPK{" +
                "answerNr=" + answerNr +
                ", question=" + question +
                '}';
    }
}
