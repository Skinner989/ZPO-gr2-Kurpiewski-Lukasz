package ZPO.Obserwator;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class cw5
{
    public static class Gielda implements Podmiot{

        List spolki;
        List <Double> wycena;
        Date data;
        private ArrayList<Obserwator> obserwatorzy;

        Gielda()
        {
            spolki = new ArrayList();
            wycena = new ArrayList();
            obserwatorzy = new ArrayList<>();
            data = new Date();

        }
        public void dodajSpolke(String nazwa, double cena)
        {
            spolki.add(nazwa);
            wycena.add(cena);
            powiadomObserwatorow("Dodano nową spółkę " + nazwa + " cena akcji: " + cena);
        }

        public void usunSpolke(String nazwa)
        {
            wycena.remove(wycena.get(spolki.indexOf(nazwa)));
            spolki.remove(nazwa);
            powiadomObserwatorow("Usunięto spółkę " + nazwa);
        }

        public void zmienCene(String nazwa, double nowaCena)
        {
            powiadomObserwatorow("Zmieniono cene akcji spółki " + nazwa + " z " + wycena.get(spolki.indexOf(nazwa)) + " na " + nowaCena + " zł");
            wycena.set(spolki.indexOf(nazwa), nowaCena);
        }

        public void dodajObserwatora(Obserwator o)
        {
            obserwatorzy.add(o);
        }
        public void usunObserwatora(Obserwator o)
        {
            obserwatorzy.remove(o);
        }
        public void powiadomObserwatorow(String tresc)
        {
            for (Obserwator o : obserwatorzy)
            {
                o.update(o.dane() + " " + tresc);
            }
        }
        public void wypiszSpolki()
        {
            for(int i = 0; i < spolki.size(); i++) {
                System.out.println(spolki.get(i) + " cena akcji: " + wycena.get(i) + " zł");
            }
        }
    }

    public static class InwestorIndywidualny implements Obserwator
    {
        String imie;
        String nazwisko;

        InwestorIndywidualny(String imie, String nazwisko)
        {
            this.imie = imie;
            this.nazwisko = nazwisko;
        }

        public String kupSpolke(Gielda gielda, String nazwa, int iloscAkcji)
        {
            gielda.powiadomObserwatorow(imie + " " + nazwisko + ": Kupiono " + iloscAkcji + " akcji spółki " + nazwa + " za " + gielda.wycena.get(gielda.spolki.indexOf(nazwa)) + " zł");
            return imie + " " + nazwisko + ": Kupiono " + iloscAkcji + " akcji spółki " + nazwa + " za " + gielda.wycena.get(gielda.spolki.indexOf(nazwa)) + " zł";
        }

        public String sprzedajSpolke(Gielda gielda, String nazwa, int iloscAkcji)
        {
            gielda.powiadomObserwatorow(imie + " " + nazwisko + ": Sprzedano " + iloscAkcji + " akcji spółki " + nazwa + " za " + gielda.wycena.get(gielda.spolki.indexOf(nazwa)) + " zł");
            return imie + " " + nazwisko + ": Sprzedano " + iloscAkcji + " akcji spółki " + nazwa + " za " + gielda.wycena.get(gielda.spolki.indexOf(nazwa)) + " zł";
        }

        public String dane()
        {
            return imie + " " + nazwisko;
        }

        @Override
        public void update(String tresc)
        {
            System.out.println(tresc);
        }
    }

//    public static class Bank implements Obserwator
//    {
//        String nazwaBanku;
//
//        Bank(String nazwa)
//        {
//            this.nazwaBanku = nazwa;
//        }
//
//        public String kupSpolke(Gielda gielda, String nazwa, int iloscAkcji)
//        {
//            gielda.powiadomObserwatorow(nazwaBanku + ": Kupiono " + iloscAkcji + " akcji spółki " + nazwa + " za " + gielda.wycena.get(gielda.spolki.indexOf(nazwa)) + " zł");
//            return nazwa + ": Kupiono " + iloscAkcji + " akcji spółki " + nazwa + " za " + gielda.wycena.get(gielda.spolki.indexOf(nazwa)) + " zł";
//        }
//
//        @Override
//        public void update(String tresc)
//        {
//            System.out.println(tresc);
//        }
//    }

    public interface Obserwator
    {
        void update(String tresc);
        String dane();
    }

    public interface Podmiot
    {
        void dodajObserwatora(Obserwator o);
        void usunObserwatora(Obserwator o);
        void powiadomObserwatorow(String tresc);
    }

    public static void main(String[] args)
    {
        Gielda gielda1 = new Gielda();
        InwestorIndywidualny inwestor1 = new InwestorIndywidualny("Adam", "Nowak");
//        Bank bank1 = new Bank("Bank testowy1");
        gielda1.dodajSpolke("test1", 200);
        gielda1.dodajSpolke("test2", 30000);
        gielda1.dodajObserwatora(inwestor1);
//        gielda1.dodajObserwatora(bank1);
//        bank1.kupSpolke(gielda1, "test2", 20);
        gielda1.dodajSpolke("test3", 100);
        inwestor1.kupSpolke(gielda1,"test1", 10);
        gielda1.zmienCene("test3", 95.00);
        gielda1.usunSpolke("test3");
        gielda1.wypiszSpolki();
    }
}
