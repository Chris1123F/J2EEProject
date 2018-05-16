package com.nju.training.dao;

import com.nju.training.model.Checklist;
import com.nju.training.model.Manager;
import com.nju.training.util.ResultMessage.ManagerMessage;

import java.util.List;

public interface ManagerDao {
    public String GetPswordById(String id);

    public List GetAllChecklist();

    public ManagerMessage saveInstitution(Checklist institution);

    public ManagerMessage updateInstitution(Checklist institution);

    public ManagerMessage rejectInstitution(Checklist institution);

    public Manager getInfoById(String id);

}
