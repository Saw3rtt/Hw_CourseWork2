package com.example.hw_coursework2.service;

import com.example.hw_coursework2.dto.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questionList;

    private final Random random;

    public JavaQuestionService() {
        this.random = new Random();
        this.questionList = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question questionNew = new Question(question, answer);
        questionList.add(questionNew);
        return questionNew;
    }

    @Override
    public Question add(Question question) {
        questionList.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionList.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {
        return questionList.get(random.nextInt(questionList.size()));
    }
}
