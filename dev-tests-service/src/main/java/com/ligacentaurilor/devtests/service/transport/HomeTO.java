package com.ligacentaurilor.devtests.service.transport;

import java.io.Serializable;

public class HomeTO implements Serializable {

    private Long users;
    private Long questions;
    private Long survivorNr;

    public Long getUsers() {
        return users;
    }

    public void setUsers(Long users) {
        this.users = users;
    }

    public Long getQuestions() {
        return questions;
    }

    public void setQuestions(Long questions) {
        this.questions = questions;
    }

    public Long getSurvivorNr() {
        return survivorNr;
    }

    public void setSurvivorNr(Long survivorNr) {
        this.survivorNr = survivorNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeTO homeTO = (HomeTO) o;

        if (questions != null ? !questions.equals(homeTO.questions) : homeTO.questions != null) return false;
        if (survivorNr != null ? !survivorNr.equals(homeTO.survivorNr) : homeTO.survivorNr != null) return false;
        if (users != null ? !users.equals(homeTO.users) : homeTO.users != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = users != null ? users.hashCode() : 0;
        result = 31 * result + (questions != null ? questions.hashCode() : 0);
        result = 31 * result + (survivorNr != null ? survivorNr.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HomeTO{" +
                "users=" + users +
                ", questions=" + questions +
                ", survivorNr=" + survivorNr +
                '}';
    }
}
