package com.pip.entity;

import javax.persistence.*;

@Entity
@Table(name = "context")
public class Context {
    @Id
    @Column(name="contextId")
    private int contextId;

    @Column(name="contextValue")
    private String contextValue;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Vocabulary.class, cascade= {CascadeType.ALL})
    @JoinColumn(name = "voca_id")
    private Vocabulary vocabulary;

    public Context(Vocabulary id, String contextValue) {
        this.vocabulary = id;
        this.contextValue = contextValue;
    }

    public Context() {

    }

    public int getContextId() {
        return contextId;
    }

    public void setContextId(int contextId) {
        this.contextId = contextId;
    }

    public String getContextValue() {
        return contextValue;
    }

    public void setContextValue(String contextValue) {
        this.contextValue = contextValue;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Vocabulary vocabulary1) {
        this.vocabulary = vocabulary1;
    }
}
