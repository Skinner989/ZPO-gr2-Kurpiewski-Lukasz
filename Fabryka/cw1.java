package ZPO.Fabryka;

public class cw1
{
    public static void main(String[] args)
    {
        zamowienie zamowienie1 = new zamowienie(200, new dostawaKurierem());
        zamowienie zamowienie2 = new zamowienie(400, new osobisty());
        zamowienie1.zlozReklamacje();
    }

    interface dostawa
    {
        void wybierz();
    }

    static class kurier implements dostawa
    {
        @Override
        public void wybierz()
        {
            System.out.println("Wybrano dostawę kurierem");
        }
    }

    static class odbiorOsobisty implements dostawa
    {
        @Override
        public void wybierz() {
            System.out.println("Wybrano odbiór osobisty");
        }
    }

    interface fabrykaDostawy
    {
        dostawa stworzDostawe();
    }

    static class dostawaKurierem implements fabrykaDostawy
    {
        @Override
        public dostawa stworzDostawe()
        {
            return new kurier();
        }
    }

    static class osobisty implements fabrykaDostawy
    {
        @Override
        public dostawa stworzDostawe() {
            return new odbiorOsobisty();
        }
    }

    static class zamowienie
    {
        private String nazwa;
        private double cena;
        private dostawa dostawa;

        public zamowienie(double cena, fabrykaDostawy wybranaDostawa)
        {
            this.nazwa = "Znaczek pocztowy";
            this.cena = cena;
            dostawa = wybranaDostawa.stworzDostawe();
            zlozZamowienie();
        }

        private void zlozZamowienie()
        {
            System.out.println("Złożono zamówienie");
            System.out.println("Nazwa: " + nazwa);
            System.out.println("Cena: " + cena + "zł");
            dostawa.wybierz();
        }

        private void zlozReklamacje()
        {
            System.out.println("Zamówienie: " + nazwa);
            System.out.println("Cena: " + cena + "zł");
            dostawa.wybierz();
            System.out.println("Zamówienie zostało przekazane do reklamacji.");
        }
    }
}
