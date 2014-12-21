package com.ligacentaurilor.devtests.data.dao;

import com.ligacentaurilor.devtests.data.entities.Test;
import org.springframework.data.repository.Repository;

/**
 *
 */
public interface TestDAO extends Repository<Test, Long> {

    Iterable<Test> findAll();

    Test findOne(Long id);

    Long count();
}