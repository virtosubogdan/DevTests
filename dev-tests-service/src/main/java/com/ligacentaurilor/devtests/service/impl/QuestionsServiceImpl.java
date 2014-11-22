package com.ligacentaurilor.devtests.service.impl;


import com.ligacentaurilor.devtests.data.dao.QuestionDAO;
import com.ligacentaurilor.devtests.data.entities.Question;
import com.ligacentaurilor.devtests.service.QuestionsService;
import com.ligacentaurilor.devtests.service.transport.QuestionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<QuestionTO> getQuestions() {
        List<QuestionTO> questionTOs = new LinkedList<>();
        for (Question question : questionDAO.getQuestions()) {
            QuestionTO questionTO = new QuestionTO();
            questionTO.setContent(question.getContent());
            questionTO.setId(question.getId());
            questionTO.setName(question.getName());
            questionTOs.add(questionTO);
        }
        return questionTOs;
    }
}
