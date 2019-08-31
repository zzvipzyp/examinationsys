package com.xct.examinationsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xct.examinationsys.dao.ExamDao;
import com.xct.examinationsys.entity.Exam;
import com.xct.examinationsys.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;

    @Override
    public List<Exam> findAllExams(Map<String, Integer> pageMap, Exam exam) {
        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return examDao.findAllExams(exam);
    }

    @Override
    public Exam selectExam(Integer id) {
        return examDao.selectExamById(id);
    }

    @Override
    public void addExam(Exam exam) {
        examDao.addExam(exam);
    }

    @Override
    public void updateExam(Exam exam) {
        examDao.updateExam(exam);
    }

    @Override
    public void delete(int[] id) {
        examDao.delete(id);
    }
}
