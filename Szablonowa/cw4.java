package ZPO.Szablonowa;

public class cw4
{
    abstract static class Pizza
    {
        final void zrobPizze()
        {
            ciasto();
            sosPomidorowy();
            dodatki();
            pieczenie();
        }

        public abstract void ciasto();

        public abstract void dodatki();

        final void sosPomidorowy()
        {
            System.out.println("Dodaj sos pomidorowy");
        }

        final void pieczenie()
        {
            System.out.println("Piecz przez około 15 minut");
        }
    }

    public static class pizzaMargherita extends Pizza
    {
        @Override
        public void ciasto()
        {
            System.out.println("Przygotuj cienkie ciasto");
        }

        public void dodatki()
        {
            System.out.println("Dodaj ser mozzarella");
            System.out.println("Dodaj ser mozzarella");
            System.out.println("Dodaj bazylię oraz odrobinę oliwy");
        }
    }

    public static class pizzaSycylijska extends Pizza
    {
        @Override
        public void ciasto()
        {
            System.out.println("Przygotuj grube ciasto");
        }

        public void dodatki()
        {
            System.out.println("Dodaj oliwki i kapary");
            System.out.println("Dodaj przyprawy");
        }
    }

    public static void main(String[] args)
    {
        Pizza p1 = new pizzaMargherita();
        p1.zrobPizze();
        Pizza p2 = new pizzaSycylijska();
        p2.zrobPizze();
    }
}
