package org.example;

public class Armut extends Meyve {

    public Armut(int urunId, int fiyat) {
        super(urunId, fiyat);


    }

    @Override
    public String getUrunAdi() {
        return "Armut";
    }
}
