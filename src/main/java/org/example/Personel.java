package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Personel implements Serializable {
    private int id;
    private String ad;

    public Personel(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personel personel = (Personel) o;
        return id == personel.id &&
                Objects.equals(ad, personel.ad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ad);
    }
}
