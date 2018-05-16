package com.nju.training.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="teacher")
public class Teacher implements Serializable {
    @Id
    @Column(name="teacherid")
    private String teacherid;
    @Column(name="teachername")
    private String teachername;
    @Column(name="institutionid")
    private  String institutionid;

    public Teacher(String teacherid, String teachername, String institutionid) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.institutionid = institutionid;
    }

    public String getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(String institutionid) {
        this.institutionid = institutionid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }
}
