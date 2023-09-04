package com.example.hw_coursework2;

import com.example.hw_coursework2.dto.Question;
import com.example.hw_coursework2.exception.NotEnoughQuestions;
import com.example.hw_coursework2.service.ExaminerServiceImpl;
import com.example.hw_coursework2.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl underTest;

    Question question1 = new Question("Q1", "A1");
    Question question2 = new Question("Q2", "A2");

    @Test
    void getQuestions_enoughQuestionInList_setOfQuestionsReturned() {
        int amount = 2;
        Mockito.when(questionService.getAll()).thenReturn(List.of(question1, question2));
        Collection<Question> result = underTest.getQuestions(amount);
        Assertions.assertEquals(amount, result.size());
        Assertions.assertEquals(amount, result.stream().distinct().count());
    }

    @Test
    void getQuestions_NotEnoughQuestionsAvailable_ThrowsNotEnoughQuestions() {
        List<Question> availableQuestions = new ArrayList<>();
        availableQuestions.add(question1);
        Mockito.when(questionService.getAll()).thenReturn(availableQuestions);


        Assertions.assertThrows(NotEnoughQuestions.class, () -> underTest.getQuestions(2));
    }
}
