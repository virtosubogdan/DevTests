package com.ligacentaurilor.devtests.data.dao;


import com.ligacentaurilor.devtests.data.entities.Question;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface QuestionDAO extends Repository<Question, Long> {

    List<Question> findAll();

    Long count();
}
