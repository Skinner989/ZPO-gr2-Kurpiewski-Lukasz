package ZPO.Command;

import java.util.Scanner;

public class cw4
{
    interface Polecenie
    {
        public void execute();
    }

    static class Bank
    {
        private Polecenie mode;
        public void setPolecenie(Polecenie polecenie)
        {
            mode = polecenie;
            execute();
        }

        public void execute()
        {
            mode.execute();
        }
    }

    static class konto
    {
        private String nazwa;
        private long stanKonta = 0;
        private int terminPozyczki = 0;
        private int autoryzacja = 0;
        private String haslo;
        private boolean czyAutoryzowany = false;

        konto(String nazwa, String haslo)
        {
            this.nazwa = nazwa;
            this.haslo = haslo;
        }

        public void setAutoryzacja(int autoryzacja)
        {
            this.autoryzacja = autoryzacja;
            setCzyAutoryzowany(false);
        }

        public void setTerminPozyczki(int terminPozyczki)
        {
            this.terminPozyczki = terminPozyczki;
        }

        private void setCzyAutoryzowany(boolean czyAutoryzowany)
        {
            this.czyAutoryzowany = czyAutoryzowany;
        }

        boolean autoryzacja()
        {
            if(this.autoryzacja == 0)
            {
                Scanner scan = new Scanner(System.in);
                System.out.println("Podaj haslo do " + this.nazwa);
                String haslo = scan.nextLine();

                if(this.haslo.equals(haslo))
                {
                    return true;
                }

                else
                {
                    return false;
                }
            }
            else
            {
                if(this.czyAutoryzowany)
                {
                    return true;
                }
                else
                {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Podaj haslo do " + this.nazwa);
                    String haslo = scan.nextLine();

                    if(this.haslo.equals(haslo))
                    {
                        setCzyAutoryzowany(true);
                        return true;
                    }

                    else
                    {
                        return false;
                    }
                }
            }
        }

        public void getStanKonta()
        {
            if(autoryzacja())
            {
                System.out.println(this.stanKonta);
            }
            else
            {
                System.out.println("Podano złe hasło");
            }
        }

        public void przelew(konto konto, long ilosc)
        {
            if(autoryzacja())
            {
                if (this.stanKonta - ilosc <= 0)
                {
                    System.out.println("Niewystarczające środki");
                }
                else
                {
                    this.stanKonta -= ilosc;
                    konto.dodaj(ilosc);
                }
            }
            else
            {
                if (this.stanKonta - ilosc <= 0)
                {
                    System.out.println("Niewystarczające środki");
                }
                else
                {
                    this.stanKonta -= ilosc;
                    konto.dodaj(ilosc);
                }
            }
        }

        private void dodaj(long ilosc, int... dni)
        {
            this.stanKonta += ilosc;
            if(dni.length != 0)
            {
                this.terminPozyczki += dni[0];
            }
        }
    }

    static class stanKonta implements Polecenie
    {
        private konto konto;
        stanKonta(konto konto)
        {
            this.konto = konto;
        }

        public void execute()
        {
            konto.getStanKonta();
        }
    }

    static class przelew implements Polecenie
    {
        private konto kontoOd;
        private konto kontoDo;
        private long ilosc;

        przelew(konto kontoOd, konto kontoDo, long ilosc)
        {
            this.kontoOd = kontoOd;
            this.kontoDo = kontoDo;
            this.ilosc = ilosc;
        }

        public void execute()
        {
            kontoOd.przelew(kontoDo, ilosc);
        }
    }

    static class pozyczka implements Polecenie
    {
        private konto konto;
        private int termin;
        private long ilosc;

        pozyczka(konto konto, int termin, long ilosc)
        {
            this.konto = konto;
            this.termin = termin;
            this.ilosc = ilosc;
        }

        public void execute()
        {
            if(konto.autoryzacja())
            {
                konto.dodaj(ilosc, termin);
            }
            else
            {
                System.out.println("Podano złe hasło");
            }
        }
    }

     public static void main(String[]args)
     {
            Bank bank1 = new Bank();
            konto konto1 = new konto("Kowalski", "123");
            konto konto2 = new konto("Nowak", "321");

            stanKonta sK1 = new stanKonta(konto1);
            bank1.setPolecenie(sK1);

            pozyczka p1 = new pozyczka(konto2, 21, 400);
            bank1.setPolecenie(p1);

            przelew pw1 = new przelew(konto2, konto1, 200);
            bank1.setPolecenie(pw1);

            bank1.setPolecenie(sK1);

            stanKonta sK2 = new stanKonta(konto2);
            bank1.setPolecenie(sK2);
     }
}
