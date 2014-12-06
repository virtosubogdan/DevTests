package com.ligacentaurilor.devtests.presentation.controllers;

import com.ligacentaurilor.devtests.presentation.responses.StandardResponse;
import com.ligacentaurilor.devtests.service.PerformanceService;
import com.ligacentaurilor.devtests.service.transport.HomeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Controller
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @RequestMapping("/home")
    @ResponseBody
    public StandardResponse getHomeInfo() {
        HomeTO homeTO = new HomeTO();
        homeTO.setQuestions(performanceService.getNumberOfQuestions());
        homeTO.setUsers(performanceService.getNumberOfUsers());
        homeTO.setSurvivorNr(performanceService.getSurvivorRecord());

        return wrap(homeTO);
    }

    private <T extends Serializable> StandardResponse<T> wrap(T object) {
        StandardResponse standardResponse = new StandardResponse();
        standardResponse.addItem(object);
        return standardResponse;
    }
}
