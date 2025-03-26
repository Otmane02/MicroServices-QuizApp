package com.aababou.quizapp.service;

import com.aababou.quizapp.dao.QuestionRepo;
import com.aababou.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
author otman
    */
@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepo.save(question);
        return   new ResponseEntity<>("Question added", HttpStatus.CREATED);
    }
}
