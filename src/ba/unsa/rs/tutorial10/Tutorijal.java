package ba.unsa.rs.tutorial10;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    public static void main(String[] args) {
        ucitajGradove();
        ucitajXml();
    }

    public static ArrayList<Grad> ucitajGradove() {
        ArrayList<Grad> gradovi = new ArrayList<>();
        Scanner ulaz;
        try {
            ulaz = new Scanner(new FileReader("resources/mjerenja.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti");
        }

        return gradovi;
    }

    public static ArrayList<Drzava> ucitajXml() {
        ArrayList<Drzava> drzave = new ArrayList<>();
        try {
            XMLDecoder ulaz = new XMLDecoder(new FileInputStream("resources/drzave.xml"));
            Drzava drzava = (Drzava) ulaz.readObject();
            ulaz.close();
        }catch (FileNotFoundException e) {
            System.out.println("Datoteka drzave.xml ne postoji ili se ne može otvoriti");
        }


        return drzave;
    }

    public static void zapisiXml() {
        try {
            UN un = new UN();
            XMLEncoder izlaz = new XMLEncoder(
                    new FileOutputStream("un.xml"));
            izlaz.writeObject(un);
            izlaz.close();
        } catch(Exception e) {
            System.out.println("Greška prilikom spasavanja: " + e);
        }

    }
}
