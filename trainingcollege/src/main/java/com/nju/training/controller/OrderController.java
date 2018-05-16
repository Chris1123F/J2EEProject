package com.nju.training.controller;

import com.nju.training.dao.CourseDao;
import com.nju.training.dao.StudentDao;
import com.nju.training.model.Course;
import com.nju.training.model.Order;
import com.nju.training.model.Student;
import com.nju.training.service.OrderService;
import com.nju.training.util.ResultMessage.OrderMessage;
import com.nju.training.util.ResultMessage.PasswordMessage;
import com.nju.training.util.ResultMessage.StudentMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.nju.training.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseDao courseDao;

    @PostMapping("/add")
    public Order addOrder(@RequestBody Student student, @RequestParam String courseid, @RequestParam String point,
                                 @RequestParam String studentnumber, @RequestParam String classnumber){
        Course course = courseDao.getCourseById(courseid);
        return orderService.addOrder(student,course,point,studentnumber,classnumber);
    };

    @PostMapping("/add/offline")
    public Order addOffline(@RequestParam String studentid, @RequestParam String courseid,
                          @RequestParam String studentnumber, @RequestParam String classnumber){
        Student student = studentDao.GetInfoById(studentid);
        Course course = courseDao.getCourseById(courseid);
        return orderService.addOrder(student,course,"0",studentnumber,classnumber);
    };

    @PostMapping("/delete")
    public OrderMessage deleteOrder(@RequestBody Order order){
        return orderService.deleteOrder(order);
    };

    @PostMapping("/pay")
    public OrderMessage payOrder(@RequestBody  Order order){
        return orderService.payOrder(order);
    };

    @PostMapping("/dispay")
    public OrderMessage dispayOrder(@RequestBody Order order){
        return orderService.dispayOrder(order);
    };

    @GetMapping("/info/{id}")
    public Order getOrder(@PathVariable  String id){
        return orderService.getOrder(id);
    };


}
