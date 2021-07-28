package com.pip.dao;

import com.pip.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ContextDAOImpl implements ContextDAO{

    SessionFactory factory;

    public ContextDAOImpl() {
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
    public void addContext(Context context, int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Vocabulary vocabulary = session.get(Vocabulary.class, id);
        // Make associated vocabulary post and context
        vocabulary.addContext(context);
        session.save(context);
        session.getTransaction().commit();
    }

    @Override
    public List<Context> getContextbyVoca(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "Select contextValue From Context WHERE vocabulary.vocaId = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Context> r = query.getResultList();
        session.getTransaction().commit();
        return r;
    }
}
