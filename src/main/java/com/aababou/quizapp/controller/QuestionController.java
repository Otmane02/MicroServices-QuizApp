package com.aababou.quizapp.controller;

/*
author otman
    */

import com.aababou.quizapp.model.Question;
import com.aababou.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/questions")
     public ResponseEntity< List<Question>>    getAllQuestions() {
        try {
            return  new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

                                              }
     @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
       return questionService.getQuestionsByCategory(category);
     }

     @PostMapping("addQuesion")
    public ResponseEntity <String> addQuestion(@RequestBody Question question) {
         return    questionService.addQuestion(question);
     }

}
