package ZPO.Fabryka;

public class cw2
{
    public static void main(String[] args)
    {
        zamowienie zamowienie1 = new zamowienie("Owoce", 4000, new dostawaLadowa());
        zamowienie zamowienie2 = new zamowienie("Kontenery z samochodami", 10000, new dostawaMorska());
    }

    interface dostawa
    {
        void wybierz();
    }

    static class Ciezarowka implements dostawa
    {
        @Override
        public void wybierz()
        {
            System.out.println("Wybrano dostawę drogą lądową przez ciężarówkę");
        }
    }

    static class Statek implements dostawa
    {
        @Override
        public void wybierz() {
            System.out.println("Wybrano dostawę drogą morską przez statek");
        }
    }

    interface fabrykaDostawy
    {
        dostawa stworzDostawe();
    }

    static class dostawaLadowa implements fabrykaDostawy
    {
        @Override
        public dostawa stworzDostawe()
        {
            return new Ciezarowka();
        }
    }

    static class dostawaMorska implements fabrykaDostawy
    {
        @Override
        public dostawa stworzDostawe()
        {
            return new Statek();
        }
    }

    static class zamowienie
    {
        private String nazwa;
        private double cena;
        private dostawa dostawa;

        zamowienie(String nazwa, double cena, fabrykaDostawy wybranaDostawa)
        {
            this.nazwa = nazwa;
            this.cena = cena;
            dostawa = wybranaDostawa.stworzDostawe();
            zlozZamowienie();
        }

        private void zlozZamowienie()
        {
            System.out.println("Złożono zamówienie");
            System.out.println("Nazwa: " + nazwa);
            System.out.println("Cena: " + cena + " zł");
            dostawa.wybierz();
        }
    }
}
