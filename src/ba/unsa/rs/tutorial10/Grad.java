package ba.unsa.rs.tutorial10;

import java.io.Serializable;

public class Grad implements Serializable {
    private String naziv;
    private int brojStanovnika;
    private double[] temperature;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    public Grad(String naziv, int brojStanovnika, double[] temperature) {
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.temperature = temperature;
    }

    public Grad() {
        this.naziv = "";
        this.brojStanovnika = 0;
        this.temperature = new double[0];
    }
}
