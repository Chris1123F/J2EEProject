package com.nju.training.service.serviceimpl;

import com.nju.training.dao.AccountDao;
import com.nju.training.dao.CourseDao;
import com.nju.training.dao.OrderDao;
import com.nju.training.dao.StudentDao;
import com.nju.training.logic.SetId;
import com.nju.training.logic.StudentLogic;
import com.nju.training.model.Course;
import com.nju.training.model.Order;
import com.nju.training.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nju.training.service.OrderService;
import com.nju.training.util.ResultMessage.OrderMessage;

import java.sql.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private AccountDao accountDao;

    @Override
    public Order addOrder(Student student, Course course, String ppoint,String studentnumber, String classnumber) {
//        String orderId, String studentId, String courseid, Date foundTime, String state,
// double initialPrice, double lastPrice, int point, int studentnumber, int classnumber
        String orderId=new SetId().setOrderId(orderDao.getOrderLength());
        Date foundTime=new Date(System.currentTimeMillis());
        String state="未支付";
        int point=ppoint.equals("0")?0:student.getPoint();
        double initialPrice=course.getPrice()*Integer.valueOf(studentnumber);
        int level=student.getLevel();
        double lastPrice=new StudentLogic().getPriceByLevel(level,initialPrice)-Integer.valueOf(point)/100.0;//100积分抵1元
        String institutionid=course.getInstitutionid();
        Order order=new Order(orderId,  student.getStudentId(), institutionid, course.getCourseid(), foundTime,  state,
 initialPrice, lastPrice, Integer.valueOf(point),Integer.valueOf(  studentnumber),Integer.valueOf(  classnumber));
        int newPoint=student.getPoint()-point;
        System.out.println("new is"+newPoint);
        student.setPoint(newPoint);
        studentDao.UpdateStudent(student);
        OrderMessage message=orderDao.addOrder(order);
        if(message==OrderMessage.booksuccess){
            return order;
        }else{
            Order order1=new Order();
            order1.setOrderId("error");
            return order1;
        }

    }

    @Override
    public OrderMessage deleteOrder(Order order) {
        Student student=studentDao.GetInfoById(order.getStudentId());
        int point=student.getPoint();
        point+=order.getPoint();
        student.setPoint(point);
        studentDao.UpdateStudent(student);
        order.setState("已取消");
        return orderDao.cancelOrder(order);
    }

    /*
    Manager的支付结算功能改为每笔订单支付后自动结算，10%进入系统账户 剩余进入机构账户
     */
    @Override
    public OrderMessage payOrder(Order order) {
        Student student=studentDao.GetInfoById(order.getStudentId());
        String institutionid=courseDao.getCourseById(order.getCourseid()).getInstitutionid();
        accountDao.pay(order.getStudentId(),order.getLastPrice());
        accountDao.income("system",order.getLastPrice()/10.0);
        accountDao.income(institutionid,order.getLastPrice()*9/10.0);
        int pointincome=new StudentLogic().getPoint(order.getLastPrice());
        student.setPoint(student.getPoint()+pointincome);
        student.setConsume(student.getConsume()+order.getLastPrice());
        student.setLevel(new StudentLogic().calStudentLevel(student.getConsume()));
        studentDao.UpdateStudent(student);
        order.setState("已支付");
        return orderDao.payOrder(order);
    }

    /*
    退款规则：
    距开课两周以上退款90%
    两周内退款70%
    开课后退课不退款
     */
    @Override
    public OrderMessage dispayOrder(Order order) {
        Date startday=courseDao.getCourseById(order.getCourseid()).getStartday();
        long time=startday.getTime()-System.currentTimeMillis()/1000;//相差时间
        double count=0.9;
        if(time>=60*60*24*14){
            count=0.9;
        }else if(time>=0&&time<60*60*24*14){
            count=0.7;
        }else if(time<0){
            count=0;
        }
        count=0.9;
        double money=order.getLastPrice()*count;
        System.out.println("money="+money);
        String institutionid=courseDao.getCourseById(order.getCourseid()).getInstitutionid();
        accountDao.income(order.getStudentId(),money);
        accountDao.pay("system",money/10.0);
        accountDao.pay(institutionid,money*9/10.0);

        int pointincome=new StudentLogic().getPoint(order.getLastPrice());
        Student student=studentDao.GetInfoById(order.getStudentId());
        student.setPoint(student.getPoint()-pointincome);
        student.setConsume(student.getConsume()-money);
        student.setLevel(new StudentLogic().calStudentLevel(student.getConsume()));
        studentDao.UpdateStudent(student);



        order.setState("已退订");
        return orderDao.dispayOrder(order);
    }

    @Override
    public Order getOrder(String orderid) {
        return orderDao.getOrder(orderid);
    }
}
