package com.pip.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "topic_voca")
public class Topic_Voca implements Serializable {
    @Id
    @Column(name="topicId")
    private int topicId;

    @Id
    @Column(name="vocaId")
    private int vocaId;

}
