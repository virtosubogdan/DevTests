package com.ligacentaurilor.devtests.presentation.controllers;

import com.ligacentaurilor.devtests.service.UserService;
import com.ligacentaurilor.devtests.service.transport.RegisterTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@Controller
@RequestMapping("/main")
public class MaintenanceController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    @ResponseStatus(value = HttpStatus.OK)
    public void getHomeInfo(@RequestBody RegisterTO registerRequest) {
        userService.register(registerRequest);
    }
}
