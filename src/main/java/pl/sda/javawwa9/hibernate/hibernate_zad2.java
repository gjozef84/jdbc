package pl.sda.javawwa9.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Grzesiek on 2018-09-08
 */
public class hibernate_zad2 {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("sqlite").createEntityManager();

        entityManager.getTransaction().begin();

        Person p = new Person(0, "Grzesiek");

        entityManager.persist(p);

        entityManager.getTransaction().commit();
        entityManager.getEntityManagerFactory().close();
        entityManager.close();
    }
}
