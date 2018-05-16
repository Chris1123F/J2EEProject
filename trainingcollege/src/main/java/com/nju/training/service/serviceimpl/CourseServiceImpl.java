package com.nju.training.service.serviceimpl;

import com.nju.training.dao.CourseDao;
import com.nju.training.logic.SetId;
import com.nju.training.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nju.training.service.CourseService;
import com.nju.training.util.ResultMessage.CourseMessage;
import com.nju.training.util.ResultMessage.LessonMessage;

import java.sql.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public LessonMessage addCourse( String institutionid, String startday,int coursehour, int weeknumber, String coursename,
                                   String teacherid, int capacity, double price, String type, String description) {
        String courseid=new SetId().setCourseId(courseDao.getCourseLength());
        Date date=new Date(118,3,20);
        Course course=new Course( courseid,  institutionid,date,  coursehour,  weeknumber, coursename,
                teacherid,  capacity, price,  type, description);
        return courseDao.addCourse(course);
    }

    @Override
    public LessonMessage updateCourse(String courseid, String institutionid, Date startday,int coursehour, int weeknumber, String coursename,
                                      String teacherid, int capacity, double price, String type, String description) {
        Course course=new Course( courseid, institutionid, startday, coursehour,  weeknumber, coursename,  teacherid,
        capacity, price,  type, description);
        return courseDao.updateCourse(course);
    }

    @Override
    public List searchCourse(String keyword) {
        return courseDao.searchCourse(keyword);
    }

    @Override
    public CourseMessage checkAttendence(String courseid,String studentid,int attendence, int mark) {
        return courseDao.addMark(courseid,studentid,attendence,mark);
    }
}
