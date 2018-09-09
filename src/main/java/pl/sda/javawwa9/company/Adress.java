package pl.sda.javawwa9.company;

import javax.persistence.*;

/**
 * Created by Grzesiek on 2018-09-09
 */

@Entity
public class Adress {

    @Id
    @GeneratedValue
    private long id;

    private String street;
    private int number;
    private String zip_code;
    private String city;

    @OneToOne(/*mappedBy = "employeeAdress",*/ cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Employee employee;

    public Adress() {
    }

    public Adress(String street, int number, String zip_code, String city) {
        this.street = street;
        this.number = number;
        this.zip_code = zip_code;
        this.city = city;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", zip_code='" + zip_code + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
