package com.ligacentaurilor.devtests.service;

import com.ligacentaurilor.devtests.service.transport.QuestionTO;

import java.util.List;

public interface QuestionsService {

    public List<QuestionTO> getQuestions();
}
