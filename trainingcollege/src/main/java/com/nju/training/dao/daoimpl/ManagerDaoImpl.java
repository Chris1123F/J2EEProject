package com.nju.training.dao.daoimpl;

import com.nju.training.dao.ManagerDao;
import com.nju.training.model.Checklist;
import com.nju.training.model.Institution;
import com.nju.training.model.Manager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.nju.training.util.HibernateUtil;
import com.nju.training.util.ResultMessage.ManagerMessage;

import java.util.List;


@Repository
public class ManagerDaoImpl implements ManagerDao {
    @Override
    public String GetPswordById(String id) {
        List list= null;
        String psword=null;


        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Manager as i where i.ManagerId = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such manager!");
            }else{
                Manager manager=(Manager)list.get(0);
                psword=manager.getPsword();
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return psword;
    }

    @Override
    public List GetAllChecklist() {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Checklist";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such checklists!");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ManagerMessage saveInstitution(Checklist institution) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            Institution institution1=new Institution();
            institution1.setAddress(institution.getAddress());
            institution1.setInstitutionId(institution.getInstitutionid());
            institution1.setInstitutionName(institution.getName());
            institution1.setPsword(institution.getPassword());
            institution.setIschecked(2);
            session.update(institution);
            session.save(institution1);
            tx.commit();
            session.close();
            return ManagerMessage.admit;
        }catch (Exception e){
            e.printStackTrace();
            return ManagerMessage.reject;
        }
    }

    @Override
    public ManagerMessage updateInstitution(Checklist institution) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            Institution institution1=new Institution();
            institution1.setAddress(institution.getAddress());
            institution1.setInstitutionId(institution.getInstitutionid());
            institution1.setInstitutionName(institution.getName());
            institution1.setPsword(institution.getPassword());
            institution.setIschecked(2);
            session.update(institution);
            session.update(institution1);
            tx.commit();
            session.close();
            return ManagerMessage.admit;
        }catch (Exception e){
            e.printStackTrace();
            return ManagerMessage.reject;
        }
    }

    @Override
    public ManagerMessage rejectInstitution(Checklist institution) {
        Session session =HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        institution.setIschecked(1);
        session.update(institution);
        tx.commit();
        session.close();
        return ManagerMessage.reject;
    }

    @Override
    public Manager getInfoById(String id) {
        List list= null;
        Manager manager=null;


        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Manager as i where i.ManagerId= '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such institution!");
            }else{
                manager=(Manager) list.get(0);
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return manager;
    }
}
