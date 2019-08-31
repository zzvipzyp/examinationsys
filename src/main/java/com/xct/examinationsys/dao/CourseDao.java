package com.xct.examinationsys.dao;


import com.xct.examinationsys.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> findAllCourses(Course course);

    Course selectCourseById(Integer valueOf);

    void addCourse(Course course);

    void updateCourse(Course course);

    void delete(int[] id);
}
