package com.nju.training.service;

import com.nju.training.model.Checklist;
import com.nju.training.model.Institution;
import com.nju.training.util.ResultMessage.InstitutionMessage;

import java.util.List;

public interface InstitutionService {
    public Checklist addInstitution(String name, String address, String password);

    public InstitutionMessage updateInstitution(Institution institution);

    public String GetPswordById(String id);

    public Institution login(String id, String password);

    public Institution GetInfoById(String id);

    public List GetOrderById(String id);

    public List GetCourseById(String id);

    public InstitutionMessage addTeacher(String name, String institutionid);
}
