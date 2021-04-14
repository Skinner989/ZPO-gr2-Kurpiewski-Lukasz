package ZPO.Strategia;

public class cw3
{
    public abstract static class postac
    {
        Atak atak;

        public abstract void klasaPostaci();

        public void atakuj()
        {
            atak.atak();
        }

        public void setAtak(Atak x)
        {
            atak = x;
        }
    }

    interface Atak
    {
        void atak();
    }

    public static class atakMieczem implements Atak
    {
        public void atak()
        {
            System.out.println("Atak mieczem");
        }
    }

    public static class atakStrzelba implements Atak
    {
        public void atak()
        {
            System.out.println("Strzał ze strzelby");
        }
    }

    public static class atakLukiem implements Atak
    {
        public void atak()
        {
            System.out.println("Strzał z łuku");
        }
    }

    public static class atakDzialem implements Atak
    {
        public void atak()
        {
            System.out.println("Strzał z działa");
        }
    }

    public static class Strzelec extends postac
    {
        public Strzelec()
        {
            atak = new atakStrzelba();
        }

        public void klasaPostaci()
        {
            System.out.println("Jestem strzelcem");
        }
    }

    public static class Lucznik extends postac
    {
        public Lucznik()
        {
            atak = new atakLukiem();
        }

        public void klasaPostaci()
        {
            System.out.println("Jestem łucznikiem");
        }
    }

    public static class Rycerz extends postac
    {
        public Rycerz()
        {
            atak = new atakMieczem();
        }

        public void klasaPostaci()
        {
            System.out.println("Jestem rycerzem!");
        }
    }

    public static class Kanonier extends postac
    {
        public Kanonier()
        {
            atak = new atakDzialem();
        }

        public void klasaPostaci()
        {
            System.out.println("Jestem kaninierem");
        }
    }

    public static void main(String[] args)
    {
        postac strzelec1 = new Strzelec();
        postac lucznik1 = new Lucznik();
        postac rycerz1 = new Rycerz();
        postac kanonier1 = new Kanonier();

        strzelec1.atakuj();
        strzelec1.klasaPostaci();
        lucznik1.atakuj();
        lucznik1.klasaPostaci();
        rycerz1.atakuj();
        rycerz1.klasaPostaci();
        kanonier1.atakuj();
        kanonier1.klasaPostaci();

        rycerz1.setAtak(new atakStrzelba());
        rycerz1.atakuj();
    }
}
