package com.xct.examinationsys.controller;


import com.github.pagehelper.Page;
import com.xct.examinationsys.entity.Course;
import com.xct.examinationsys.entity.Question;
import com.xct.examinationsys.service.CourseService;
import com.xct.examinationsys.service.QuestionService;
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
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> listCourses(Integer page, Integer limit, Course course) {
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<Course> list = courseService.findAllCourses(pageMap, course);

        long total = ((Page) list).getTotal();

        return PageUtil.pubPage(total, list);
    }
}
