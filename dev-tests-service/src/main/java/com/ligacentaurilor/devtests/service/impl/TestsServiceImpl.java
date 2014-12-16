package com.ligacentaurilor.devtests.service.impl;

import com.ligacentaurilor.devtests.data.entities.Test;
import com.ligacentaurilor.devtests.data.entities.User;
import com.ligacentaurilor.devtests.service.TestsService;
import com.ligacentaurilor.devtests.service.UserService;
import com.ligacentaurilor.devtests.service.transport.TestsSummaryTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@Service
public class TestsServiceImpl implements TestsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(value = "devTestsSpringDataTransactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TestsSummaryTO> getTestsSummary() {
        User user = userService.getCurrentUser();
        List<TestsSummaryTO> testsSummaryTOs = new LinkedList<>();
        for (Test test : user.getTests()) {
            TestsSummaryTO testsSummaryTO = new TestsSummaryTO();
            testsSummaryTO.setId(test.getId());
            testsSummaryTO.setName(test.getName());
            testsSummaryTOs.add(testsSummaryTO);
        }
        return testsSummaryTOs;
    }
}
