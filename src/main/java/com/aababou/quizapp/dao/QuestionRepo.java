package com.aababou.quizapp.dao;

import com.aababou.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
author otman
    */
@Repository

public interface QuestionRepo extends JpaRepository<Question, Integer> {



}
