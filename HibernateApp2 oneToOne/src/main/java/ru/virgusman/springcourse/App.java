package ru.virgusman.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.virgusman.springcourse.models.Passport;
import ru.virgusman.springcourse.models.Person;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = new Person("Test person 3", 32);
            Passport passport = new Passport(3333);

            person.setPassport(passport);
            session.save(person);

            session.getTransaction().commit();
        }
    }
}
