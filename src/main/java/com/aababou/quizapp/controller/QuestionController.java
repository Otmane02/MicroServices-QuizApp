package com.aababou.quizapp.controller;

/*
author otman
    */

import com.aababou.quizapp.model.Question;
import com.aababou.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/questions")
public List<Question> getAllQuestions() {
   return questionService.getAllQuestions();
}

}
