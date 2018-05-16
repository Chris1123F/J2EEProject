package com.nju.training.service;

import com.nju.training.model.Checklist;
import com.nju.training.model.Manager;
import com.nju.training.util.ResultMessage.ManagerMessage;

import java.util.List;

public interface ManagerService {
    public ManagerMessage admitSignup(Checklist institution);

    public ManagerMessage rejectSignup(Checklist institution);

    public ManagerMessage admitModify(Checklist institution);

    public ManagerMessage rejectModify(Checklist institution);

    public List getAllChecklist();

    public Manager login(String id, String password);
}
