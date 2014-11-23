package com.ligacentaurilor.devtests.data.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "ANSWERS")
public class Answer {

    @EmbeddedId
    private AnswerPK embeddedId;

    @Column(length = 4000)
    private String content;

    @Column(name = "IS_CORRECT", columnDefinition = "NUMBER(1,0)")
    private Boolean isCorrect;

    public AnswerPK getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(AnswerPK embeddedId) {
        this.embeddedId = embeddedId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "embeddedId=" + embeddedId +
                ", content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
