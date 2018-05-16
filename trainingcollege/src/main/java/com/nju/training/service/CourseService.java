package com.nju.training.service;

import com.nju.training.model.Course;
import com.nju.training.util.ResultMessage.CourseMessage;
import com.nju.training.util.ResultMessage.LessonMessage;

import java.sql.Date;
import java.util.List;

public interface CourseService {
    public LessonMessage addCourse(String institutionid, String startday, int coursehour, int weeknumber, String coursename,
                                   String teacherid, int capacity, double price, String type, String description);

    public LessonMessage updateCourse(String courseid, String institutionid, Date startday, int coursehour, int weeknumber, String coursename,
                                      String teacherid, int capacity, double price, String type, String description);

    public List searchCourse(String keyword);

    public CourseMessage checkAttendence(String courseid, String studentid, int attendence, int mark);

}
