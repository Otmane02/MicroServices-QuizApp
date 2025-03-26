package com.aababou.quizapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/*
author otman
    */

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String difficultyLevel;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String questionTitle;
    private String rightAnswer;
}







