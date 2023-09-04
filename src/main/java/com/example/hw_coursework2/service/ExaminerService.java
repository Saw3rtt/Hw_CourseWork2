package com.example.hw_coursework2.service;

import com.example.hw_coursework2.dto.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
