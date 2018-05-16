package com.nju.training.dao.daoimpl;

import com.nju.training.dao.StudentDao;
import com.nju.training.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.nju.training.util.HibernateUtil;
import com.nju.training.util.ResultMessage.StudentMessage;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    private static StudentDaoImpl studentDao=new StudentDaoImpl();

    public StudentDaoImpl() {
    }
    public static StudentDaoImpl getInstance(){
        return  studentDao;
    };


    @Override
    public int getStudentLength() {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Student";
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
    public List getAllStudents() {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            String connection = "from Student";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public StudentMessage AddStudent(Student student) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(student);
            tx.commit();
            session.close();
            return StudentMessage.addsuccess;
        }catch (Exception e){
            e.printStackTrace();
            return StudentMessage.addfail;
        }
    }

    @Override
    public StudentMessage UpdateStudent(Student student) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.update(student);
            tx.commit();
            session.close();
            return StudentMessage.updatesuccess;
        }catch (Exception e){
            e.printStackTrace();
            return StudentMessage.updatefail;
        }
    }

    @Override
    public String GetPswordById(String id) {
        List list= null;
        String psword=null;


        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Student as i where i.StudentId = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such student!");
            }else{
                Student student=(Student) list.get(0);
                psword=student.getPsword();
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return psword;
    }

    @Override
    public Student GetInfoById(String id) {
        List list= null;
        Student student=null;


        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Student as i where i.StudentId = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such student!");
            }else{
                student=(Student) list.get(0);
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return student;

    }

    @Override
    public List GetOrderById(String id) {
        List list= null;


        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Order as o where o.studentid = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such orders!");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
