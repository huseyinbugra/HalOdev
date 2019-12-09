package org.example;

import java.util.Objects;

public class Stok {
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
        return urun + " " + gram + " TEST UYGULAMASI";
    }


}
