package com.xct.examinationsys.dao;


import com.xct.examinationsys.entity.QuestionType;

import java.util.List;

public interface QuestionTypeDao {
    List<QuestionType> findAllQuestionTypes(QuestionType questionType);

    QuestionType selectQuestionTypeById(Integer valueOf);

    void addQuestionType(QuestionType questionType);

    void updateQuestionType(QuestionType questionType);

    void delete(int[] id);
}
