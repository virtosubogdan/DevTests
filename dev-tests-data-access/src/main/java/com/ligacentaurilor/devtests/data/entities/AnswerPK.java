package com.ligacentaurilor.devtests.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AnswerPK implements Serializable {

    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        AnswerPK answerPK = (AnswerPK) o;

        if (id != null ? !id.equals(answerPK.id) : answerPK.id != null) return false;
        if (question != null ? !question.equals(answerPK.question) : answerPK.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }
}
