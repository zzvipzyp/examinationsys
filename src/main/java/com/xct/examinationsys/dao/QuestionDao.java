package com.xct.examinationsys.dao;


import com.xct.examinationsys.entity.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAllQuestions(Question question);

    Question selectQuestionById(Integer valueOf);

    void addQuestion(Question question);

    void updateQuestion(Question question);

    void delete(int[] id);

    List<Question> getQuestions(String[] questionIds);
}
