package com.ligacentaurilor.devtests.service.impl;


import com.ligacentaurilor.devtests.data.dao.UserDAO;
import com.ligacentaurilor.devtests.data.entities.User;
import com.ligacentaurilor.devtests.service.UserService;
import com.ligacentaurilor.devtests.service.transport.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserTO> getAllUsers() {
        List<UserTO> userTOs = new LinkedList<>();
        for (User user : userDAO.getAll()) {
            UserTO userTO = new UserTO();
            userTO.setId(user.getId());
            userTO.setUsername(user.getUsername());
            userTO.setFirstname(user.getFirstname());
            userTO.setLastname(user.getLastname());
            userTO.setEmail(user.getEmail());
            userTOs.add(userTO);
        }
        return userTOs;
    }
}
