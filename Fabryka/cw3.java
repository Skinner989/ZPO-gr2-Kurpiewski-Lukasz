package ZPO.Fabryka;

public class cw3
{
    public static void main(String[] args)
    {
        zamowienie zamowienie1 = new zamowienie(new FabrykaNowoczesnych());
        zamowienie zamowienie2 = new zamowienie(new FabrykaArtDeco());
    }

    interface Fotel
    {
        void wybierz();
    }

    static class FotelNowoczesny implements Fotel
    {
        @Override
        public void wybierz()
        {
            System.out.println("Fotel nowoczesny");
        }
    }

    static class FotelWiktorianski implements Fotel
    {
        @Override
        public void wybierz()
        {
            System.out.println("Fotel wiktoriański");
        }
    }

    static class FotelArtDeco implements Fotel
    {
        @Override
        public void wybierz()
        {
            System.out.println("Fotel ArtDeco");
        }
    }

    interface Sofa
    {
        void wybierz();
    }

    static class SofaNowoczesna implements Sofa
    {
        @Override
        public void wybierz()
        {
            System.out.println("Sofa nowoczesna");
        }
    }

    static class SofaWiktorianska implements Sofa
    {
        @Override
        public void wybierz()
        {
            System.out.println("Sofa wiktoriańska");
        }
    }

    static class SofaArtDeco implements Sofa
    {
        @Override
        public void wybierz()
        {
            System.out.println("Sofa ArtDeco");
        }
    }

    interface StolikKawowy
    {
        void wybierz();
    }

    static class StolikKawowyNowoczesny implements StolikKawowy
    {
        @Override
        public void wybierz()
        {
            System.out.println("Stolik kawowy nowoczesny");
        }
    }

    static class StolikKawowylWiktorianski implements StolikKawowy
    {
        @Override
        public void wybierz()
        {
            System.out.println("Stolik kawowy wiktoriański");
        }
    }

    static class StolikKawowyArtDeco implements StolikKawowy
    {
        @Override
        public void wybierz()
        {
            System.out.println("Stolik kawowy ArtDeco");
        }
    }

    interface FabrykaMebli
    {
        public Fotel StworzFotel();
        public Sofa StworzSofe();
        public StolikKawowy StworzStolikKawowy();
    }

    static class FabrykaNowoczesnych implements FabrykaMebli {

        @Override
        public Fotel StworzFotel()
        {
            return new FotelNowoczesny();
        }

        @Override
        public Sofa StworzSofe()
        {
            return new SofaNowoczesna();
        }

        @Override
        public StolikKawowy StworzStolikKawowy()
        {
            return new StolikKawowyNowoczesny();
        }
    }

    static class FabrykaWiktorianskich implements FabrykaMebli {

        @Override
        public Fotel StworzFotel()
        {
            return new FotelWiktorianski();
        }

        @Override
        public Sofa StworzSofe()
        {
            return new SofaWiktorianska();
        }

        @Override
        public StolikKawowy StworzStolikKawowy()
        {
            return new StolikKawowylWiktorianski();
        }
    }

    static class FabrykaArtDeco implements FabrykaMebli {

        @Override
        public Fotel StworzFotel()
        {
            return new FotelArtDeco();
        }

        @Override
        public Sofa StworzSofe()
        {
            return new SofaArtDeco();
        }

        @Override
        public StolikKawowy StworzStolikKawowy()
        {
            return new StolikKawowyArtDeco();
        }
    }

    static class zamowienie
    {
        private Fotel fotel;
        private Sofa sofa;
        private StolikKawowy stolikKawowy;

        public zamowienie(FabrykaMebli meble)
        {
            fotel = meble.StworzFotel();
            sofa = meble.StworzSofe();
            stolikKawowy = meble.StworzStolikKawowy();
            zlozZamowienie();
        }

        private void zlozZamowienie()
        {
            System.out.println("Złożono zamówienie");
            fotel.wybierz();
            sofa.wybierz();
            stolikKawowy.wybierz();
        }

    }
}
