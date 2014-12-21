package com.ligacentaurilor.devtests.data.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "TEST_QUESTIONS")
public class TestQuestion {

    public static enum Status {NOT_ANSWERED, ANSWERED, CORRECT, FALSE}

    @EmbeddedId
    private TestQuestionPK embeddedId;

    @Enumerated(EnumType.STRING)
    private Status status;

    public TestQuestionPK getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(TestQuestionPK embeddedId) {
        this.embeddedId = embeddedId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestQuestion{" +
                "embeddedId=" + embeddedId +
                ", status=" + status +
                '}';
    }
}
