package ZPO.WybierzWzorzec;

import java.util.ArrayList;

public class cw2
{
    public interface Obserwator
    {
        void update(String tresc);
    }

    public interface Subject
    {
        void wyslijKomunikat(String tresc);
        void dodajObserwatora(Obserwator o);
        void usunObserwatora(Obserwator o);
        void powiadom(String tresc);
    }

    public static void main(String[] args)
    {
        Bank Bank1 = new Bank();

        Klient Klient1 = new Klient("Jan", "Kowalski");
        Bank1.dodajObserwatora(Klient1);

        Bank1.wyslijKomunikat("Komunikat testowy 1");

        Klient Klient2 = new Klient("Adam", "Nowak");
        Bank1.dodajObserwatora(Klient2);
        Bank1.wyslijKomunikat("Komunikat testowy 2");
        Bank1.usunObserwatora(Klient2);
        Bank1.wyslijKomunikat("Komunikat testowy 3");

        Klient1.wypiszKomunikaty();
    }

    public static class Bank implements Subject{

        private ArrayList<Obserwator> observerList;

        public  Bank()
        {
            observerList = new ArrayList<>();
        }

        public void wyslijKomunikat(String tresc)
        {
            powiadom(tresc);
        }

        @Override
        public void dodajObserwatora(Obserwator o)
        {
            observerList.add(o);
        }

        @Override
        public void usunObserwatora(Obserwator o)
        {
            observerList.remove(o);
        }

        @Override
        public void powiadom(String tresc)
        {
            for (Obserwator o : observerList){
                o.update(tresc);
            }
        }

    }

    public static class Klient implements Obserwator {

        private String imie;
        private String nazwisko;
        private ArrayList<String> komunikaty;

        public Klient(String imie, String nazwisko)
        {
            this.imie = imie;
            this.nazwisko = nazwisko;
            komunikaty = new ArrayList<>();
        }

        public void wypiszKomunikaty()
        {
            System.out.println("Lista komunikatów dla: " + imie + " " + nazwisko + ":");
            for(int i = 0; i < komunikaty.size(); i++) {
                System.out.println(komunikaty.get(i));
            }
        }

        @Override
        public void update(String tresc)
        {
            System.out.println("Komunikat dla: " + imie + " " + nazwisko + ": " + tresc);
            this.komunikaty.add(tresc);
        }
    }
}
