package com.pip.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @Column(name="topicId")
    private int topicId;

    @Column(name="topicValue")
    private String topicValue;

    @ManyToMany(fetch=FetchType.EAGER,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="topic_voca",
            joinColumns=@JoinColumn(name="topicId"),
            inverseJoinColumns=@JoinColumn(name="vocaId")
    )
    private Set<Vocabulary> vocabularies;

    public Topic(String topicValue) {
        this.topicValue = topicValue;
    }

    public Topic() {

    }

    public int getTopicId() {
        return topicId;
    }

    public String getTopicValue() {
        return topicValue;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setTopicValue(String topicValue) {
        this.topicValue = topicValue;
    }

    public Set<Vocabulary> getVocabularies() {
        return vocabularies;
    }

    public void setVocabularies(Set<Vocabulary> vocabularies) {
        this.vocabularies = vocabularies;
    }

    public void addVocabulary(Vocabulary temp) {
        if (vocabularies == null) {
            vocabularies = new HashSet<>();
        }
        vocabularies.add(temp);

    }

}
