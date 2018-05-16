package com.nju.training.controller;



import com.nju.training.dao.AccountDao;
import com.nju.training.dao.InstitutionDao;
import com.nju.training.dao.StudentDao;
import com.nju.training.model.*;
import com.nju.training.service.CourseService;
import com.nju.training.service.InstitutionService;
import com.nju.training.service.ManagerService;
import com.nju.training.util.ResultMessage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.nju.training.service.StudentService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    InstitutionService institutionService;
    @Autowired
    ManagerService managerService;
    @Autowired
    InstitutionDao institutionDao;
    @Autowired
    StudentDao studentDao;

    @GetMapping(value="/allstudents")
    public List allstudents(){
        return studentDao.getAllStudents();
    }

    @GetMapping("/allins")
    public List allins(){
        return institutionDao.getAllInstitutions();
    };


    @GetMapping("/checklist")
    public List checklist(){
        return managerService.getAllChecklist();

    };

    @GetMapping("/login")
    public Manager login(@RequestParam String id,@RequestParam String password){
        return managerService.login(id,password);

    };

    @PostMapping("/pass")
    public ManagerMessage pass(@RequestBody Checklist checklist){
        if(checklist.getType()==1){
            return managerService.admitSignup(checklist);
        }else {
            return managerService.admitModify(checklist);
        }
    };

    @PostMapping("/unpass")
    public ManagerMessage unpass(@RequestBody Checklist checklist){
        if(checklist.getType()==1){
            return managerService.rejectSignup(checklist);
        }else {
            return managerService.rejectModify(checklist);
        }
    };




}
