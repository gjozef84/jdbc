package pl.sda.javawwa9.company;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Grzesiek on 2018-09-09
 */

@Entity
public class Company {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int capital;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Adress adress;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Company() {
    }

    public Company(String name, int capital) {
        this.name = name;
        this.capital = capital;
    }

    public Company(String name, int capital, Adress adress, List<Employee> employeeList) {
        this.name = name;
        this.capital = capital;
        this.adress = adress;
        this.employeeList = employeeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", adress=" + adress +
                ", employeeList=" + employeeList +
                '}';
    }
}
