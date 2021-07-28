package com.pip.controller;

import com.pip.entity.Topic;
import com.pip.entity.Vocabulary;
import com.pip.service.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String goAdmin(Model theModel) {
        AdminServiceImpl service = new AdminServiceImpl();
        List<Vocabulary> r1 = service.getVocaAll();
        theModel.addAttribute("vocabularies", r1);
        return "admin";
    }

    @GetMapping("/topic")
    public String goTopic(Model theModel) {
        AdminServiceImpl service = new AdminServiceImpl();
        /*M01: lấy toàn bộ topic*/
        List<Topic> r = service.getTopicAll();
        /*M03: lấy từ vựng chưa thuộc một topic nào cả*/
//        List<Vocabulary> r1 = service.getVocaNull();
        /*M02: lấy từ vựng */
        List<Vocabulary> r1 = service.getVocaAll();
        theModel.addAttribute("topics", r);
        theModel.addAttribute("vocabularies", r1);
        return "topic";
    }

    @GetMapping("/account")
    public String goAccount() {
        return "account";
    }
}
