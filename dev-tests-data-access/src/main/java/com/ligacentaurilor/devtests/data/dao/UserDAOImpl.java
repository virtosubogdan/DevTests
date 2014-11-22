package com.ligacentaurilor.devtests.data.dao;


import com.ligacentaurilor.devtests.data.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        return getCurrentSession().createCriteria(User.class).list();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
