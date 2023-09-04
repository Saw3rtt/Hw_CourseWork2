package com.example.hw_coursework2.controller;

import com.example.hw_coursework2.dto.Question;
import com.example.hw_coursework2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaController {
    private final QuestionService questionservice;

    public JavaController(QuestionService questionservice) {
        this.questionservice = questionservice;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionservice.add(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestion() {
        return questionservice.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionservice.remove(new Question(question, answer));
    }
}
