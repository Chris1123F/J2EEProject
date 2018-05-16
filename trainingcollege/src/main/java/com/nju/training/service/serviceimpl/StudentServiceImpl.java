package com.nju.training.service.serviceimpl;

import com.nju.training.dao.CourseDao;
import com.nju.training.dao.StudentDao;
import com.nju.training.logic.SendMailUtil;
import com.nju.training.logic.SetId;
import com.nju.training.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nju.training.service.StudentService;
import com.nju.training.util.ResultMessage.PasswordMessage;
import com.nju.training.util.ResultMessage.StudentMessage;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;

    private  String captcha;

    /*
    先调用addstudent 生成数据库账户先设置为注销状态 再调checkCaptcha验证码通过将账户改为正常状态

     */
    @Override
    public Student addStudent(String email, String name, String gender, String password,String input) {
        Student student=new Student(name,gender,email,password);
        student.setPoint(0);
        student.setConsume(0);
        student.setLevel(0);
        student.setIscanceled(0);
        String id=new SetId().setStudentId(studentDao.getStudentLength());
        //设置用户id
        student.setStudentId(id);
        System.out.println(captcha);

        if(input.equals(captcha)){
            studentDao.AddStudent(student);
            return student;
        }else {
            Student student1=new Student();
            student1.setStudentId("error");
            return student1;
        }

    }

    @Override
    public void sendCaptcha(String email) {
        int cap=(int)((Math.random()*9+1)*100000);
        String captcha=String.valueOf(cap);
        System.out.println(captcha);
        this.captcha=captcha;
        String content="感谢您注册Training College账号，您的验证码为"+captcha;
        SendMailUtil.send(email,content);
    }

    @Override
    public StudentMessage updateName(Student student, String name) {
        student.setName(name);
        return studentDao.UpdateStudent(student);
    }

    @Override
    public StudentMessage updateGender(Student student, String gender) {
        student.setGender(gender);
        return studentDao.UpdateStudent(student);
    }



    @Override
    public PasswordMessage updatePassword(Student student, String rawpsword, String newpsword) {
        if(!student.getPsword().equals(rawpsword)){
            return PasswordMessage.wrongraw;
        }else if(rawpsword.equals(newpsword)){
            return PasswordMessage.repeat;
        }else{
            student.setPsword(newpsword);
            studentDao.UpdateStudent(student);
            return PasswordMessage.success;
        }

    }

    @Override
    public StudentMessage cancelStudent(Student student) {
        student.setIscanceled(1);
        studentDao.UpdateStudent(student);
        return StudentMessage.deletesuccess;
    }

    @Override
    public Student getInfo(String id) {
        return studentDao.GetInfoById(id);
    }

    @Override
    public String getPassword(String id) {
        return studentDao.GetPswordById(id);
    }

    @Override
    public Student studentLogin(String id, String password) {
        Student student=new Student();
        student.setStudentId("error");
        String trueps=studentDao.GetPswordById(id);
        if(trueps==null){
            return student;
        }
        Student student1= studentDao.GetInfoById(id);
        if(!trueps.equals(password)||student1.getIscanceled()==1){
            return student;
        }else {
            return student1;
        }
    }

    @Override
    public List getOrderList(String id) {
        return studentDao.GetOrderById(id);
    }

    @Override
    public List getMarkList(String id) {
        return courseDao.searchStudentList(id);
    }

    @Override
    public List getCourseList(String id) {
        return courseDao.searchStudentCourse(id);
    }
}
