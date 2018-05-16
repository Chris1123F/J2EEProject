package com.nju.training.dao;

import com.nju.training.model.Course;
import com.nju.training.model.Mark;
import com.nju.training.util.ResultMessage.CourseMessage;
import com.nju.training.util.ResultMessage.LessonMessage;

import java.util.List;

public interface CourseDao {
    public int getCourseLength();

    public Course getCourseById(String courseId);

    public LessonMessage addCourse(Course course);

    public LessonMessage updateCourse(Course course);

    public List searchCourse(String keyword);

    public CourseMessage addMark(String courseid, String studentid, int attendence, int mark);

    public List<Mark> searchStudentList(String id);

    public List<Course> searchStudentCourse(String id);


}
