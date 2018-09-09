package pl.sda.javawwa9.hibernate;

import javax.persistence.*;

/**
 * Created by Grzesiek on 2018-09-08
 */

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    private String street;
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person2 p;

    public Address() {
    }

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    public Address(String street, String zipCode, Person2 p) {
        this.street = street;
        this.zipCode = zipCode;
        this.p = p;
    }
}
