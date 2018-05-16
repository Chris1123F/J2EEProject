package com.nju.training.dao;

import com.nju.training.model.Student;
import com.nju.training.util.ResultMessage.StudentMessage;

import java.util.List;

public interface StudentDao {
    public int getStudentLength();

    public List getAllStudents();

    public StudentMessage AddStudent(Student student);

    public StudentMessage UpdateStudent(Student student);

    public String GetPswordById(String id);

    public Student GetInfoById(String id);

    public List GetOrderById(String id);


}
