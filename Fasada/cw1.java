package ZPO.Fasada;

import java.util.Scanner;

public class cw1
{
    static class Klawiatura
    {
        int n;
        int[] tab;

        Klawiatura(int n)
        {
            this.n = n;
        }

        void Pobierz()
        {
            tab = new int[n];
            int licznik = 0;
            Scanner scan = new Scanner(System.in);
            while (licznik != n)
            {
                System.out.println("Podaj liczbę");
                tab[licznik] = scan.nextInt();
                licznik++;
            }
        }

        void wypisz(int n)
        {
            System.out.println(tab[n-1]);
        }
    }


    static class MAIN{

        private Klawiatura klawiatura;

         MAIN(int n)
         {
             klawiatura = new Klawiatura(n);
         }

        public void pobierzZKlawiatury()
        {
            klawiatura.Pobierz();
        }

        public void wypisz(int n)
        {
            klawiatura.wypisz(n);
        }
    }

    public static void main(String[] args)
    {
        MAIN test1 = new MAIN(5);
        test1.pobierzZKlawiatury();
        test1.wypisz(2);
    }
}
