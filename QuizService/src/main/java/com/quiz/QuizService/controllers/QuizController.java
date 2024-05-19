package com.quiz.QuizService.controllers;

import com.quiz.QuizService.modals.Quiz;
import com.quiz.QuizService.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService){
        this.quizService=quizService;
    }

    @PostMapping
    public Quiz add(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> get(){
        return quizService.get();
    }

    @GetMapping("/{id}")
    public  Quiz getOne(@PathVariable Long id){
        return quizService.getOne(id);
    }

}
