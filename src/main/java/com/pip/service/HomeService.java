package com.pip.service;

import com.pip.entity.Context;
import com.pip.entity.Vocabulary;

import java.util.List;

public interface HomeService {

    /**M13: Lấy danh sách từ vựng theo chủ đề**/
    List<Vocabulary> getVocabyTopic(int id);

    /**M13: Lấy topic id theo value**/
    int getTopicId(String topicValue);

    /**M13: Lấy từ vựng**/
    List<Vocabulary> getVocabyValue(String value);

    List<Context> getContextbyVoca(int id);

    /**M15: Lấy id từ vựng**/
    int getIdVoca(String vocaValue);

    void setRelationship(String v1, String v2);

    String getRelationVoca(String vocaValue);
}
