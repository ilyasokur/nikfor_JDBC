package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();

            User user = new User();
            user.setLogin("test");
            user.setPassword("test");

            License license = new License();

            license.setKey("test_key");
            license.setName("test_name");
            license.setUser(user);

            user.setLicense(license);

            session.save(user);

            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();
        }

        sessionFactory.close();

    }
}