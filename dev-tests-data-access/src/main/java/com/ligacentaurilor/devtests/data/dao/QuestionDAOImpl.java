package com.ligacentaurilor.devtests.data.dao;

import com.ligacentaurilor.devtests.data.entities.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<Question> getQuestions() {
        return getCurrentSession().createCriteria(Question.class).list();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
