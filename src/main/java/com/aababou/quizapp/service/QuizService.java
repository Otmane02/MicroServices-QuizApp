package com.aababou.quizapp.service;

import com.aababou.quizapp.dao.QuestionRepo;
import com.aababou.quizapp.dao.QuizRepo;
import com.aababou.quizapp.model.Question;
import com.aababou.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
author otman
    */
@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;




    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questionList = questionRepo.findRandomQuestionByCategory(category,numQ);


        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
    }
}
