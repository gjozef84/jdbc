package pl.sda.javawwa9.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Grzesiek on 2018-09-08
 */
public class Address_main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sqlite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Address address = new Address();
        Address address1 = new Address("Polna", "13-220");

        Person2 person2 = new Person2("Grzesiek", 34, address);
        Address address2 = new Address("Lazienkowska", "00-700", person2);
        Person2 person21 = new Person2("Tomek", 30);


        entityManager.persist(address);
        entityManager.persist(person2);
        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.persist(person21);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
