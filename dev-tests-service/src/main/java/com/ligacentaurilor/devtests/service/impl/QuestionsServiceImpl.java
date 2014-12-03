package com.ligacentaurilor.devtests.service.impl;


import com.ligacentaurilor.devtests.data.dao.QuestionDAO;
import com.ligacentaurilor.devtests.data.entities.Answer;
import com.ligacentaurilor.devtests.data.entities.Question;
import com.ligacentaurilor.devtests.service.QuestionsService;
import com.ligacentaurilor.devtests.service.transport.AnswerTO;
import com.ligacentaurilor.devtests.service.transport.QuestionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    @Transactional(value = "devTestsSpringDataTransactionManager", readOnly = true, propagation = Propagation.REQUIRED)
    public List<QuestionTO> getQuestions() {
        return questionDAO.findAll().stream()
                .map(this::getQuestionTO)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private QuestionTO getQuestionTO(Question question) {
        QuestionTO questionTO = new QuestionTO();
        questionTO.setContent(question.getContent());
        questionTO.setId(question.getId());
        questionTO.setName(question.getName());
        final List<AnswerTO> answerTOs = new LinkedList<>();
        question.getAnswers().stream().forEach(answer -> answerTOs.add(buildAnswerTO(answer)));
        questionTO.setAnswers(answerTOs);
        return questionTO;
    }

    private AnswerTO buildAnswerTO(Answer answer) {
        AnswerTO answerTO = new AnswerTO();
        answerTO.setContent(answer.getContent());
        answerTO.setIsCorrect(answer.getIsCorrect());
        return answerTO;
    }
}
