package pl.sda.javawwa9.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzesiek on 2018-09-08
 */
public class Mieszkanie_OneToMany_main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("sqlite").createEntityManager();

        Osoba3 osoba3 = new Osoba3();
        osoba3.setImie("Grzesiek");
        osoba3.setNazwisko("Jozefowicz");
        osoba3.setMieszkanieList(null);

        Mieszkanie3 m1 = new Mieszkanie3("Warszawa", "Batalionu Ak Karpaty", "5a", 2, osoba3);
        Mieszkanie3 m2 = new Mieszkanie3("Warszawa", "Batalionu Ak Karpaty", "5b", 2, osoba3);
        Mieszkanie3 m3 = new Mieszkanie3("Warszawa", "Wolska", "15", 25, osoba3);

        List<Mieszkanie3> mieszkanie3List = new ArrayList<>();
        mieszkanie3List.add(m1);
        mieszkanie3List.add(m2);
        mieszkanie3List.add(m3);


        osoba3.setMieszkanieList(mieszkanie3List);

        entityManager.getTransaction().begin();


        entityManager.persist(osoba3);


        entityManager.getTransaction().commit();

        entityManager.getEntityManagerFactory().close();
        entityManager.close();

    }
}
