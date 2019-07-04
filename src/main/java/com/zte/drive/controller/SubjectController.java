package com.zte.drive.controller;

import com.zte.drive.entity.Subject;
import com.zte.drive.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //查询所有科目
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Subject> list= subjectService.findAll();
        model.addAttribute("list",list);
        return "findAllSubject";
    }

    //根据id查询某一科目
    @RequestMapping("/findById")
    public String findById(Model model, Integer id) {
        Subject mm = subjectService.findById(id);
        model.addAttribute("mm", mm);
        return "findById";
    }

    //增加一个科目
    @RequestMapping("/addSubject")
    public String addSubject(Subject subject) {
        subjectService.add(subject);
        return "redirect:findAll";
    }

    //根据id删除某个科目
    @RequestMapping("/removeById")
    public String removeById(Integer id) {
        subjectService.remove(id);
        return "redirect:findAll";
    }

    //修改某个科目
    @RequestMapping("/modify")
    public String modify(Subject subject) {
        subjectService.modify(subject);
        return "redirect:findAll";
    }

}