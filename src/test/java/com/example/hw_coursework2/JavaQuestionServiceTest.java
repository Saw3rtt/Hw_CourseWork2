package com.example.hw_coursework2;

import com.example.hw_coursework2.dto.Question;
import com.example.hw_coursework2.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService underTest = new JavaQuestionService();

    Question question1 = new Question("Q1", "A1");
    Question question2 = new Question("Q2", "A2");


    @Test
    void add__questionAddedAndReturned() {
        Question result = underTest.add(question1.getQuestion(), question1.getAnswer());

        assertTrue(underTest.getAll().contains(question1));
        assertEquals(question1, result);


    }

    @Test
    void remove__questionRemoved() {
        underTest.add(question1);
        Question removedQuestion = underTest.remove(question1);

        Assertions.assertNotNull(removedQuestion);

        assertEquals("Q1", removedQuestion.getQuestion());
        assertEquals("A1", removedQuestion.getAnswer());
    }

    @Test
    void getAll_questionsAreInList_listWithQuestionReturned() {
        underTest.add(question1);
        underTest.add(question2);

        Collection<Question> result = underTest.getAll();

        Assertions.assertEquals(List.of(question1, question2), result);
        Assertions.assertTrue(result.containsAll(Set.of(question1, question2)));
    }

    @Test
    void getRandomQuestion__questionAndRandomQuestionReturned() {
        underTest.add(question1);
        underTest.add(question2);

        Question result = underTest.getRandomQuestion();

        Assertions.assertTrue(result.equals(question1) || result.equals(question2));
    }
}