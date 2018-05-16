package com.nju.training.service.serviceimpl;

import com.nju.training.dao.InstitutionDao;
import com.nju.training.dao.ManagerDao;
import com.nju.training.model.Checklist;
import com.nju.training.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nju.training.service.ManagerService;
import com.nju.training.util.ResultMessage.ManagerMessage;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private InstitutionDao institutionDao;
    @Autowired
    private ManagerDao managerDao;

    @Override
    public ManagerMessage admitSignup(Checklist institution) {


        return managerDao.saveInstitution(institution);
    }

    @Override
    public ManagerMessage rejectSignup(Checklist institution) {
        return managerDao.rejectInstitution(institution);
    }

    @Override
    public ManagerMessage admitModify(Checklist institution) {
        return managerDao.updateInstitution(institution);
    }

    @Override
    public ManagerMessage rejectModify(Checklist institution) {
        return managerDao.updateInstitution(institution);
    }

    @Override
    public List getAllChecklist() {
        return managerDao.GetAllChecklist();
    }

    @Override
    public Manager login(String id, String password) {
        Manager manager = new Manager();
        manager.setManagerId("error");
        String trueps=managerDao.GetPswordById(id);
        if(trueps==null){
            return manager;
        }
        Manager manager1= managerDao.getInfoById(id);
        if(!trueps.equals(password)){
            return manager;
        }else {
            return manager1;
        }
    }
}
