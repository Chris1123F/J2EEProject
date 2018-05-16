package com.nju.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name ="course")
public class Course implements Serializable{
    @Id
    @Column(name="courseid")
    private String courseid;
    @Column(name="institutionid")
    private String institutionid;
    @Column(name="startday")
    private Date startday;
    @Column(name ="coursehour")
    private int coursehour;
    @Column(name ="weeknumber")
    private int weeknumber;
    @Column(name ="coursename")
    private String coursename;
    @Column(name ="teacherid")
    private String teacherid;
    @Column(name ="capacity")
    private int capacity;
    @Column(name ="price")
    private double Price;
    @Column(name ="type")
    private String type;//关键字 考研|英语/
    @Column(name ="description")
    private String description;

    public Course() {
    }

    public Course(String courseid, String institutionid, Date startday, int coursehour, int weeknumber,
                  String coursename, String teacherid, int capacity, double price, String type, String description) {
        this.courseid = courseid;
        this.institutionid = institutionid;
        this.startday = startday;
        this.coursehour = coursehour;
        this.weeknumber = weeknumber;
        this.coursename = coursename;
        this.teacherid = teacherid;
        this.capacity = capacity;
        Price = price;
        this.type = type;
        this.description = description;
    }


    public Date getStartday() {
        return startday;
    }

    public void setStartday(Date startday) {
        this.startday = startday;
    }

    public String getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(String institutionid) {
        this.institutionid = institutionid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public int getCoursehour() {
        return coursehour;
    }

    public void setCoursehour(int coursehour) {
        this.coursehour = coursehour;
    }

    public int getWeeknumber() {
        return weeknumber;
    }

    public void setWeeknumber(int weeknumber) {
        this.weeknumber = weeknumber;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
