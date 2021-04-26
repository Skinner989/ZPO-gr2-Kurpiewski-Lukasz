package ZPO.Command;

public class cw1
{

    interface Polecenie
    {
        String[] execute(String... parametry);
    }

    static class wlasciciel
    {
        private Polecenie mode;
        public void setMode(Polecenie polecenie)
        {
            mode = polecenie;
        }

        public void rozkaz(String... parametry)
        {
            mode.execute(parametry);
        }
    }

    static class smartHome
    {
        private String id;

        smartHome(String id)
        {
            this.id = id;
        }

        public void odtwarzajMuzyke(String... nazwa)
        {
            System.out.println(id + " - odtwarzam muzyke");
            System.out.println("Kolejka odtwarzania:");
            for(int i=0; i<nazwa.length; i++)
            {
                System.out.println(i+1 + ": " + nazwa[i]);
            }
        }

        public void temperatura(String... temperatura)
        {
            System.out.println(id + " - ustawiam temperature w domu na " + temperatura[0] + " stopni" );
        }
    }

    static class Muzyka implements Polecenie
    {
        private smartHome smartHome;
        Muzyka (smartHome smartHome)
        {
            this.smartHome = smartHome;
        }

        public String[] execute(String... nazwy)
        {
            smartHome.odtwarzajMuzyke(nazwy);
            return nazwy;
        }
    }


    static class Temperatura implements Polecenie
    {
        private smartHome smartHome;
        public Temperatura(smartHome smartHome)
        {
            this.smartHome = smartHome;
        }

        public String[] execute(String... temp)
        {
            smartHome.temperatura(temp);
            return temp;
        }
    }

    public static void main(String[]args)
    {
        wlasciciel wlasciciel = new wlasciciel();
        smartHome z1 = new smartHome("Dom1");
        Temperatura temp1 = new Temperatura(z1);
        Muzyka muzyka1 = new Muzyka(z1);

        wlasciciel.setMode(temp1);
        wlasciciel.rozkaz("20");
        wlasciciel.setMode(muzyka1);
        wlasciciel.rozkaz("nazwaUtworu1", "nazwaUtworu2", "nazwaUtworu3");
    }

}
