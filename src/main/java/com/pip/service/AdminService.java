package com.pip.service;

import com.pip.entity.Context;
import com.pip.entity.Topic;
import com.pip.entity.Vocabulary;

import java.util.List;

public interface AdminService {
    List<Topic> getTopicAll();

    List<Vocabulary> getVocaAll();

    List<Vocabulary> getVocaNull();

    void addTopic(Topic topic);

    void delTopics(int id);

    void addVoca(Vocabulary vocabulary);

    void addContext(Context context, int id);

    void updateVoca(Vocabulary vocabulary);

    void set_topic_voca(int topicId, int vocaId);

    void delVoca(int id);

    List<Vocabulary> getVocaId(int id);

    void updateTopic(Topic topic);

    int getVocaId(String vocaValue);

}
