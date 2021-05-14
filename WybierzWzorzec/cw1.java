package ZPO.WybierzWzorzec;

public class cw1
{
    interface OperacjaBankowa
    {
        public void wykonaj();
    }

    static class Bank
    {
        private OperacjaBankowa mode;
        public void setPolecenie(OperacjaBankowa polecenie)
        {
            mode = polecenie;
            wykonaj();
        }

        public void wykonaj()
        {
            mode.wykonaj();
        }
    }

    static class konto
    {
        private String nazwa;
        private long stanKonta = 300;

        konto(String nazwa)
        {
            this.nazwa = nazwa;
        }

        public void getStanKonta()
        {
            System.out.println(this.stanKonta);
        }

        public void przelew(konto konto, long ilosc)
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

        public void wyplata(long ilosc)
        {
            if (this.stanKonta - ilosc <= 0)
            {
                System.out.println("Niewystarczające środki");
            }
            else
            {
                this.stanKonta -= ilosc;
                System.out.println("Wypłacono " + ilosc + " zł, z konta: " + nazwa);
            }
        }

        private void dodaj(long ilosc)
        {
            this.stanKonta += ilosc;
        }
    }

    static class stanKonta implements OperacjaBankowa
    {
        private konto konto;
        stanKonta(konto konto)
        {
            this.konto = konto;
        }

        public void wykonaj()
        {
            konto.getStanKonta();
        }
    }

    static class przelew implements OperacjaBankowa
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

        public void wykonaj()
        {
            kontoOd.przelew(kontoDo, ilosc);
        }
    }

    static class wyplac implements OperacjaBankowa
    {
        private konto konto;
        private long ilosc;

        wyplac(konto konto, long ilosc)
        {
            this.konto = konto;
            this.ilosc = ilosc;
        }

        public void wykonaj()
        {
            konto.wyplata(ilosc);
        }
    }

    public static void main(String[]args)
    {
        Bank bank1 = new Bank();
        konto konto1 = new konto("Kowalski");
        konto konto2 = new konto("Nowak");

        stanKonta sK1 = new stanKonta(konto1);
        bank1.setPolecenie(sK1);

        wyplac p1 = new wyplac(konto2, 50);
        bank1.setPolecenie(p1);

        przelew pw1 = new przelew(konto2, konto1, 200);
        bank1.setPolecenie(pw1);

        bank1.setPolecenie(sK1);

        stanKonta sK2 = new stanKonta(konto2);
        bank1.setPolecenie(sK2);
    }
}
