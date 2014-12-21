package com.ligacentaurilor.devtests.data.dao;


import com.ligacentaurilor.devtests.data.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
