package pl.sda.javawwa9.hibernate;

import javax.persistence.*;

/**
 * Created by Grzesiek on 2018-09-08
 */

@Entity
public class Mieszkanie3 {

    @Id
    @GeneratedValue
    private long id;

    private String miasto;
    private String ulica;
    private String nrDomu;
    private int nrMieszkania;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Wlasciciel")
    private Osoba3 osoba3;


    public Mieszkanie3() {
    }

    public Mieszkanie3(String miasto, String ulica, String nrDomu, int nrMieszkania) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
    }

    public Mieszkanie3(String miasto, String ulica, String nrDomu, int nrMieszkania, Osoba3 osoba3) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.osoba3 = osoba3;
    }
}
