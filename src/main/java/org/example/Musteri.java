package org.example;

public class Musteri {
    private int id;
    private String ad;
    private Urun urun;
    private int satınAlınanMiktar;

    public Musteri(int id, String ad, Urun urun, int satınAlınanMiktar) {
        this.id = id;
        this.ad = ad;
        this.urun = urun;
        this.satınAlınanMiktar = satınAlınanMiktar;
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

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public int getSatınAlınanMiktar() {
        return satınAlınanMiktar;
    }

    public void setSatınAlınanMiktar(int satınAlınanMiktar) {
        this.satınAlınanMiktar = satınAlınanMiktar;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", urun='" + urun + '\'' +
                ", miktar=" + satınAlınanMiktar +
                '}';
    }
}
