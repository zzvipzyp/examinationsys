package com.xct.examinationsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xct.examinationsys.dao.PaperDao;
import com.xct.examinationsys.dao.QuestionDao;
import com.xct.examinationsys.entity.Paper;
import com.xct.examinationsys.entity.Question;
import com.xct.examinationsys.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Paper> findAllPapers(Map<String, Integer> pageMap, Paper paper) {
        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return paperDao.findAllPapers(paper);
    }

    @Override
    public Paper selectPaper(Integer id) {
        return paperDao.selectPaperById(id);
    }

    @Override
    public void addPaper(Paper paper) {
        paperDao.addPaper(paper);
    }

    @Override
    public void updatePaper(Paper paper) {
        paperDao.updatePaper(paper);
    }

    @Override
    public void delete(int[] id) {
        paperDao.delete(id);
    }

    @Override
    public List<Question> getQuestions(Integer paperId) {
        Paper paper = paperDao.findPaperById(paperId);
        if (paper == null) {
            throw new RuntimeException("没有此ID对应的试卷信息");
        }
        String[] questionIds = paper.getQuestionIds().split(",");
        return questionDao.getQuestions(questionIds);
    }

    @Override
    public Paper getPaperById(Integer paperId) {
        return paperDao.getPaperById(paperId);
    }

    @Override
    public void deleteOne(Integer paperId) {

        paperDao.deleteOne(paperId);

    }
}
