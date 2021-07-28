package com.pip.entity;

import javax.persistence.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {

    @Id
    @Column(name="vocaId")
    private int vocaId;

    @Column(name="vocaValue")
    private String vocaValue;

    @Column(name="mean")
    private String mean;

    @Column(name="partofSpeech")
    private String partofSpeech;

    @Column(name="english")
    private String english;

    @Column(name="image")
    private String image;

    @Column(name="spelling")
    private String spelling;

    @Column(name="relatedVoca")
    private String relatedVoca;

    @ManyToMany(fetch=FetchType.EAGER,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="topic_voca",
            joinColumns=@JoinColumn(name="vocaId"),
            inverseJoinColumns=@JoinColumn(name="topicId")
    )
    private Set<Topic> topics;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="vocabulary", targetEntity = Context.class, cascade= {CascadeType.ALL})
    private Set<Context> contexts;

    @ManyToMany(fetch=FetchType.EAGER,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="user_voca",
            joinColumns=@JoinColumn(name="vocaId"),
            inverseJoinColumns=@JoinColumn(name="username")
    )
    private Set<Users> users;

    public Vocabulary(String vocaValue, String mean, String partofSpeech, String english, String image, String spelling, String relatedVoca) {
        this.vocaValue = vocaValue;
        this.mean = mean;
        this.partofSpeech = partofSpeech;
        this.english = english;
        this.image = image;
        this.spelling = spelling;
        this.relatedVoca = relatedVoca;
    }

    public Vocabulary() {

    }

    public int getVocaId() {
        return vocaId;
    }

    public void setVocaId(int vocaId) {
        this.vocaId = vocaId;
    }

    public String getVocaValue() {
        return vocaValue;
    }

    public void setVocaValue(String vocaValue) {
        this.vocaValue = vocaValue;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getPartofSpeech() {
        return partofSpeech;
    }

    public void setPartofSpeech(String partofSpeech) {
        this.partofSpeech = partofSpeech;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String level) {
        this.english = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getRelatedVoca() {
        return relatedVoca;
    }

    public void setRelatedVoca(String relatedVoca) {
        this.relatedVoca = relatedVoca;
    }

    public Set <Topic> getTopics() {
        return topics;
    }

    public void setTopic(Set <Topic> topics) {
        this.topics = topics;
    }

    public Set<Context> getContexts() {
        return contexts;
    }

    public void setContexts(Set<Context> vocabularies) {
        this.contexts = vocabularies;
    }

    public void addContext(Context temp) {
        if (contexts == null) {
            contexts = new HashSet<>();
        }

        contexts.add(temp);

        temp.setVocabulary(this);
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
