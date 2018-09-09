package pl.sda.javawwa9.hibernate;

import javax.persistence.*;

/**
 * Created by Grzesiek on 2018-09-08
 */

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;


    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}