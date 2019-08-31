package com.xct.examinationsys.controller;

import com.github.pagehelper.Page;
import com.xct.examinationsys.entity.QuestionType;
import com.xct.examinationsys.service.QuestionTypeService;
import com.xct.examinationsys.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/questionType")
public class QuestionTypeController {

    @Autowired
    private QuestionTypeService questionTypeService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> listQuestionTypes(Integer page, Integer limit, QuestionType questionType) {
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<QuestionType> list = questionTypeService.findAllQuestionTypes(pageMap, questionType);

        long total = ((Page) list).getTotal();

        return PageUtil.pubPage(total, list);
    }
}
