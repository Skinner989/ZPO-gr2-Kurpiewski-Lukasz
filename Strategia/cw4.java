package ZPO.Strategia;

import java.util.Random;

public class cw4
{
    public static class Reklama
    {
        typWysylki typWysylki;

        public void wyslij()
        {
            typWysylki.wyslij();
        }

        public void setTypWysylki(typWysylki x)
        {
            typWysylki = x;
        }
    }

    interface typWysylki
    {
        void wyslij();
    }

    public static class listElektroniczny implements typWysylki
    {
        public void wyslij()
        {
            System.out.println("Wysyłka reklamy listem elektronicznym");
        }
    }

    public static class wiadomoscSMS implements typWysylki
    {
        public void wyslij()
        {
            System.out.println("Wysyłka reklamy wiadomością SMS");
        }
    }

    public static class wiadomoscGlosowa implements typWysylki
    {
        public void wyslij()
        {
            System.out.println("Wysyłka reklamy wiadomością głosową");
        }
    }

    public static class slaboOplacona extends Reklama
    {
        public slaboOplacona()
        {
            typWysylki = new listElektroniczny();
        }
    }

    public static class srednioOplacona extends Reklama
    {
        public srednioOplacona()
        {
            typWysylki = new wiadomoscSMS();
        }
    }

    public static class dobrzeOplacona extends Reklama
    {
        public dobrzeOplacona()
        {
            typWysylki = new wiadomoscGlosowa();
        }
    }

    public static class klient
    {
        preferowanyJezyk jezyk;
        String imie;
        String nazwisko;

        public void wyswietlJezyk()
        {
            jezyk.wyswietlJezyk();
        }

        public void daneKlienta()
        {
            System.out.println(imie + " " + nazwisko);
        }

        public void setJezyk(preferowanyJezyk x)
        {
            jezyk = x;
        }
    }

    interface preferowanyJezyk
    {
        void wyswietlJezyk();
    }

    public static class jezykPolski implements preferowanyJezyk
    {
        public void wyswietlJezyk()
        {
            System.out.println("Reklama przetłumaczona na język polski");
        }
    }

    public static class jezykAngielski implements preferowanyJezyk
    {
        public void wyswietlJezyk()
        {
            System.out.println("Reklama przetłumaczona na język angielski");
        }
    }

    public static class jezykNiemiecki implements preferowanyJezyk
    {
        public void wyswietlJezyk()
        {
            System.out.println("Reklama przetłumaczona na język niemiecki");
        }
    }

    public static class polskiKlient extends klient
    {
        public polskiKlient(String Imie, String Nazwisko)
        {
            jezyk = new jezykPolski();
            this.imie = Imie;
            this.nazwisko = Nazwisko;
        }
    }

    public static class angielskiKlient extends klient
    {
        public angielskiKlient(String Imie, String Nazwisko)
        {
            jezyk = new jezykAngielski();
            this.imie = Imie;
            this.nazwisko = Nazwisko;
        }
    }

    public static class niemieckiKlient extends klient
    {
        public niemieckiKlient(String Imie, String Nazwisko)
        {
            jezyk = new jezykNiemiecki();
            this.imie = Imie;
            this.nazwisko = Nazwisko;
        }
    }

    public static void main(String[] args)
    {
        Reklama[] reklamy = new Reklama[3];
        klient[] klienci = new klient[3];

        Reklama reklamaSO = new slaboOplacona();
        Reklama reklamaSRO = new srednioOplacona();
        Reklama reklamaDO = new dobrzeOplacona();
        klient klientP = new polskiKlient("Adam", "Nowak");
        klient klientA = new angielskiKlient("Jan", "Kowalski");
        klient klientN = new niemieckiKlient("Jan", "Janowski");

        reklamy[0] = reklamaSO;
        reklamy[1] = reklamaSRO;
        reklamy[2] = reklamaDO;

        klienci[0] = klientP;
        klienci[1] = klientA;
        klienci[2] = klientN;

        Random random = new Random();
        int liczba = random.nextInt(3);
        reklamy[liczba].wyslij();
        System.out.println("Dostarczono do: ");
        klienci[liczba].daneKlienta();
        liczba = random.nextInt(3);
        klienci[liczba].wyswietlJezyk();
    }
}
