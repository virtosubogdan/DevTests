package com.ligacentaurilor.devtests.service.impl;

import com.ligacentaurilor.devtests.data.dao.TestDAO;
import com.ligacentaurilor.devtests.data.entities.Test;
import com.ligacentaurilor.devtests.data.entities.TestQuestion;
import com.ligacentaurilor.devtests.service.TestsService;
import com.ligacentaurilor.devtests.service.UserService;
import com.ligacentaurilor.devtests.service.transport.TestQuestionSummaryTO;
import com.ligacentaurilor.devtests.service.transport.TestsSummaryTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class TestsServiceImpl implements TestsService {

    @Autowired
    private UserService userService;

    @Autowired
    private TestDAO testDAO;

    @Override
    @Transactional(value = "devTestsSpringDataTransactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TestsSummaryTO> getTestsSummary() {
        return userService.getCurrentUser().getTests()
                .stream().map(this::makeTestsSummaryTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(value = "devTestsSpringDataTransactionManager", readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TestQuestionSummaryTO> getTestSummary(Long testId) {
        Test test = testDAO.findOne(testId);
        if (test == null || !test.getUser().equals(userService.getCurrentUser())) {
            throw new AccessDeniedException("No access to test " + testId);
        }
        return test.getQuestions().stream().map(this::makeTestQuestionSummary).collect(Collectors.toList());
    }

    private TestQuestionSummaryTO makeTestQuestionSummary(TestQuestion testQuestion) {
        TestQuestionSummaryTO to = new TestQuestionSummaryTO();
        to.setTestId(testQuestion.getEmbeddedId().getTest().getId());
        to.setQuestionId(testQuestion.getEmbeddedId().getQuestion().getId());
        to.setNumber(testQuestion.getEmbeddedId().getNumber());
        to.setIdentifier("Question " + testQuestion.getEmbeddedId().getNumber());
        to.setStatus(testQuestion.getStatus().name());
        return to;
    }

    private TestsSummaryTO makeTestsSummaryTO(Test test) {
        TestsSummaryTO testsSummaryTO = new TestsSummaryTO();
        testsSummaryTO.setId(test.getId());
        testsSummaryTO.setName(test.getName());
        int answered = 0, total = 0, correct = 0;
        for (TestQuestion testQuestion : test.getQuestions()) {
            total++;
            switch (testQuestion.getStatus()) {
                case ANSWERED:
                case FALSE:
                    answered++;
                    break;
                case CORRECT:
                    answered++;
                    correct++;
                    break;
            }
        }
        if (answered == total) {
            testsSummaryTO.setStatus(String.format("%.2f%%", correct / total));
        } else {
            testsSummaryTO.setStatus(String.format("(%d/%d)", answered, total));
        }
        return testsSummaryTO;
    }
}
