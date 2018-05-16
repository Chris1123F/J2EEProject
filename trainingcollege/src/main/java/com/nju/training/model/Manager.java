package com.nju.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="manager")
public class Manager implements Serializable{
    @Id
    @Column(name ="managerid")
    private String ManagerId;
    @Column(name ="psword")
    private String psword;
    @Column(name ="id")
    private String id;//账户？
    @Column(name ="balance")
    private String balance;
    @Column(name ="type")
    private String type;

    public Manager() {
    }

    public Manager(String managerId, String psword, String id, String balance, String type) {
        ManagerId = managerId;
        this.psword = psword;
        this.id = id;
        this.balance = balance;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManagerId() {
        return ManagerId;
    }

    public void setManagerId(String managerId) {
        ManagerId = managerId;
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword;
    }
}
