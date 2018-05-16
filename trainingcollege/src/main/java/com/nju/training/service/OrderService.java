package com.nju.training.service;

import com.nju.training.model.Course;
import com.nju.training.model.Order;
import com.nju.training.model.Student;
import com.nju.training.util.ResultMessage.OrderMessage;

public interface OrderService {
    public Order addOrder(Student student, Course course, String point, String studentnumber, String classnumber);

    public OrderMessage deleteOrder(Order order);

    public OrderMessage payOrder(Order order);

    public OrderMessage dispayOrder(Order order);

    public Order getOrder(String orderid);



}
