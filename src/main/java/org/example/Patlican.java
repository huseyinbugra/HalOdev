package org.example;

public class Patlican extends Sebze {

    public Patlican(int urunId, int fiyat) {
        super(urunId, fiyat);
    }

    @Override
    public String getUrunAdi() {
        return "Patlıcan";
    }
}
