package com.pip.dao;

import com.pip.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TopicDAOImpl implements TopicDAO {
    SessionFactory factory;

    public TopicDAOImpl() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Vocabulary.class)
                .addAnnotatedClass(Topic.class)
                .addAnnotatedClass(Context.class)
                .addAnnotatedClass(Authorities.class)
                .addAnnotatedClass(Topic_Voca.class)
                .buildSessionFactory();
    }

    @Override
    public List<Topic> getTopicAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Topic";
        Query query = session.createQuery(hql);
        List<Topic> r = query.getResultList();
        session.getTransaction().commit();
        return r;
    }

    @Override
    public void addTopic(Topic topic) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(topic);
        session.getTransaction().commit();
    }

    @Override
    public void delTopics(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Topic temp = session.get(Topic.class, id);
        if (temp != null) {
            session.delete(temp);
        }
        session.getTransaction().commit();
    }

    @Override
    public void set_topic_voca(int topicId, int vocaId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Topic topic = session.get(Topic.class, topicId);
        Vocabulary vocabulary = session.get(Vocabulary.class, vocaId);
        topic.addVocabulary(vocabulary);
        session.getTransaction().commit();
    }

    @Override
    public void updateTopic(Topic topic) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String hql = "UPDATE Topic SET topicValue = :topicValue WHERE topicId = :id";
        Query query = session.createQuery(hql);
        query.setParameter("topicValue", topic.getTopicValue());
        query.setParameter("id", topic.getTopicId());
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public int getTopicId(String topicValue) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "From Topic where topicValue = :topicValue";
        Query query = session.createQuery(hql);
        query.setParameter("topicValue", topicValue);
        List<Topic> r = query.getResultList();
        int r1 = r.get(0).getTopicId();
        session.getTransaction().commit();
        return r1;
    }
}
