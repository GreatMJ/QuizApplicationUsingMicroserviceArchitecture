

package com.quiz.QuizService.services.impl;

import com.quiz.QuizService.clients.QuestionServiceClient;
import com.quiz.QuizService.modals.Question;
import com.quiz.QuizService.modals.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;
import com.quiz.QuizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

class QuizServiceImplementation implements QuizService {
    private final QuizRepository quizRepository;
    private  final QuestionServiceClient questionServiceClient;
@Autowired
    public QuizServiceImplementation(QuizRepository quizRepository, QuestionServiceClient questionServiceClient) {
        this.quizRepository = quizRepository;
        this.questionServiceClient = questionServiceClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizList=quizRepository.findAll();
        for(Quiz quiz:quizList){
            List<Question> questionList=questionServiceClient.getQuestionsOfQuiz(quiz.getId());
            if(!questionList.isEmpty())  quiz.setQuestionList(questionList);
            else quiz.setQuestionList(Collections.emptyList());
        }
        return quizList;
    }

    @Override
    public Quiz getOne(Long id) {
        Quiz quiz=quizRepository.findById(id).orElseThrow(()->new RuntimeException("No quiz available with given id."));

        quiz.setQuestionList(questionServiceClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}

