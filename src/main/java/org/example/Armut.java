package org.example;

import java.io.Serializable;

public class Armut extends Meyve implements Serializable {

    public Armut(int urunId, int fiyat) {
        super(urunId, fiyat);
    }

    @Override
    public String getUrunAdi() {
        return "Armut";
    }
}