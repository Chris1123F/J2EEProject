package com.nju.training.service.serviceimpl;

import com.nju.training.dao.InstitutionDao;
import com.nju.training.logic.SetId;
import com.nju.training.model.Checklist;
import com.nju.training.model.Institution;
import com.nju.training.model.Student;
import com.nju.training.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nju.training.service.InstitutionService;
import com.nju.training.util.ResultMessage.InstitutionMessage;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {
    @Autowired
    private InstitutionDao institutionDao;
    @Override
    public Checklist addInstitution(String name,String address,String password) {
        int type =1;
        int ischecked=0;
//        String id=String.valueOf(System.currentTimeMillis()/1000).substring(3);
        String id=new SetId().setInstitutionId(institutionDao.getInstitutionLength());
        Checklist checklist=new Checklist(id,password,address,name,type);
        checklist.setIschecked(0);
        institutionDao.addInstitution(checklist);
        return checklist;

    }

    @Override
    public InstitutionMessage updateInstitution(Institution institution) {
        String id=institution.getInstitutionId();
        String name=institution.getInstitutionName();
        String address=institution.getAddress();
        String password=institution.getPsword();
        Checklist checklist =new Checklist(id,password,address,name,2);
        checklist.setIschecked(0);
        return institutionDao.updateInstitution(checklist);
    }

    @Override
    public String GetPswordById(String id) {
        return institutionDao.GetPswordById(id);
    }

    @Override
    public Institution login(String id, String password) {
        Institution institution = new Institution();
        institution.setInstitutionId("error");
        String trueps=institutionDao.GetPswordById(id);
        if(trueps==null){
            return institution;
        }
        Institution ins1= institutionDao.GetInfoById(id);
        if(!trueps.equals(password)){
            return institution;
        }else {
            return ins1;
        }
    }

    @Override
    public Institution GetInfoById(String id) {
        return institutionDao.GetInfoById(id);
    }

    @Override
    public List GetOrderById(String id) {
        return institutionDao.GetOrderById(id);
    }

    @Override
    public List GetCourseById(String id) {
        return institutionDao.GerCourseById(id);
    }

    @Override
    public InstitutionMessage addTeacher(String name, String institutionid) {
        String teacherid=new SetId().setTeacherId(institutionDao.getTeacherLength());
        Teacher teacher=new Teacher(teacherid,name,institutionid);
        return institutionDao.addTeacher(teacher);
    }

}
