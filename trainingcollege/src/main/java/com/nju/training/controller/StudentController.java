package com.nju.training.controller;



import com.nju.training.dao.AccountDao;
import com.nju.training.model.Account;
import com.nju.training.model.Student;
import com.nju.training.service.CourseService;
import com.nju.training.util.ResultMessage.PasswordMessage;
import com.nju.training.util.ResultMessage.StudentMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.nju.training.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @GetMapping(value="/info/{id}")
    public Student getInfo(@PathVariable String id){
        return studentService.getInfo(id);
    }

    @PostMapping("/register")
    public Student addStudent(@RequestParam String email,@RequestParam String name,@RequestParam String gender,@RequestParam String password,@RequestParam String input){
        return studentService.addStudent(email,name, gender,password,input);
    };

    @GetMapping("/sendcaptcha")
    public void sendCaptcha(@RequestParam String email){
        studentService.sendCaptcha(email);
    };

    @PostMapping("/update/info")
    public StudentMessage updateName(@RequestBody Student student, @RequestParam String name,@RequestParam String gender){
        studentService.updateGender(student,gender);
        return studentService.updateName(student,name);

    };

//    @PostMapping("/update/gender")
//    public StudentMessage updateGender(@RequestBody Student student, @RequestParam String gender){
//        return studentService.updateGender(student,gender);
//    };

    @PostMapping("/update/password")
    public PasswordMessage updatePassword(@RequestBody Student student, @RequestParam String rawpsword, @RequestParam String newpsword){
        return studentService.updatePassword(student,rawpsword,newpsword);
    };

    @PostMapping("/cancel")
    public StudentMessage cancelStudent(@RequestBody Student student){
        return studentService.cancelStudent(student);
    };

    @GetMapping("/getpassword")
    public String  getPassword(@RequestParam String id){
        return studentService.getPassword(id);
    };

    @GetMapping("/login")
    public Student login(@RequestParam String id,@RequestParam String password){
        return studentService.studentLogin(id,password);
    }

    @GetMapping("/{id}/orders")
    public List getOrderList(@PathVariable String id){
        return studentService.getOrderList(id);
    };

    @GetMapping("/{id}/marks")
    public List getMarkList(@PathVariable String id){
        return studentService.getMarkList(id);
    };

    @GetMapping("/{id}/courses")
    public List getCourseList(@PathVariable String id){
        return studentService.getCourseList(id);
    };

    @GetMapping("/search")
    public List searchCourse(@RequestParam String key){
        return courseService.searchCourse(key);
    };


}
