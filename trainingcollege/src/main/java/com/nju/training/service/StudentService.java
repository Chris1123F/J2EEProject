package com.nju.training.service;

import com.nju.training.model.Student;
import com.nju.training.util.ResultMessage.PasswordMessage;
import com.nju.training.util.ResultMessage.StudentMessage;

import java.util.List;

public interface StudentService {


    public Student addStudent(String email, String name, String gender, String password,String input);

    public void sendCaptcha(String email);

    public StudentMessage updateName(Student student, String name);

    public StudentMessage updateGender(Student student, String gender);

    public PasswordMessage updatePassword(Student student, String rawpsword, String newpsword);

    public StudentMessage cancelStudent(Student student);


    public Student getInfo(String id);

    public String  getPassword(String id);

    public Student studentLogin(String id,String password);

    public List getOrderList(String id);

    public List getMarkList(String id);

    public List getCourseList(String id);


}
