package org.example;

import java.io.Serializable;

public class Patlican extends Sebze implements Serializable {

    public Patlican(int urunId, int fiyat) {
        super(urunId, fiyat);
    }

    @Override
    public String getUrunAdi() {
        return "Patlıcan";
    }
}
