package com.nju.training.dao;

import com.nju.training.model.Checklist;
import com.nju.training.model.Institution;
import com.nju.training.model.Teacher;
import com.nju.training.util.ResultMessage.InstitutionMessage;

import java.util.List;

public interface InstitutionDao {
    public int getTeacherLength();

    public int getInstitutionLength();

    public List getAllInstitutions();

    public InstitutionMessage addInstitution(Checklist institution);

    public InstitutionMessage updateInstitution(Checklist institution);

    public String GetPswordById(String id);

    public Institution GetInfoById(String id);

    public List GetOrderById(String id);

    public List GerCourseById(String id);

    public InstitutionMessage addTeacher(Teacher teacher);
}
