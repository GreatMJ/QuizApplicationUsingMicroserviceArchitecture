package com.question.QuestionService.services.impl;

import com.question.QuestionService.modals.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionRepository questionRepository;
    @Autowired
    QuestionServiceImplementation(QuestionRepository questionRepository){
        this.questionRepository=questionRepository;
    }
    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        List<Question>questionList=questionRepository.findByQuizId(quizId);
       
        return questionList;
    }
}
