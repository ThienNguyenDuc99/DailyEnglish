package com.pip.dao;

import com.pip.entity.Topic;
import com.pip.entity.Vocabulary;
import org.omg.CORBA.ServerRequest;
import org.omg.CORBA.portable.ValueOutputStream;

import java.util.List;

public interface VocabularyDAO {

     List<Vocabulary> getVocaAll();

     void addVoca(Vocabulary vocabulary);

     void updateVoca(Vocabulary vocabulary);

     void delVoca(int id);

     List<Vocabulary> getVocaNull();

     /**M11: Lấy từ vựng theo id**/
     List<Vocabulary> getVocaId(int id);

     /**M13: Lấy danh sách từ vựng theo chủ đề**/
     List<Vocabulary> getVocabyTopic(int id);

     /**M14: Lấy từ vựng theo giá trị**/
     List<Vocabulary> getVocabyValue(String value);

     /**M15: Lấy id từ vựng**/
     int getIdVoca(String vocaValue);

     /**M16: Thiết lập mối quan hệ giữa các từ**/
     void setRelationship(int i1, String v1, String v2);

     /**M17: Lấy từ liên quan**/
     String getRelationVoca(String vocaValue);
}
