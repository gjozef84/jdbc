package pl.sda.javawwa9.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzesiek on 2018-09-08
 */
public class Mieszkanie_Many_main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("sqlite").createEntityManager();

        Mieszkanie2 m1 = new Mieszkanie2("Warszawa", "Batalionu Ak Karpaty", "5a", 2);
        Mieszkanie2 m2 = new Mieszkanie2("Warszawa", "Batalionu Ak Karpaty", "5b", 2);
        Mieszkanie2 m3 = new Mieszkanie2("Warszawa", "Wolska", "15", 25);

        Osoba2 osoba2 = new Osoba2();

        List<Mieszkanie2> mieszkanie2List = new ArrayList<>();
        mieszkanie2List.add(m1);
        mieszkanie2List.add(m2);
        mieszkanie2List.add(m3);

        osoba2.setImie("Grzesiek");
        osoba2.setNazwisko("Jozefowicz");
        osoba2.setMieszkanieList(mieszkanie2List);

        entityManager.getTransaction().begin();


        entityManager.persist(osoba2);


        entityManager.getTransaction().commit();

        entityManager.getEntityManagerFactory().close();
        entityManager.close();

    }
}
