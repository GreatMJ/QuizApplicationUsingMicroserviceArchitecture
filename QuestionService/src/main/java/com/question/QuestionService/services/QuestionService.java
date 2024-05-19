package com.question.QuestionService.services;

import com.question.QuestionService.modals.Question;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {

    Question add(Question question);
    List<Question> get();
    Question getOne(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}
