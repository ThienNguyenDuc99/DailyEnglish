package com.pip.service;

import com.pip.dao.ContextDAOImpl;
import com.pip.dao.TopicDAOImpl;
import com.pip.dao.VocabularyDAOImpl;
import com.pip.entity.Context;
import com.pip.entity.Topic;
import com.pip.entity.Vocabulary;

import java.util.List;

public class AdminServiceImpl implements AdminService{

    /**M01: Lấy toàn bộ chủ đề**/
    @Override
    public List<Topic> getTopicAll() {
        TopicDAOImpl dao = new TopicDAOImpl();
        List<Topic> r = dao.getTopicAll();
        return r;
    }

    /**M02: Lấy toàn bộ từ vựng**/
    @Override
    public List<Vocabulary> getVocaAll() {
        VocabularyDAOImpl dao = new VocabularyDAOImpl();
        List<Vocabulary> r = dao.getVocaAll();
        return r;
    }

    /**M03: lấy từ vựng chưa thuộc một chủ đề nào cả*/
    @Override
    public List<Vocabulary> getVocaNull() {
        VocabularyDAOImpl dao = new VocabularyDAOImpl();
        List<Vocabulary> r = dao.getVocaNull();
        return r;
    }

    /**M04: Thêm chủ đề**/
    @Override
    public void addTopic(Topic topic) {
        TopicDAOImpl topicDAO = new TopicDAOImpl();
        topicDAO.addTopic(topic);
    }

    /**M05: Xóa chủ đề**/
    @Override
    public void delTopics(int id) {
        TopicDAOImpl topicDAO = new TopicDAOImpl();
        topicDAO.delTopics(id);
    }

    /**M06: Thêm từ vựng**/
    @Override
    public void addVoca(Vocabulary vocabulary) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        String image = vocabulary.getImage();
        String[] parts = image.split("\\\\");
        String r = parts[parts.length-1]; // 004
        vocabulary.setImage(r);
        vocabularyDAO.addVoca(vocabulary);
    }

    /**M07: Thêm ngữ cảnh**/
    @Override
    public void addContext(Context context, int id) {
        ContextDAOImpl contextDAO = new ContextDAOImpl();
        contextDAO.addContext(context, id);
    }

    /**M08: SỬa từ vựng**/
    @Override
    public void updateVoca(Vocabulary vocabulary) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        vocabularyDAO.updateVoca(vocabulary);
    }

    /**M09: Map từ vựng với chủ đề**/
    @Override
    public void set_topic_voca(int topicId, int vocaId) {
        TopicDAOImpl topicDAO = new TopicDAOImpl();
        topicDAO.set_topic_voca(topicId, vocaId);
    }

    /**M10: Xóa từ vựng**/
    @Override
    public void delVoca(int id) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        vocabularyDAO.delVoca(id);
    }

    /**M11: Lấy từ vựng theo id**/
    @Override
    public List<Vocabulary> getVocaId(int id) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        return vocabularyDAO.getVocaId(id);
    }

    /**M12: Sửa chủ đề**/
    @Override
    public void updateTopic(Topic topic) {
        TopicDAOImpl topicDAO = new TopicDAOImpl();
        topicDAO.updateTopic(topic);
    }

    @Override
    public int getVocaId(String vocaValue) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        return vocabularyDAO.getIdVoca(vocaValue);
    }

}
