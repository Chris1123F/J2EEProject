package com.nju.training.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="mark")
public class Mark implements Serializable{
    @Id
    @Column(name="courseid")
    private String courseid;
    @Id
    @Column(name="studentid")
    private String studentid;
    @Column(name="attendence")
    private int attendence;
    @Column(name="mark")
    private  int mark;

    public Mark() {
    }

    public Mark(String courseid, String studentid, int attendence, int mark) {
        this.courseid = courseid;
        this.studentid = studentid;
        this.attendence = attendence;
        this.mark = mark;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
