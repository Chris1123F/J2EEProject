package com.nju.training.dao.daoimpl;

import com.nju.training.dao.InstitutionDao;
import com.nju.training.model.Checklist;
import com.nju.training.model.Institution;
import com.nju.training.model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.nju.training.util.HibernateUtil;
import com.nju.training.util.ResultMessage.InstitutionMessage;

import java.util.List;

@Repository
public class InstitutionDaoImpl implements InstitutionDao{
    @Override
    public int getTeacherLength() {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Teacher";
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
    public int getInstitutionLength() {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Institution";
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
    public List getAllInstitutions() {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            String connection = "from Institution";
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

    //上传到checklist供manager审核 审核通过进入institution表
    @Override
    public InstitutionMessage addInstitution(Checklist institution) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(institution);
            tx.commit();
            session.close();
            return InstitutionMessage.addsuccess;
        }catch (Exception e){
            e.printStackTrace();
            return InstitutionMessage.addfail;
        }
    }

    @Override
    public InstitutionMessage updateInstitution(Checklist institution) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(institution);
            tx.commit();
            session.close();
            return InstitutionMessage.updatesuccess;
        }catch (Exception e){
            e.printStackTrace();
            return InstitutionMessage.updatefail;
        }
    }

    @Override
    public String GetPswordById(String id) {
        List list= null;
        String psword=null;


        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Institution as i where i.InstitutionId = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such institution!");
            }else{
                Institution ins=(Institution)list.get(0);
                psword=ins.getPsword();
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return psword;
    }

    @Override
    public Institution GetInfoById(String id) {
        List list= null;
        Institution ins=null;


        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Institution as i where i.InstitutionId = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such institution!");
            }else{
                ins=(Institution)list.get(0);
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ins;

    }

    @Override
    public List GetOrderById(String id) {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Order as o where o.institutionid = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();

            tx.commit();
            session.close();

        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List GerCourseById(String id) {
        List list= null;


        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Course as o where o.institutionid = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such Courses!");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public InstitutionMessage addTeacher(Teacher teacher) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(teacher);
            tx.commit();
            session.close();
            return InstitutionMessage.addsuccess;
        }catch (Exception e){
            e.printStackTrace();
            return InstitutionMessage.addfail;
        }
    }
}
