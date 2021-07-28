package com.pip.service;

import com.pip.dao.ContextDAOImpl;
import com.pip.dao.TopicDAOImpl;
import com.pip.dao.VocabularyDAOImpl;
import com.pip.entity.Context;
import com.pip.entity.Vocabulary;

import java.util.List;

public class HomeServiceImpl implements  HomeService{

    /**M13: Lấy topic id theo value**/
    @Override
    public int getTopicId(String topicValue) {
        TopicDAOImpl vocabularyDAO = new TopicDAOImpl();
        return vocabularyDAO.getTopicId(topicValue);
    }

    /**M14: Lấy danh sách từ vựng theo chủ đề**/
    @Override
    public List<Vocabulary> getVocabyTopic(int id) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        return vocabularyDAO.getVocabyTopic(id);
    }

    /**M15: Lấy từ vựng theo giá trị**/
    @Override
    public List<Vocabulary> getVocabyValue(String value) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        return vocabularyDAO.getVocabyValue(value);
    }

    @Override
    public List<Context> getContextbyVoca(int id) {
        ContextDAOImpl contextDAO = new ContextDAOImpl();
        return contextDAO.getContextbyVoca(id);
    }

    @Override
    public int getIdVoca(String vocaValue) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        return vocabularyDAO.getIdVoca(vocaValue);
    }

    @Override
    public void setRelationship(String v1, String v2) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
//        int i1 = vocabularyDAO.getIdVoca(v1);
        int i1 = vocabularyDAO.getIdVoca(v1);
        String r1 = vocabularyDAO.getRelationVoca(v1);
        vocabularyDAO.setRelationship(i1, r1, v2);
    }

    @Override
    public String getRelationVoca(String vocaValue) {
        VocabularyDAOImpl vocabularyDAO = new VocabularyDAOImpl();
        return vocabularyDAO.getRelationVoca(vocaValue);
    }
}
