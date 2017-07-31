/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektaufgabe.service;

import csunibonn.ris.javafx.platform.settings.PlatformSettingsManager;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Sonja
 */
public class HibernateUtil {

    private static HibernateUtil instance = null;
    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        Configuration cfg = new Configuration();
        cfg.configure(getClass().getResource("hibernate.cfg.xml"));
        cfg.setProperty("hibernate.connection.username", PlatformSettingsManager.getInstance().getCustomElement("hibernate.connection.username").toString());
        cfg.setProperty("hibernate.connection.password", PlatformSettingsManager.getInstance().getCustomElement("hibernate.connection.password").toString());
        cfg.setProperty("hibernate.connection.url", PlatformSettingsManager.getInstance().getCustomElement("hibernate.connection.url").toString());

        sessionFactory = cfg.buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
