package pl.sda.javawwa9.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Grzesiek on 2018-09-08
 */
/*public class Mieszkanie_main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("sqlite").createEntityManager();

        entityManager.getTransaction().begin();

        Mieszkanie m1 = new Mieszkanie("Warszawa", "Batalionu Ak Karpaty", "5a", 2);
        Mieszkanie m2 = new Mieszkanie("Warszawa", "Batalionu Ak Karpaty", "5b", 2);
        Mieszkanie m3 = new Mieszkanie("Warszawa", "Wolska", "15", 25);

        Osoba o1 = new Osoba("Grzegorz", "Jozefowicz", m1);
        Osoba o2 = new Osoba("Stanislaw", "Szypowski", m2);
        Osoba o3 = new Osoba("Wieslaw", "Wieluk", m2);
        Osoba o4 = new Osoba("Tomasz", "Wiwala");
        Osoba o5 = new Osoba("Roman", "Jozefowicz", m1);

        entityManager.persist(o1);
        entityManager.persist(o2);
        entityManager.persist(o3);
        entityManager.persist(o4);
        entityManager.persist(o5);

        //tego nie trzeba robic bo zajmuje sie tym 'cascade = CascadeType=ALL'
        *//*entityManager.persist(m1);
        entityManager.persist(m2);
        entityManager.persist(m3);*//*

        entityManager.getTransaction().commit();

        entityManager.getEntityManagerFactory().close();
        entityManager.close();

    }
}*/
