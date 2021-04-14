package ZPO.Dekorator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class cw4
{
    public static class koszyk
    {
        private double cena;
        private List<String> produkty;

        public koszyk()
        {
            cena = 0;
            produkty = new ArrayList<String>();
        }

        public double getCena()
        {
            return cena;
        }

        public void dodajRabat()
        {
            cena -= 10;
            if (cena < 0) cena = 0;
        }

        public void dodajMaskotke()
        {
            cena += 0;
            produkty.add("maskotka");
        }

        public void dodajSmycz()
        {
            cena += 1;
            produkty.add("smycz do pendrive");
        }

        public void dodajTransport()
        {
            cena += 13;
            produkty.add("dostawa");
        }

        public void getProdukty()
        {
            System.out.println(produkty);
        }

        public void wyczyscKoszyk()
        {
            produkty.clear();
        }
    }

    public static class produkt1 extends koszyk
    {
        private static double cena = 9.50;
        private static String nazwa = "produkt1";

        public static void dodajProdukt(koszyk kosz)
        {
            kosz.cena += cena;
            kosz.produkty.add(nazwa);
        }

        @Override
        public double getCena()
        {
            return cena;
        }

        public String getNazwa()
        {
            return nazwa;
        }
    }

    public static class produkt2 extends koszyk
    {
        private static double cena = 36.99;
        private static String nazwa = "produkt2";

        public static void dodajProdukt(koszyk kosz)
        {
            kosz.cena += cena;
            kosz.produkty.add(nazwa);
        }

        @Override
        public double getCena()
        {
            return cena;
        }

        public String getNazwa()
        {
            return nazwa;
        }
    }

    public static void main(String[] args)
    {
        koszyk koszyk1 = new koszyk();
        koszyk koszyk2 = new koszyk();
        produkt1 testProdukt1 = new produkt1();
        produkt1.dodajProdukt(koszyk1);
        produkt2 testProdukt2 = new produkt2();
        produkt2.dodajProdukt(koszyk2);
        koszyk1.dodajMaskotke();
        koszyk1.dodajSmycz();
        koszyk1.dodajTransport();
        koszyk1.dodajRabat();

        System.out.println("Produkty do kupienia: ");
        koszyk1.getProdukty();
        BigDecimal bd = new BigDecimal(koszyk1.getCena()).setScale(2, RoundingMode.HALF_DOWN);
        System.out.println("Do zapłacenia: " + bd + " zł");

        System.out.println("Produkty do kupienia: ");
        koszyk2.getProdukty();
        bd = new BigDecimal(koszyk2.getCena()).setScale(2, RoundingMode.HALF_DOWN);
        System.out.println("Do zapłacenia: " + bd + " zł");
    }
}
