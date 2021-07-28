package com.pip.dao;

import com.pip.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class VocabularyDAOImpl implements VocabularyDAO{

    SessionFactory factory;

    public VocabularyDAOImpl() {
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
    public void addVoca(Vocabulary vocabulary) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(vocabulary);
        session.getTransaction().commit();
    }

    @Override
    public void updateVoca(Vocabulary vocabulary) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String hql = "UPDATE Vocabulary SET vocaValue = :vocaValue, mean = :mean, partofSpeech = :partofSpeech, english = :english, image = :image, spelling = :spelling WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("vocaValue", vocabulary.getVocaValue());
        query.setParameter("mean", vocabulary.getMean());
        query.setParameter("partofSpeech", vocabulary.getPartofSpeech());
        query.setParameter("english", vocabulary.getEnglish());
        query.setParameter("image", vocabulary.getImage());
        query.setParameter("spelling", vocabulary.getSpelling());
//        query.setParameter("relatedVoca", vocabulary.getRelatedVoca());
        query.setParameter("id", vocabulary.getVocaId());
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void delVoca(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Vocabulary temp = session.get(Vocabulary.class, id);
        if (temp != null) {
            session.delete(temp);
        }
        session.getTransaction().commit();
    }

    @Override
    public List<Vocabulary> getVocaAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Vocabulary ";
        Query query = session.createQuery(hql);
        List<Vocabulary> r = query.getResultList();
        session.getTransaction().commit();
        return r;
    }

    @Override
    public List<Vocabulary> getVocaNull() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "Select v.vocaId, v.vocaValue From Vocabulary v left join Topic_Voca t on v.vocaId = t.vocaId where t.topicId is Null";
        Query query = session.createQuery(hql);
        List<Vocabulary> r = query.getResultList();
        session.getTransaction().commit();
        return r;
    }

    @Override
    public List<Vocabulary> getVocaId(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "Select vocaValue, mean, english, spelling, image, partofSpeech from Vocabulary where vocaId = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Vocabulary> r = query.getResultList();
        session.getTransaction().commit();
        return r;
    }

    @Override
    public List<Vocabulary> getVocabyTopic(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
//        String hql = "select vocaId from Vocabulary v inner join Topic_Voca tv";
        String hql = "select v.vocaId, v.vocaValue, v.mean, v.partofSpeech, v.english, v.image, v.spelling, v.relatedVoca from Vocabulary v inner join Topic_Voca tv on v.vocaId = tv.vocaId where tv.topicId = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Vocabulary> r = query.getResultList();
        session.getTransaction().commit();
        return r;
    }

    @Override
    public List<Vocabulary> getVocabyValue(String value) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "select vocaId, vocaValue, mean, partofSpeech, english, image, spelling, relatedVoca from Vocabulary where vocaValue = :value";
        Query query = session.createQuery(hql);
        query.setParameter("value", value);
        List<Vocabulary> r = query.getResultList();
        session.getTransaction().commit();
        return r;
    }

    @Override
    public int getIdVoca(String vocaValue) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "From Vocabulary where vocaValue = :vocaValue";
        Query query = session.createQuery(hql);
        query.setParameter("vocaValue", vocaValue);
        List<Vocabulary> r = query.getResultList();
        int r1 = r.get(0).getVocaId();
        session.getTransaction().commit();
        return r1;
    }

    @Override
    public String getRelationVoca(String vocaValue) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "From Vocabulary where vocaValue = :vocaValue";
        Query query = session.createQuery(hql);
        query.setParameter("vocaValue", vocaValue);
        List<Vocabulary> r = query.getResultList();
        String r1 = r.get(0).getRelatedVoca();
        session.getTransaction().commit();
        return r1;
    }

    @Override
    public void setRelationship(int i1, String v1, String v2) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String hql = "UPDATE Vocabulary SET relatedVoca = :relationVoca WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("relationVoca", v1 + "!" + v2);
        query.setParameter("id", i1);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }


}
