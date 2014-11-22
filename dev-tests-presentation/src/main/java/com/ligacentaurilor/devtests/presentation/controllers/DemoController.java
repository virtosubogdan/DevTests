package com.ligacentaurilor.devtests.presentation.controllers;

import com.ligacentaurilor.devtests.service.QuestionsService;
import com.ligacentaurilor.devtests.service.UserService;
import com.ligacentaurilor.devtests.service.transport.QuestionTO;
import com.ligacentaurilor.devtests.service.transport.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String getDemo() {
        return "test2";
    }

    @RequestMapping(value = "/questions")
    @ResponseBody
    List<QuestionTO> getQuestion() {
        return questionsService.getQuestions();
    }

    @RequestMapping(value = "/users")
    @ResponseBody
    List<UserTO> getUsers() {
        return userService.getAllUsers();
    }
}
