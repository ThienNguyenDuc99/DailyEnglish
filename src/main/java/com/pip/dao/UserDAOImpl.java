package com.pip.dao;

import com.pip.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDAOImpl implements UserDAO{

    SessionFactory factory;

    public UserDAOImpl() {
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
}
