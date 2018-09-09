package pl.sda.javawwa9.hibernate;

import javax.persistence.*;

/**
 * Created by Grzesiek on 2018-09-08
 */

@Entity
public class Mieszkanie {

    @Id
    @GeneratedValue
    private int id;

    private String miasto;
    private String ulica;
    private String nrDomu;
    private int nrMieszkania;

    @OneToOne
    @JoinColumn(name = "osoba_id")
    private Osoba osoba;

    public Mieszkanie() {
    }

    public Mieszkanie(String miasto, String ulica, String nrDomu, int nrMieszkania) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
    }

    @Override
    public String toString() {
        return "Mieszkanie{" +
                "id=" + id +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrDomu='" + nrDomu + '\'' +
                ", nrMieszkania=" + nrMieszkania +
                '}';
    }
}
