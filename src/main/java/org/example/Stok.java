package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Stok implements Serializable {
    private Personel personel;
    private Urun urun;
    private int gram;

    public Stok(Personel personel, Urun urun, int gram) {
        this.personel = personel;
        this.urun = urun;
        this.gram = gram;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public int getGram() {
        return gram;
    }

    public void setGram(int gram) {
        this.gram = gram;
    }
    @Override
    public String toString() {
        return new StringBuffer(" Ad: ").append(this.personel)
                .append(" Ürün : ").append(this.urun).append(" Yaş : ").append(this.gram).toString();
    }

}
