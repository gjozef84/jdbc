package pl.sda.javawwa9.hibernate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Grzesiek on 2018-09-08
 */

@Entity
public class Osoba2 {

    @Id
    @GeneratedValue
    private long id;

    private String imie;
    private String nazwisko;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // +fetch = FetchType.LAZY   leniwie wyciganie Mieszkania, tylko gdy będzie taka potrzeba, nie pobiera domyslnie Mieszkania w przypadku pobierania Osoby
    //@JoinColumn(name = "kolumna_dupa")//nie jest obowiazkowe, domuslnie tworzy ta kolumne, chyba ze chcemy ja jakos nazwac
    private List<Mieszkanie2> mieszkanieList;

    public Osoba2() {
    }

    public Osoba2(String imie, String nazwisko, List<Mieszkanie2> mieszkanieList) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mieszkanieList = mieszkanieList;
    }

    public Osoba2(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public List<Mieszkanie2> getMieszkanieList() {
        return mieszkanieList;
    }

    public void setMieszkanieList(List<Mieszkanie2> mieszkanieList) {
        this.mieszkanieList = mieszkanieList;
    }

    @Override
    public String toString() {
        return "Osoba2{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", mieszkanieList=" + mieszkanieList +
                '}';
    }
}
