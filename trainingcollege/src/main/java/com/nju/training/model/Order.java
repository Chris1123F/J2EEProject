package com.nju.training.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="orders")
public class Order implements Serializable{
    @Id
    @Column(name ="orderid")
    private String orderid;
    @Column(name ="studentid")
    private String studentid;
    @Column(name="institutionid")
    private String institutionid;
    @Column(name ="courseid")
    private String courseid;
    @Column(name ="foundtime")
    private Date FoundTime;
    @Column(name ="state")
    private String State;//未支付 ；已取消；已支付；已退订
    @Column(name ="initialprice")
    private double InitialPrice;
    @Column(name ="lastprice")
    private double LastPrice;
    @Column(name ="point")
    private int point;//订单使用抵扣的积分

    //具体选课信息
    @Column(name="studentnumber")
    private int studentnumber;
    @Column(name="classnumber")
    private int classnumber;//0为随机选班


    public Order() {

    }


    public Order(String orderId, String studentId, String institutionid, String courseid, Date foundTime, String state,
                 double initialPrice, double lastPrice, int point, int studentnumber, int classnumber) {
        orderid = orderId;
        studentid = studentId;
        this.institutionid = institutionid;
        this.courseid = courseid;
        FoundTime = foundTime;
        State = state;
        InitialPrice = initialPrice;
        LastPrice = lastPrice;
        this.point = point;
        this.studentnumber = studentnumber;
        this.classnumber = classnumber;
    }

    public String getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(String institutionid) {
        this.institutionid = institutionid;
    }

    public String getOrderId() {
        return orderid;
    }

    public void setOrderId(String orderId) {
        orderid = orderId;
    }

    public String getStudentId() {
        return studentid;
    }

    public void setStudentId(String studentId) {
        studentid = studentId;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public Date getFoundTime() {
        return FoundTime;
    }

    public void setFoundTime(Date foundTime) {
        FoundTime = foundTime;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public double getInitialPrice() {
        return InitialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        InitialPrice = initialPrice;
    }

    public double getLastPrice() {
        return LastPrice;
    }

    public void setLastPrice(double lastPrice) {
        LastPrice = lastPrice;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(int studentnumber) {
        this.studentnumber = studentnumber;
    }

    public int getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(int classnumber) {
        this.classnumber = classnumber;
    }
}
