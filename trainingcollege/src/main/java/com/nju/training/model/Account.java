package com.nju.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="account")
public class Account implements Serializable{
    @Id
    @Column(name ="id")
    private String id;
    @Column(name ="balance")
    private double balance;
    @Column(name="type")
    private  int type;//0学生 1机构 2manager

    public Account() {
    }

    public Account(String id, double balance, int type) {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
