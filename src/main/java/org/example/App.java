package org.example;
import com.sun.corba.se.impl.orbutil.ObjectWriter;
import com.sun.org.apache.xpath.internal.objects.XObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<Stok> stokList = new ArrayList();
        ArrayList<Musteri> musteriList = new ArrayList();
        System.out.println("---HALİMİZE HOŞGELDİNİZ---");

        int whileici = 0;
        while (whileici == 0) {
            menuTasarim();

            int ifici = in.nextInt();
            in.nextLine();

            if (ifici == 1) {
                System.out.println("Personel id'sini girin");
                int persenolID = in.nextInt();
                in.nextLine();

                System.out.println("personel adını girin");
                String personelAdi = in.nextLine();
                Personel personel = new Personel(persenolID, personelAdi);

                System.out.println("ARMUT EKLEMEK İÇİN 1'E");
                System.out.println("PATLICAN EKLEMEK İÇİN 2'YE BASIN.");

                int ifdegiskeni = in.nextInt();

                if (ifdegiskeni == 1) {
                    armutEkle(in, stokList, personel);
                }
                else if (ifdegiskeni == 2) {
                    patlicanEkle(in, stokList, personel);
                }
            }
            else if (ifici == 2) {
                stokList = getStoks();
            }
            else if (ifici == 3) {
                System.out.println("Listelemek istediğiniz ürünü seçin");
                System.out.println("Armut için 1'e");
                System.out.println("Patlıcan için 2'ye");

                int alınanGram = 0;
                int satılanGram = 0;
                int toplamGram = 0;
                int girilenDeger = in.nextInt();
                if (girilenDeger == 1) {
                    armutList(stokList, musteriList, alınanGram, satılanGram);
                }
                else if (girilenDeger == 2) {
                    patlicanList(stokList, musteriList, alınanGram, satılanGram);
                }
            }
            else if (ifici == 4) {
                satınAl(in, musteriList);
            }
            else if (ifici == 5) {
                for (Musteri musteri : musteriList) {
                    System.out.println(musteri.getId() + "  " + musteri.getAd() + "  " + musteri.getUrun().getUrunAdi() + "  " + musteri.getSatınAlınanMiktar());
                }
            }
            else if (ifici == 6) {
                personelGoruntule(in, stokList);
            }
            else if (ifici == 7) {
                System.out.println("Yine bekleriz.");
                whileici = 1;
            }
            else System.out.println("Hatalı giriş yaptınız, lütfen tekrar deneyin.");
        }
    }

    private static void menuTasarim() {
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("ÜRÜN EKLEMEK İÇİN 1'E");
        System.out.println("EKLENEN ÜRÜNLERİ LİSTELEMEK İÇİN 2'YE");
        System.out.println("TOPLAM STOK'A BAKMAK İÇİN 3'E");
        System.out.println("ÜRÜN SATIN ALMAK İÇİN 4'E");
        System.out.println("SATIN ALMA GEÇMİŞİNİ GÖRÜNTÜLEMEK İÇİN 5'E");
        System.out.println("PERSONEL EKLEMELERİNİ GÖRMEK İÇİN 6'YA");
        System.out.println("ÇIKMAK İÇİN 7'E");
        System.out.println("*********************************************");
        System.out.println();
    }

    private static void personelGoruntule(Scanner in, List<Stok> stokList) {
        int toplamArmut = 0;
        int toplamPatlican = 0;
        String pAd = null;
        System.out.println("Görüntülemek istediğiniz personelin id'sini girin.");
        int pId = in.nextInt();
        for (Stok stok : stokList) {
            pAd = stok.getPersonel().getAd();
            if (stok.getPersonel().getId() == pId && stok.getUrun().getUrunAdi() == "Armut") {
                toplamArmut += stok.getGram();
            } else if (stok.getPersonel().getId() == pId && stok.getUrun().getUrunAdi() == "Patlıcan") {
                toplamPatlican += stok.getGram();
            }
        }
        System.out.println(pId + " " + pAd + " Eklediği Armut: " + toplamArmut + " Eklediği Patlıcan: " + toplamPatlican);
    }

    private static void patlicanList(List<Stok> stokList, ArrayList<Musteri> musteriList, int alınanGram, int satılanGram) {
        int toplamGram;
        for (Stok stok : stokList) {
            if (stok.getUrun().getUrunAdi() == "Patlıcan") {
                alınanGram += stok.getGram();
            }
        }
        for (Musteri musteri : musteriList) {
            if (musteri.getUrun().getUrunAdi() == "Patlıcan") {
                satılanGram += musteri.getSatınAlınanMiktar();
            }
        }
        toplamGram = alınanGram - satılanGram;
        System.out.println("Patlıcanın toplam gramı : " + toplamGram);
    }

    private static void armutList(List<Stok> stokList, ArrayList<Musteri> musteriList, int alınanGram, int satılanGram) {
        int toplamGram;
        for (Stok stok : stokList) {
            if (stok.getUrun().getUrunAdi() == "Armut") {
                alınanGram += stok.getGram();
            }
        }
        for (Musteri musteri : musteriList) {
            if (musteri.getUrun().getUrunAdi() == "Armut") {
                satılanGram += musteri.getSatınAlınanMiktar();
            }
        }
        toplamGram = alınanGram - satılanGram;
        System.out.println("Armut'un toplam gramı : " + toplamGram);
    }

    private static List<Stok> getStoks() {
        List<Stok> stokList;
        File file = new File(".\\Dosya\\bugra");
        App objectWriter = new App();
        stokList = objectWriter.stokListOku(file);
        for (Stok stok : stokList) {
            String ad = stok.getUrun().getUrunAdi();
            int gram = stok.getGram();
            int fiyat = stok.getUrun().getFiyat();
            System.out.println(ad + " " + gram + " " + fiyat);
        }
        return stokList;
    }

    private static void patlicanEkle(Scanner in, List<Stok> stokList, Personel personel) {
        System.out.println("Patlıcan id'sini girin.");
        int sebzeId = in.nextInt();
        System.out.println("Patlıcan fiyatını girin.");
        int sebzeFiyat = in.nextInt();
        System.out.println("Patlıcan gramını girin.");
        int sebzeGram = in.nextInt();

        File file = new File(".\\Dosya\\bugra");
        App objectWriter = new App();

        Sebze sebze = new Patlican(sebzeId, sebzeFiyat);
        Stok storage = new Stok(personel, sebze, sebzeGram);
        stokList.add(storage);
        objectWriter.WriteObjecToFile(stokList, file);
    }

    private static void armutEkle(Scanner in, List<Stok> stokList, Personel personel) {
        System.out.println("Armut id'sini girin.");
        int meyveId = in.nextInt();
        System.out.println("Armut fiyatını girin.");
        int meyveFiyat = in.nextInt();
        System.out.println("Armut gramını girin.");
        int meyveGram = in.nextInt();

        File file = new File(".\\Dosya\\bugra");
        App objectWriter = new App();

        Armut meyve = new Armut(meyveId, meyveFiyat);
        Stok storage = new Stok(personel, meyve, meyveGram);
        stokList.add(storage);

        objectWriter.WriteObjecToFile(stokList, file);
    }

    private static void satınAl(Scanner in, ArrayList<Musteri> musteriList) {
        System.out.println("Satın almak istediğiniz ürünü seçin.");
        System.out.println("Armut için 1'e");
        System.out.println("Patlıcan için 2'ye");
        int girilenDeger = in.nextInt();
        in.nextLine();

        System.out.println("Lütfen id'nizi girin");
        int id = in.nextInt();
        in.nextLine();

        System.out.println("Lütfen Adınızı girin.");
        String ad = in.nextLine();

        System.out.println("Lütfen almak istediğiniz miktarı girin");
        int miktar = in.nextInt();
        in.nextLine();

        if (girilenDeger == 1) {
            Urun urun = new Armut(1, 10);
            Musteri musteri = new Musteri(id, ad, urun, miktar);
            musteriList.add(musteri);

        } else if (girilenDeger == 2) {
            Urun urun = new Patlican(2, 5);
            Musteri musteri = new Musteri(id, ad, urun, miktar);
            musteriList.add(musteri);
        }
        System.out.println("Ürün başarıyla satıldı.");
    }

    public static void WriteObjecToFile(Object object, File file) {

        try (FileOutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);){
            objectOut.writeObject(object);
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static List<Stok> stokListOku(File file) {
        List<Stok> stokList = null;
        try (FileInputStream fileOut = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileOut);) {
            stokList = (List<Stok>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stokList;
    }
}