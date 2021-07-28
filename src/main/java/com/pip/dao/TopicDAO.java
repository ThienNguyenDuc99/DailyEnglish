package com.pip.dao;

import com.pip.entity.Topic;

import java.util.List;

public interface TopicDAO {
    List<Topic> getTopicAll();

    void addTopic(Topic topic);

    void delTopics(int id);

    void set_topic_voca(int topicId, int vocaId);

    void updateTopic(Topic topic);

    int getTopicId(String topicValue);
}
