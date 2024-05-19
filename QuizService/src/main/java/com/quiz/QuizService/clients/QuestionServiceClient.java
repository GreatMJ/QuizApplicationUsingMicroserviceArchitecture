package com.quiz.QuizService.clients;

import com.quiz.QuizService.modals.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082", value = "Question-Client")  not using loadbalancer

// using loadbalancer
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionServiceClient {
    @GetMapping("/questions/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);
}
