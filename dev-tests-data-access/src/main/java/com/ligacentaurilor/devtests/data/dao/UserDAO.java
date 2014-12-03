package com.ligacentaurilor.devtests.data.dao;


import com.ligacentaurilor.devtests.data.entities.User;
import org.springframework.data.repository.Repository;

public interface UserDAO extends Repository<User, Long> {

    Iterable<User> findAll();
}
