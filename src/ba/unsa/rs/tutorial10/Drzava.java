package ba.unsa.rs.tutorial10;

import java.io.Serializable;

public class Drzava implements Serializable {
    public Drzava() {
        this.naziv = "";
        this.brojStanovnika = 0;
        this.površina = 0;
        this.jedinicaZaPovrsinu = "";
        this.glavniGrad = null;
    }

    public Drzava(String naziv, int brojStanovnika, double površina, String jedinicaZaPovrsinu, Grad glavniGrad) {
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.površina = površina;
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
        this.glavniGrad = glavniGrad;
    }

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

    public double getPovršina() {
        return površina;
    }

    public void setPovršina(double površina) {
        this.površina = površina;
    }

    public String getJedinicaZaPovrsinu() {
        return jedinicaZaPovrsinu;
    }

    public void setJedinicaZaPovrsinu(String jedinicaZaPovrsinu) {
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }

    private String naziv;
    private int brojStanovnika;
    private double površina;
    private String jedinicaZaPovrsinu;
    private Grad glavniGrad;
}
