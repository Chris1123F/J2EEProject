package com.nju.training.dao.daoimpl;

import com.nju.training.dao.OrderDao;
import com.nju.training.model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.nju.training.util.HibernateUtil;
import com.nju.training.util.ResultMessage.OrderMessage;

import java.util.List;


@Repository
public class OrderDaoImpl implements OrderDao {
    @Override
    public int getOrderLength() {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Order";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                return 0;

            }else{
                return list.size();
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public OrderMessage addOrder(Order order) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(order);
            tx.commit();
            session.close();
            return OrderMessage.booksuccess;
        }catch (Exception e){
            e.printStackTrace();
            return OrderMessage.bookfail;
        }
    }

    @Override
    public OrderMessage cancelOrder(Order order) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            order.setState("已取消");
            session.update(order);
            tx.commit();
            session.close();
            return OrderMessage.cancelsuccess;
        }catch (Exception e){
            e.printStackTrace();
            return OrderMessage.cancelfail;
        }
    }

    @Override
    public OrderMessage payOrder(Order order) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            order.setState("已支付");
            session.update(order);
            tx.commit();
            session.close();
            return OrderMessage.paysuccess;
        }catch (Exception e){
            e.printStackTrace();
            return OrderMessage.nobalance;
        }
    }

    @Override
    public OrderMessage dispayOrder(Order order) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            order.setState("已退订");
            session.update(order);
            tx.commit();
            session.close();
            return OrderMessage.dispaysuccess;
        }catch (Exception e){
            e.printStackTrace();
            return OrderMessage.dispayfail;
        }
    }

    @Override
    public Order getOrder(String orderid) {
        List list= null;
        Order order=null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Order as o where o.orderid = '" + orderid + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such account!");
            }else{
                order=(Order)list.get(0);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
}
