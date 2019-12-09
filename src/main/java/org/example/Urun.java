package org.example;

import java.util.Objects;

public abstract class Urun {
    private int urunId;
    private int fiyat;

    public Urun(int urunId, int fiyat) {
        this.urunId = urunId;
        this.fiyat = fiyat;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public void urunAl(){

    }

    public abstract String getUrunAdi();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urun urun = (Urun) o;
        return urunId == urun.urunId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(urunId);
    }
}
