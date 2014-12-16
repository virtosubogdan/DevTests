package com.ligacentaurilor.devtests.service;

import com.ligacentaurilor.devtests.service.transport.TestsSummaryTO;

import java.util.List;

/**
 *
 */
public interface TestsService {

    List<TestsSummaryTO> getTestsSummary();
}
