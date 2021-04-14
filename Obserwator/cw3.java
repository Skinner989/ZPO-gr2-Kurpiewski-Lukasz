package ZPO.Obserwator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cw3
{
    public interface funkcje
    {
        void dodajUzytkownika(Obserwator o);
        void usunUzytkownika(Obserwator o);
        void powiadomUzytkownikow();
    }

    public static class przechwytyacz implements funkcje
    {
        private ArrayList<Obserwator> uzytkownicy;
        private List<Integer> liczby = new ArrayList<Integer>();

        public przechwytyacz()
        {
            uzytkownicy = new ArrayList<>();
        }

        public void dodajLiczbe(int liczba)
        {
            liczby.add(liczba);
            powiadomUzytkownikow();
        }

        public void przechwytuj(int wybor)
        {
            Scanner scan = new Scanner(System.in);

            while(true)
            {
                System.out.println("Podaj liczbę");
                int liczba = scan.nextInt();
                if (liczba == 0) break;
                else if ((wybor == 1) && (liczba>0))
                {
                    dodajLiczbe(liczba);
                }
                else if((wybor == 2) && (liczba == 3))
                {
                    dodajLiczbe(liczba);
                }
                else if ((wybor == 3) && (liczba%2 == 0))
                {
                    dodajLiczbe(liczba);
                }
            }
            System.out.println("Przechwycone wartości: " + liczby);
        }

        @Override
        public void dodajUzytkownika(Obserwator o)
        {
            uzytkownicy.add(o);
        }

        @Override
        public void usunUzytkownika(Obserwator o)
        {
            uzytkownicy.remove(o);
        }

        @Override
        public void powiadomUzytkownikow()
        {
            for (Obserwator o : uzytkownicy)
            {
                o.update();
            }
        }

    }

    public interface Obserwator
    {
        void update();
    }

    public static class uzytkownik implements Obserwator
    {
        private String imie;
        private String nazwisko;

        public uzytkownik(String imie, String nazwisko)
        {
            this.imie = imie;
            this.nazwisko = nazwisko;
        }

        @Override
        public void update()
        {
            System.out.println("Dodano liczbę");
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Podaj liczbę");
            int liczba = scan.nextInt();
            if (liczba == 0) break;
        }

        System.out.println("Jakie wartości mają być przechwytywane przez program?");
        System.out.println("Wcisnij '1', jeśli mają to być wartości większe od 0");
        System.out.println("Wcisnij '2', jeśli mają to być wartości równe 3");
        System.out.println("Wcisnij '3', jeśli mają to być wartości podzielne przez 2");
        int liczba = scan.nextInt();

        przechwytyacz testP1 = new przechwytyacz();
        uzytkownik testU1 = new uzytkownik("Adam", "Nowak");
        testP1.dodajUzytkownika(testU1);

        switch (liczba)
        {
            case 1:
                System.out.println("Wybrano przechwytywanie wartości większych od 0");
                testP1.przechwytuj(1);
                break;
            case 2:
                System.out.println("Wybrano przechwytywanie wartości równych 3");
                testP1.przechwytuj(2);
                break;
            case 3:
                System.out.println("Wybrano przechwytywanie wartości podzielnych przez 2");
                testP1.przechwytuj(3);
                break;
        }
    }
}
