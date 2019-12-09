package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        ArrayList <Stok> stokList = new ArrayList();
        ArrayList <Musteri> musteriList = new ArrayList();
        System.out.println("---HALİMİZE HOŞGELDİNİZ---");

        int whileici = 0;
        while (whileici==0) {
            System.out.println("ÜRÜN EKLEMEK İÇİN 1'E");
            System.out.println("EKLENEN ÜRÜNLERİ LİSTELEMEK İÇİN 2'YE");
            System.out.println("TOPLAM STOK'A BAKMAK İÇİN 3'E");
            System.out.println("ÜRÜN SATIN ALMAK İÇİN 4'E");
            System.out.println("SATIN ALMA GEÇMİŞİNİ GÖRÜNTÜLEMEK İÇİN 5'E");
            System.out.println("PERSONEL EKLEMELERİNİ GÖRMEK İÇİN 6'YA");
            System.out.println("ÇIKMAK İÇİN 7'E");

            int ifici = in.nextInt();
            in.nextLine();

            if(ifici==1) {

                System.out.println("Personel id'sini girin");
                int persenolID = in.nextInt();
                in.nextLine();

                System.out.println("personel adını girin");
                String personelAdi = in.nextLine();
                Personel personel = new Personel(persenolID,personelAdi);

                System.out.println("ARMUT EKLEMEK İÇİN 1'E, PATLICAN EKLEMEK İÇİN 2'YE BASIN.");

                int ifdegiskeni = in.nextInt();
                if (ifdegiskeni == 1) {

                    System.out.println("Armut id'sini girin.");
                    int meyveId = in.nextInt();
                    System.out.println("Armut fiyatını girin.");
                    int meyveFiyat = in.nextInt();
                    System.out.println("Armut gramını girin.");
                    int meyveGram = in.nextInt();
                    Meyve meyve = new Armut(meyveId, meyveFiyat);
                    Stok storage = new Stok(personel, meyve, meyveGram);
                    stokList.add(storage);
                }

                else if(ifdegiskeni==2) {
                    System.out.println("Patlıcan id'sini girin.");
                    int sebzeId = in.nextInt();
                    System.out.println("Patlıcan fiyatını girin.");
                    int sebzeFiyat = in.nextInt();
                    System.out.println("Patlıcan gramını girin.");
                    int sebzeGram = in.nextInt();
                    Sebze sebze = new Patlican(sebzeId, sebzeFiyat);
                    Stok storage = new Stok(personel, sebze, sebzeGram);
                    stokList.add(storage);
                }
            }
            else if(ifici==2){
                for (Stok stok : stokList) {
                    String ad = stok.getUrun().getUrunAdi();
                    int gram = stok.getGram();
                    int fiyat = stok.getUrun().getFiyat();
                    System.out.println(ad+" "+gram+" "+fiyat);
                }
            }
            else if (ifici==3){
                System.out.println("Listelemek istediğiniz ürünü seçin");
                System.out.println("Armut için 1'e");
                System.out.println("Patlıcan için 2'ye");

                int alınanGram=0;
                int satılanGram = 0;
                int toplamGram = 0;
                int girilenDeger = in.nextInt();
                if(girilenDeger==1){
                    for (Stok stok : stokList) {
                       if(stok.getUrun().getUrunAdi()=="Armut"){
                           alınanGram += stok.getGram();
                       }
                    }
                    for (Musteri musteri : musteriList) {
                        if(musteri.getUrun().getUrunAdi()=="Armut"){
                            satılanGram += musteri.getSatınAlınanMiktar();
                        }
                    }
                    toplamGram=alınanGram-satılanGram;
                    System.out.println("Armut'un toplam gramı : "+toplamGram);

                }
                else if(girilenDeger==2){
                    for (Stok stok : stokList) {
                        if(stok.getUrun().getUrunAdi()=="Patlıcan"){
                            alınanGram += stok.getGram();
                        }
                    }
                    for (Musteri musteri : musteriList) {
                        if(musteri.getUrun().getUrunAdi()=="Patlıcan"){
                            satılanGram += musteri.getSatınAlınanMiktar();
                        }
                    }
                    toplamGram=alınanGram-satılanGram;
                    System.out.println("Patlıcanın toplam gramı : "+toplamGram);
                }

            }
            else if(ifici==4){
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

                if (girilenDeger==1){
                    Urun urun = new Armut(1,10);
                    Musteri musteri = new Musteri(id,ad,urun,miktar);
                    musteriList.add(musteri);

                }
                else if (girilenDeger==2){
                    Urun urun = new Patlican(2,5);
                    Musteri musteri = new Musteri(id,ad,urun,miktar);
                    musteriList.add(musteri);
                }
                System.out.println("Ürün başarıyla satıldı.");
            }
            else if (ifici==5){
                for (Musteri musteri : musteriList) {
                    System.out.println(musteri.getId()+"  "+musteri.getAd()+"  "+musteri.getUrun().getUrunAdi()+"  "+musteri.getSatınAlınanMiktar());
                }
            }
            else if(ifici==6){
                int toplamArmut = 0;
                int toplamPatlican = 0;
                String pAd = null;
                System.out.println("Görüntülemek istediğiniz personelin id'sini girin.");
                int pId = in.nextInt();
                for (Stok stok : stokList){
                    pAd=stok.getPersonel().getAd();
                    if(stok.getPersonel().getId()==pId && stok.getUrun().getUrunAdi()=="Armut"){
                        toplamArmut+=stok.getGram();
                    }
                    else if(stok.getPersonel().getId()==pId && stok.getUrun().getUrunAdi()=="Patlıcan"){
                        toplamPatlican+=stok.getGram();
                    }
                }
                System.out.println(pId+" "+pAd+" Eklediği Armut: "+toplamArmut +" Eklediği Patlıcan: "+toplamPatlican);
            }
            else if (ifici==7){
                System.out.println("Yine bekleriz.");
                whileici=1;
            }
            else System.out.println("hatalı giriş yaptınız tekrar deneyin.");



        }
    }

}