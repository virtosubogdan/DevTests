package com.ligacentaurilor.devtests.presentation.controllers;

import com.ligacentaurilor.devtests.service.TestsService;
import com.ligacentaurilor.devtests.service.transport.TestsSummaryTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tests")
public class TestsController {

    @Autowired
    private TestsService testsService;

    @RequestMapping
    @ResponseBody
    List<TestsSummaryTO> getTestsSummary() {
        return testsService.getTestsSummary();
    }

}
