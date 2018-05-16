package com.nju.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="student")
public class Student implements Serializable{
    @Id
    @Column(name ="studentid")
    private String StudentId;
    @Column(name ="name")
    private String name;
    @Column(name ="gender")
    private String gender;
    @Column(name ="email")
    private String email;
    @Column(name ="psword")
    private String psword;
    @Column(name="point")
    private int point;
    @Column(name="level")
    private int level;
    @Column(name="consume")
    private double consume;
    @Column(name="iscanceled")
    private int iscanceled;

    public Student() {
    }

    public Student(String studentId, String name, String gender, String email, String psword, int point, int level, double consume) {
        StudentId = studentId;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.psword = psword;
        this.point = point;
        this.level = level;
        this.consume = consume;
    }

    public Student(String name, String gender, String email, String psword) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.psword = psword;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getConsume() {
        return consume;
    }

    public void setConsume(double consume) {
        this.consume = consume;
    }

    public int getIscanceled() {
        return iscanceled;
    }

    public void setIscanceled(int iscanceled) {
        this.iscanceled = iscanceled;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword;
    }
}
