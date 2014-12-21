package com.ligacentaurilor.devtests.service.impl;


import com.ligacentaurilor.devtests.data.dao.RoleDAO;
import com.ligacentaurilor.devtests.data.dao.UserDAO;
import com.ligacentaurilor.devtests.data.entities.Role;
import com.ligacentaurilor.devtests.data.entities.RolePK;
import com.ligacentaurilor.devtests.data.entities.User;
import com.ligacentaurilor.devtests.service.UserService;
import com.ligacentaurilor.devtests.service.transport.RegisterTO;
import com.ligacentaurilor.devtests.service.transport.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(value = "devTestsSpringDataTransactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserTO> getAllUsers() {
        List<UserTO> userTOs = new LinkedList<>();
        for (User user : userDAO.findAll()) {
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

    @Override
    @Transactional(value = "devTestsSpringDataTransactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userDAO.findByUsername(auth.getName());
    }

    @Override
    @Transactional(value = "devTestsSpringDataTransactionManager", propagation = Propagation.SUPPORTS)
    public void register(RegisterTO registerRequest) {
        if (userDAO.findByUsername(registerRequest.getUsername()) != null) {
            throw new RuntimeException("Duplicate username");
        }
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setFirstname(registerRequest.getFirstname());
        newUser.setLastname(registerRequest.getLastname());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User createdUser = userDAO.save(newUser);
        addRole(createdUser, Role.Authority.ROLE_USER);
    }

    private void addRole(User user, Role.Authority authority) {
        RolePK rolePK = new RolePK();
        rolePK.setAuthority(authority);
        rolePK.setUser(user);
        Role role = new Role();
        role.setEmbeddedId(rolePK);
        roleDAO.save(role);
    }
}
