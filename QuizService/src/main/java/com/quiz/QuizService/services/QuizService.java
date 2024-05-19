package com.quiz.QuizService.services;

import com.quiz.QuizService.modals.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add (Quiz quiz);

    List<Quiz> get();

    Quiz getOne(Long id);
}
