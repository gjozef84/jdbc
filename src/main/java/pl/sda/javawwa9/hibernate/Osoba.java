package pl.sda.javawwa9.hibernate;

import javax.persistence.*;

/**
 * Created by Grzesiek on 2018-09-08
 */

@Entity
public class Osoba {

    @Id
    @GeneratedValue
    private int id;

    private String imie;
    private String nazwisko;

    @OneToOne(cascade = CascadeType.ALL) // +fetch = FetchType.LAZY   leniwie wyciganie Mieszkania, tylko gdy będzie taka potrzeba, nie pobiera domyslnie Mieszkania w przypadku pobierania Osoby
    @JoinColumn(name="mieszkanie_id") //nie jest obowiazkowe, domuslnie tworzy ta kolumne, chyba ze chcemy ja jakos nazwac
    private Mieszkanie mieszkanie;

    public Osoba() {
    }

    public Osoba(String imie, String nazwisko, Mieszkanie mieszkanie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mieszkanie = mieszkanie;
    }

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", mieszkanie=" + mieszkanie +
                '}';
    }
}
