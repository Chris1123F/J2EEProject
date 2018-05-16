package com.nju.training.controller;



import com.nju.training.dao.AccountDao;
import com.nju.training.model.Account;
import com.nju.training.model.Checklist;
import com.nju.training.model.Institution;
import com.nju.training.model.Student;
import com.nju.training.service.CourseService;
import com.nju.training.service.InstitutionService;
import com.nju.training.util.ResultMessage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.nju.training.service.StudentService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/institution")
public class InstitutionController {
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    InstitutionService institutionService;

    @GetMapping(value="/info/{id}")
    public Institution getInfo(@PathVariable String id){
        return institutionService.GetInfoById(id);
    }

    @PostMapping("/register")
    public Checklist addIns(@RequestParam String address, @RequestParam String name, @RequestParam String password){
        return institutionService.addInstitution(name, address, password);
    };


    @PostMapping("/update/info")
    public InstitutionMessage update(@RequestBody Institution institution,@RequestParam String name,@RequestParam String address){
        institution.setInstitutionName(name);
        institution.setAddress(address);
        return institutionService.updateInstitution(institution);

    };

    @PostMapping("/addmark")
    public CourseMessage addMark(@RequestParam String courseid, @RequestParam String studentid, @RequestParam int attendence, @RequestParam int mark){
        return courseService.checkAttendence(courseid,studentid,attendence,mark);
    };


    @PostMapping("/addcourse")
    public LessonMessage addCourse(@RequestParam String institutionid, @RequestParam String startday, @RequestParam int coursehour, @RequestParam int weeknumber, @RequestParam String coursename,
                                   @RequestParam  String teacherid, @RequestParam int capacity, @RequestParam double price, @RequestParam String type, @RequestParam String description){
        return courseService.addCourse(institutionid,startday,coursehour,weeknumber,coursename,teacherid,capacity,price,type,description);
    };

//    @PostMapping("/update/gender")
//    public StudentMessage updateGender(@RequestBody Student student, @RequestParam String gender){
//        return studentService.updateGender(student,gender);
//    };

//    @PostMapping("/update/password")
//    public PasswordMessage updatePassword(@RequestBody Student student, @RequestParam String rawpsword, @RequestParam String newpsword){
//        return studentService.updatePassword(student,rawpsword,newpsword);
//    };

//    @PostMapping("/cancel")
//    public StudentMessage cancelStudent(@RequestBody Student student){
//        return studentService.cancelStudent(student);
//    };

//    @GetMapping("/login")
//    public String  getPassword(@RequestParam String id){
//        return studentService.getPassword(id);
//    };

    @GetMapping("/login")
    public Institution login(@RequestParam String id,@RequestParam String password){
        return institutionService.login(id,password);
    }

    @GetMapping("/{id}/orders")
    public List getOrderList(@PathVariable String id){
        return institutionService.GetOrderById(id);
    };

    @GetMapping("/{id}/courses")
    public List getCourseList(@PathVariable String id){
        return institutionService.GetCourseById(id);
    };



}
