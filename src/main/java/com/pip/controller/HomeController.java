package com.pip.controller;

import com.mchange.v1.util.ListUtils;
import com.pip.entity.Context;
import com.pip.entity.Topic;
import com.pip.entity.Vocabulary;
import com.pip.service.AdminServiceImpl;
import com.pip.service.HomeService;
import com.pip.service.HomeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(Model model) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        List<Topic> r = adminService.getTopicAll();
        model.addAttribute("topics", r);
        return "home";
    }

    @GetMapping("/show-topic")
    public String showTopic(@RequestParam("value") String value, Model theModel) {
        HomeServiceImpl homeService = new HomeServiceImpl();
        int id = homeService.getTopicId(value);
        List<Vocabulary> vocabularies = homeService.getVocabyTopic(id);
        theModel.addAttribute("vocabularies", vocabularies);
        return "show-topic";
    }

    @GetMapping("/vocabulary")
    public String vocabulary(@RequestParam("value") String value, Model theModel) {
        HomeServiceImpl homeService = new HomeServiceImpl();
        List<Vocabulary> vocabularies = homeService.getVocabyValue(value);
        int vocaId = homeService.getIdVoca(value);
        List<Context> contexts = homeService.getContextbyVoca(vocaId);
        String relationVoca = homeService.getRelationVoca(value);
        if(relationVoca != null) {
            if (relationVoca.startsWith("null")) {
                relationVoca = relationVoca.replaceFirst("null", "");
            }
            String[] relationVocaList = relationVoca.split("!");
            theModel.addAttribute("relations", relationVocaList);
        }

//        List<Vocabulary> root = new ArrayList<Vocabulary>();
//
//        for (int i=1; i<relationVocaList.length; i++) {
//            List<Vocabulary> vocabularies1 = homeService.getVocabyValue(relationVocaList[i]);
//            root.addAll(vocabularies1);
//        }

        theModel.addAttribute("vocabularies", vocabularies);
        theModel.addAttribute("contexts", contexts);
        return "vocabulary";
    }

    @GetMapping("/learn")
    public String learn() {
        return "learn";
    }

    @GetMapping("/review")
    public String review() {
        return "review";
    }
}
