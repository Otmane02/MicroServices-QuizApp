package com.aababou.quizapp.service;

import com.aababou.quizapp.dao.QuestionRepo;
import com.aababou.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
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
}
