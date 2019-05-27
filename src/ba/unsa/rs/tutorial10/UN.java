package ba.unsa.rs.tutorial10;

import java.io.Serializable;
import java.util.ArrayList;

public class UN implements Serializable {
    public ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    public void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }

    public UN(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }

    public UN() {
        this.drzave = new ArrayList<>();
    }

    private ArrayList<Drzava> drzave;
}
