package pl.sda.javawwa9.company;

import javax.persistence.*;

/**
 * Created by Grzesiek on 2018-09-09
 */

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int salary;
    private int bonus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Adress employeeAdress;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Company company;

    public Employee() {
    }

    public Employee(String name, int salary, int bonus, Adress employeeAdress) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.employeeAdress = employeeAdress;
    }

    public Employee(String name, int salary, int bonus) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Adress getEmployeeAdress() {
        return employeeAdress;
    }

    public void setEmployeeAdress(Adress employeeAdress) {
        this.employeeAdress = employeeAdress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", employeeAdress=" + employeeAdress +
                '}';
    }
}
