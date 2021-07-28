package com.pip.controller;

import com.pip.entity.Context;
import com.pip.entity.Topic;
import com.pip.entity.Vocabulary;
import com.pip.service.AdminServiceImpl;
import com.pip.service.HomeService;
import com.pip.service.HomeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class RestController1 {

    /**M04: Thêm chủ đề**/
    @PostMapping(value = "/addTopic", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> add_new_topic(@RequestBody Topic topic) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.addTopic(topic);
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    /**M05: Xóa chủ đề**/
    @DeleteMapping(value = "/delTopic/{id}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> del_topic (@PathVariable int id) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.delTopics(id);
        return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
    }

    /**M06: Thêm từ vựng**/
    @PostMapping(value = "/addVoca", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> add_new_voca(@RequestBody Vocabulary vocabulary) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.addVoca(vocabulary);
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    /**M10: Xóa từ vựng**/
    @DeleteMapping(value = "/delVoca/{id}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> del_voca (@PathVariable int id) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.delVoca(id);
        return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
    }

    /**M07: Thêm ngữ cảnh**/
    @PostMapping(value = "/addContext/{id}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> add_new_context(@RequestBody Context context, @PathVariable int id) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.addContext(context, id);
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    /**M08: SỬa từ vựng**/
    @PutMapping(value = "/updateVoca", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> update_context(@RequestBody Vocabulary vocabulary) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.updateVoca(vocabulary);
        return new ResponseEntity<String>("Update!", HttpStatus.OK);
    }

    /**M12: SỬa chủ đề**/
    @PutMapping(value = "/updateTopic", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> update_topic(@RequestBody Topic topic) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.updateTopic(topic);
        return new ResponseEntity<String>("Update!", HttpStatus.OK);
    }

    /**M09: Map từ vựng với chủ đề**/
    @GetMapping(value = "/setTopic_Voca/{topicId}/{vocaId}", consumes = MediaType.ALL_VALUE)
    public void set_topic_voca(@PathVariable int topicId, @PathVariable int vocaId) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.set_topic_voca(topicId, vocaId);
    }

    /**M11: Lấy từ vựng theo id**/
    @GetMapping(value = "/get_voca_id/{id}", consumes = MediaType.ALL_VALUE)
    public List<Vocabulary> get_voca_id(@PathVariable int id) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        List<Vocabulary> vocabulary = adminService.getVocaId(id);
        return vocabulary;
    }

    /** Set mối quan hệ**/
    @PutMapping(value = "/setRelationship/{v1}/{v2}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> setRelationship(@PathVariable String v1, @PathVariable String v2) {
        HomeServiceImpl homeService = new HomeServiceImpl();
        homeService.setRelationship(v1, v2);
        homeService.setRelationship(v2, v1);
        return new ResponseEntity<String>("Update!", HttpStatus.OK);
    }

}
