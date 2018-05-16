package com.nju.training.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="institution")
public class Institution implements Serializable{
    @Id
    @Column(name ="institutionid")
    private String InstitutionId;
    @Column(name ="psword")
    private String psword;
    @Column(name ="address")
    private String address;
    @Column(name ="institutionname")
    private String InstitutionName;

    public Institution() {
    }

    public Institution(String institutionId, String psword, String address, String institutionName) {
        InstitutionId = institutionId;
        this.psword = psword;
        this.address = address;
        InstitutionName = institutionName;
    }

    public String getInstitutionId() {
        return InstitutionId;
    }

    public void setInstitutionId(String institutionId) {
        InstitutionId = institutionId;
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInstitutionName() {
        return InstitutionName;
    }

    public void setInstitutionName(String institutionName) {
        InstitutionName = institutionName;
    }
}
