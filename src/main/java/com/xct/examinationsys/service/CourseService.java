package com.xct.examinationsys.service;

import com.xct.examinationsys.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {
    List<Course> findAllCourses(Map<String, Integer> pageMap, Course course);

    Course selectCourse(Integer id);

    void addCourse(Course course);

    void updateCourse(Course course);

    void delete(int[] id);
}
