package com.xct.examinationsys.controller;


import com.github.pagehelper.Page;
import com.xct.examinationsys.entity.Paper;
import com.xct.examinationsys.entity.Question;
import com.xct.examinationsys.service.PaperService;
import com.xct.examinationsys.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> listPapers(Integer page, Integer limit, Paper paper) {
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<Paper> list = paperService.findAllPapers(pageMap, paper);

        long total = ((Page) list).getTotal();

        return PageUtil.pubPage(total, list);
    }

    @RequestMapping("/getQuestions")
    @ResponseBody
    public List<Question> getQuestions(Integer paperId) {
        return paperService.getQuestions(paperId);
    }

    @RequestMapping("/getPaperById")
    @ResponseBody
    public Paper getPaperById(Integer paperId) {
        return paperService.getPaperById(paperId);
    }
}
