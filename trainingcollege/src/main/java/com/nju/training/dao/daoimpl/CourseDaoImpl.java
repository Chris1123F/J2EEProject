package com.nju.training.dao.daoimpl;

import com.nju.training.dao.CourseDao;
import com.nju.training.model.Course;
import com.nju.training.model.Mark;
import com.nju.training.model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.nju.training.util.HibernateUtil;
import com.nju.training.util.ResultMessage.CourseMessage;
import com.nju.training.util.ResultMessage.LessonMessage;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CourseDaoImpl implements CourseDao {
    @Override
    public int getCourseLength() {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Course";
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
    public Course getCourseById(String courseId) {
        List list= null;
        Course course=null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Course as i where i.courseid = '" + courseId + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such course!");
            }else{
                course=(Course) list.get(0);
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public LessonMessage addCourse(Course course) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(course);
            tx.commit();
            session.close();
            return LessonMessage.addsuccess;
        }catch (Exception e){
            e.printStackTrace();
            return LessonMessage.addfail;
        }
    }

    @Override
    public LessonMessage updateCourse(Course course) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.update(course);
            tx.commit();
            session.close();
            return LessonMessage.updatesuccess;
        }catch (Exception e){
            e.printStackTrace();
            return LessonMessage.updatefail;
        }
    }

    @Override
    public List searchCourse(String keyword) {
        if(keyword.equals("all")||keyword.length()==0){
            List list = null;
            try {
                Session session = HibernateUtil.getSession();
                Transaction tx = session.beginTransaction();
                String connection = "from Course";
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
        return null;
    }

    @Override
    public CourseMessage addMark(String courseid, String studentid, int attendence, int mark) {
        try {
            Mark mk=new Mark(courseid,studentid,attendence,mark);
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(mk);
            tx.commit();
            session.close();
            return CourseMessage.success;
        }catch (Exception e){
            e.printStackTrace();
            return CourseMessage.fail;
        }
    }

    @Override
    public List<Mark> searchStudentList(String id) {
        List list= null;
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Mark as o where o.studentid = '" + id + "'";
            Query query = session.createQuery(connection);
            list = query.list();
            tx.commit();
            session.close();
            if(list.isEmpty()){
                System.out.println("no such marks!");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Course> searchStudentCourse(String id) {
        List orderlist= null;
        List courselist=new ArrayList<Course>();
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String connection="from Order as o where o.studentid = '" + id + "'";
            Query query = session.createQuery(connection);
            orderlist = query.list();
//            tx.commit();
//            session.close();
            if(orderlist.isEmpty()){
                System.out.println("no such courses!");
            }else{

                for(int i=0;i<orderlist.size();i++){
                    Order order=(Order)orderlist.get(i);
                    String newconnection="from Course as o where o.courseid = '" + order.getCourseid() + "'";
                    Query newquery = session.createQuery(newconnection);
                    courselist.add( newquery.list());
                }
                tx.commit();
                session.close();
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return courselist;
    }


}
