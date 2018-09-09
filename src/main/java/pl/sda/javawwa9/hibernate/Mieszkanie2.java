package pl.sda.javawwa9.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Grzesiek on 2018-09-08
 */

@Entity
public class Mieszkanie2 {

    @Id
    @GeneratedValue
    private long id;

    private String miasto;
    private String ulica;
    private String nrDomu;
    private int nrMieszkania;

    /*@OneToOne
    @JoinColumn(name = "osoba_id")
    private Osoba osoba;*/

    public Mieszkanie2() {
    }

    public Mieszkanie2(String miasto, String ulica, String nrDomu, int nrMieszkania) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
    }
}
