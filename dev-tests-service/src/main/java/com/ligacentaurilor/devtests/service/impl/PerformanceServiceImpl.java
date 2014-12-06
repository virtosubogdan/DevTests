package com.ligacentaurilor.devtests.service.impl;

import com.ligacentaurilor.devtests.data.dao.QuestionDAO;
import com.ligacentaurilor.devtests.data.dao.UserDAO;
import com.ligacentaurilor.devtests.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public Long getNumberOfUsers() {
        return userDAO.count();
    }

    @Override
    public Long getNumberOfQuestions() {
        return questionDAO.count();
    }

    @Override
    public Long getSurvivorRecord() {
        return 0L;
    }
}
