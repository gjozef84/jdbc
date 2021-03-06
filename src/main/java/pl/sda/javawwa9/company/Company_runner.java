package pl.sda.javawwa9.company;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzesiek on 2018-09-09
 */

public class Company_runner {
    public static void main(String[] args) {

        Company sda = new Company("SDA", 500000);
        Company flesz = new Company("Flesz", 350000);

        Employee emp1 = new Employee("Grzegorz Jozefowicz", 6000, 500);
        Employee emp2 = new Employee("Stanislaw Szypowski", 8000, 1000);
        Employee emp3 = new Employee("Wieslaw Wieluk", 3000, 100);
        Employee emp4 = new Employee("Kowalski Jan", 2500, 0);

        Adress adr1 = new Adress("Batalionu Ak Karpaty", 5, "00-712", "Warszawa");
        Adress adr2 = new Adress("Batalionu Ak Karpaty", 6, "00-712", "Warszawa");
        Adress adr3 = new Adress("Polna", 9, "13-220", "Rybno");
        Adress adr4 = new Adress("Wolska", 15, "02-008", "Warszawa");
        Adress adr5 = new Adress("Cieslewskich", 25, "03-017", "Warszawa");
        Adress adr6 = new Adress("Gdanska", 5, "00-001", "Gdansk");

        List<Employee> employesSDAList = new ArrayList<>();
        employesSDAList.add(emp2);
        employesSDAList.add(emp3);

        List<Employee> employesFleszList = new ArrayList<>();
        employesFleszList.add(emp1);
        employesFleszList.add(emp4);

        sda.setEmployeeList(employesSDAList);
        flesz.setEmployeeList(employesFleszList);
        sda.setAdress(adr6);
        flesz.setAdress(adr5);

        emp1.setEmployeeAdress(adr1);
        emp2.setEmployeeAdress(adr4);
        emp3.setEmployeeAdress(adr2);
        emp4.setEmployeeAdress(adr3);
        adr1.setEmployee(emp1);
        adr2.setEmployee(emp3);
        adr3.setEmployee(emp4);
        adr4.setEmployee(emp2);

        emp1.setCompany(flesz);
        emp4.setCompany(flesz);
        emp2.setCompany(sda);
        emp3.setCompany(sda);

        EntityManager entityManager = Persistence.createEntityManagerFactory("sqlite").createEntityManager();

        entityManager.persist(sda);
        entityManager.persist(flesz);

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

        Company company = entityManager.find(Company.class, (long)1);
        System.out.println(company);

        entityManager.getEntityManagerFactory().close();
        entityManager.close();
    }
}

    /*Powiąż klasę Osoba i Mieszkanie relacją 1-1.

        a)    Dodaj 5 osób, jedna osoba jest bez mieszkania
        b)    Przejdź po każdej osobie wyświetlając wszystko co o niej wiesz (wraz z danymi z mieszkania)
        c)    Udostępnij taką funkcjonalność: Użytkownik podaje id osoby, Ty zwrócisz i wyświetlisz mu wszystko co wiesz o tej osobie
        d)    Udostępnij taką funkcjonalność: Użytkownik chce dodać osobę (scannerem), wypytaj go o wszystkie dane wraz z jego mieszkaniem, a następnie dodaj użytkownika do bazy
        e)    Wyszukaj użytkowników z wybranego miasta*/