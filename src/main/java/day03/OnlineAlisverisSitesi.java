package day03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineAlisverisSitesi {

    static Scanner input = new Scanner(System.in);
    static List<String> urunListesi = new ArrayList<>();
    static List<Double> urunFiyatListesi = new ArrayList<>();
    static double odenecekMiktar;
    static String secim;
    static LocalDate kurulusGunu = LocalDate.of(2023, 4, 8);


    public static void main(String[] args) {

        System.out.println("\nTechPro Alisveris Sitesiine Hosgeldiniz.\n");
        urunListesi.add("Saat\t Urun Kodu 0 ");
        urunListesi.add("Monitor\t Urun Kodu 1 ");
        urunListesi.add("Canta\t Urun Kodu 2 ");      // ilk önce standart kendimiz ekledik ürünleri
        urunListesi.add("Laptop\t Urun Kodu 3 ");
        urunListesi.add("Kitap\t Urun Kodu 4 ");

        urunFiyatListesi.add(150.0);
        urunFiyatListesi.add(3000.0);
        urunFiyatListesi.add(5000.0);
        urunFiyatListesi.add(6000.0);
        urunFiyatListesi.add(100.0);


        List<String> yeniUrunler = new ArrayList<>();
        yeniUrunler.add("Taki\t Urun Kodu 5");
        yeniUrunler.add("Tencere\t Urun Kodu 6");
        yeniUrunler.add("Kiyafet\t Urun Kodu 7");
        urunListesi.addAll(yeniUrunler);


        List<Double> yeniUrunFiyatlari = new ArrayList<>();
        yeniUrunFiyatlari.add(9000.0);
        yeniUrunFiyatlari.add(200.0);
        yeniUrunFiyatlari.add(400.0);
        urunFiyatListesi.addAll(yeniUrunFiyatlari);


        musteriSecim();


    }

    public static void musteriSecim() {

        urunListesiniGoster();
        System.out.println("Lütfen ürün kodunu giriniz.");
        int urunKodu = input.nextInt();
        if (urunKodu > -1 && urunKodu <= urunListesi.size()) {
            System.out.println("Lütfen kaç adet istediğinizi giriniz.");
            int urunMiktar = input.nextInt();
            double toplamUrunFiyati = urunFiyatListesi.get(urunKodu) * urunMiktar; //2 tane tencere istiyor diyelim. Bu 2 tencerenin toplami bu.
            odenecekMiktar += toplamUrunFiyati;
            devamMi();
        } else {
            System.out.println("Lütfen geçerli bir ürün kodu giriniz.");
            musteriSecim(); //Recursive Method
        }

    }

    public static void devamMi() {
        System.out.println("Alisverise Devam Etmek İster ister misiniz?\n1-->Yes\n2-->No");
        secim = input.next();
        switch (secim) {
            case "1":
                musteriSecim();
            case "2":
                odemeYap();
            default:
                System.out.println("Geçersiz bir sayi girdiniz.");
                devamMi();
        }
    }

    private static void odemeYap() {

        LocalDate date = LocalDate.now();
        if (date.isEqual(kurulusGunu)) {
            slowPrint("TechPro Alisveris Sitesiine Hosgeldiniz.\nBugün Bizim Yil Donumumuz.\nBorcunuz Yoktur :)", 80);
            System.exit(0);

        } else {
            slowPrint("TechPro Alisveris Sitesini Tercih Ettiginiz Icin Tesekkur Ederiz.\n", 80);
            System.out.println("Toplam Odemeniz Gereken Tutar = " + odenecekMiktar);
            System.exit(0);
        }

    }

    private static void slowPrint(String metin, int gecikme) {
        for (char c : metin.toCharArray()) {                      //Bu metni harf harf almaya yarıyor.

            System.out.print(c);
            try {
                Thread.sleep(gecikme);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void urunListesiniGoster() {
        System.out.println("********************************** Urun Listesi ********************************");
        for (int i = 0; i < urunListesi.size(); i++) {
            System.out.println(i + " - " + urunListesi.get(i) + "\tFiyat =  " + urunFiyatListesi.get(i) + " TL");
        }
    }
}
