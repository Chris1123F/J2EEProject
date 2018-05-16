package com.nju.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="checklist")
public class Checklist implements Serializable {
    @Id
    @Column(name="institutionid")
    private String institutionid;
    @Column(name="password")
    private String password;
    @Column(name="address")
    private String address;
    @Column(name="name")
    private  String name;
    @Id
    @Column(name="type")
    private  int type;//1注册 2修改
    @Column(name="ischecked")
    private int ischecked;//0未审核 1未通过 2已通过

    public Checklist() {
    }

    public Checklist(String institutionid, String password, String address, String name, int type) {
        this.institutionid = institutionid;
        this.password = password;
        this.address = address;
        this.name = name;
        this.type = type;
    }

    public int getIschecked() {
        return ischecked;
    }

    public void setIschecked(int ischecked) {
        this.ischecked = ischecked;
    }

    public String getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(String institutionid) {
        this.institutionid = institutionid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
