package com.question.QuestionService.controllers;

import com.question.QuestionService.modals.Question;
import com.question.QuestionService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;
  @Autowired
    QuestionController(QuestionService questionService){
        this.questionService=questionService;
    }

    @PostMapping
    public Question add(@RequestBody Question question){
        return questionService.add(question);
    }

    @GetMapping
    public List<Question> get(){
        return questionService.get();
    }

    @GetMapping("/{id}")
    public  Question getOne(@PathVariable Long id){
        return questionService.getOne(id);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getQuestionsOfQuiz(@PathVariable Long quizId){
      List<Question> questionList=questionService.getQuestionsOfQuiz(quizId);
//      if(questionList.size()==0){
////           throw  new RuntimeException("No questions available in this quiz");
//          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//      }
      return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
}
