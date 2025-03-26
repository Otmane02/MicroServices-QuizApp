package com.aababou.quizapp.dao;

import com.aababou.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
author otman
    */
@Repository

public interface QuestionRepo extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);


    @Query(value="SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT CAST(:numQ AS INTEGER)", nativeQuery=true)
    List<Question> findRandomQuestionByCategory(@Param("category") String category, @Param("numQ") int numQ);


}
