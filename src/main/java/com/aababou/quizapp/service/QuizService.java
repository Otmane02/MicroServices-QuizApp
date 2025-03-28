package com.aababou.quizapp.service;

import com.aababou.quizapp.dao.QuestionRepo;
import com.aababou.quizapp.dao.QuizRepo;
import com.aababou.quizapp.model.Question;
import com.aababou.quizapp.model.QuestionWrapper;
import com.aababou.quizapp.model.Quiz;
import com.aababou.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {

      Optional<Quiz> quiz = quizRepo.findById(id);
      List<Question> questionList = quiz.get().getQuestions();
      List<QuestionWrapper> questionForUser = new ArrayList<>();
      for (Question q : questionList) {
          QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
      }
      return new ResponseEntity<>(questionForUser, HttpStatus.OK);



    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questionList = quiz.get().getQuestions();
        int right = 0;
        int i = 0;
        for (Response r : responses) {
            if (r.getResponse().equals(questionList.get(i).getRightAnswer()))
              right++;

            i++;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);


    }

}
