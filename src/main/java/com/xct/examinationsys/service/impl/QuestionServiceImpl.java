package com.xct.examinationsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xct.examinationsys.dao.QuestionDao;
import com.xct.examinationsys.entity.Question;
import com.xct.examinationsys.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> findAllQuestions(Map<String, Integer> pageMap, Question question) {
        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return questionDao.findAllQuestions(question);
    }

    @Override
    public Question selectQuestion(Integer id) {
        return questionDao.selectQuestionById(id);
    }

    @Override
    public void addQuestion(Question question) {
        questionDao.addQuestion(question);
    }

    @Override
    public void updateQuestion(Question question) {
        questionDao.updateQuestion(question);
    }

    @Override
    public void delete(int[] id) {
        questionDao.delete(id);
    }
}
