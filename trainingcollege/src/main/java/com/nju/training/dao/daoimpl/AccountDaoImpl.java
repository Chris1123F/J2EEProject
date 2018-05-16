package com.nju.training.dao.daoimpl;

import com.nju.training.dao.AccountDao;
import com.nju.training.model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.nju.training.util.HibernateUtil;
import com.nju.training.util.ResultMessage.AccountMessage;

import java.util.List;


@Repository
public class AccountDaoImpl implements AccountDao {
    @Override
    public int getAccountLength() {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from model.Account";
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
    public Account getAccount(String id) {
        List list= null;
        Account account=null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Account  o where o.id = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such account!");
            }else{
                account=(Account)list.get(0);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public AccountMessage pay(String id, double money) {
        List list= null;
        Account account=null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Account as o where o.id = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();

            if(list.isEmpty()){
                System.out.println("no such account!");
            }else{
                account=(Account)list.get(0);
                double balance=account.getBalance();
                balance-=money;
                if(balance<0){
                    return AccountMessage.nobalance;
                }
                account.setBalance(balance);
                session.update(account);

            }
            tx.commit();
            session.close();
            return AccountMessage.paysuccess;
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return AccountMessage.wrong;
        }

    }

    @Override
    public AccountMessage income(String id, double money) {
        List list= null;
        Account account=null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Account as o where o.id = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();

            if(list.isEmpty()){
                System.out.println("no such account!");
            }else{
                account=(Account)list.get(0);
                double balance=account.getBalance();
                balance+=money;
                account.setBalance(balance);
                session.update(account);

            }
            tx.commit();
            session.close();
            return AccountMessage.paysuccess;
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return AccountMessage.wrong;
        }
    }
}
