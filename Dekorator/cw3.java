package ZPO.Dekorator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class cw3
{
    public static class Pizza
    {
        private final double cenaPizzy= 14.99;
        private final String nazwaPizzy = "Pizza";

        public double getCena()
        {
            return cenaPizzy;
        }

        public String getNazwaPizzy()
        {
            return nazwaPizzy;
        }
    }

    public static class PizzaZOregano extends Pizza
    {

        private final double cenaPizzy = 3;
        private final Pizza cenapizzy;
        private final String nazwaPizzy = " z oregano";

        public PizzaZOregano(Pizza cenapizzy)
        {
            this.cenapizzy = cenapizzy;
        }

        @Override
        public double getCena()
        {
            return cenapizzy.getCena() + cenaPizzy;
        }

        @Override
        public String getNazwaPizzy()
        {
            return cenapizzy.getNazwaPizzy() + nazwaPizzy;
        }
    }

    public static class PizzaZSzynka extends Pizza
    {

        private final double cenaPizzy = 8.99;
        private final Pizza cenapizzy;
        private final String nazwaPizzy = " z szynką";

        public PizzaZSzynka(Pizza cenapizzy)
        {
            this.cenapizzy = cenapizzy;
        }

        @Override
        public double getCena()
        {
            return cenapizzy.getCena() + cenaPizzy;
        }

        @Override
        public String getNazwaPizzy()
        {
            return cenapizzy.getNazwaPizzy() + nazwaPizzy;
        }
    }

    public static class PizzaZPrzieczarkami extends Pizza
    {

        private final double cenaPizzy = 6.50;
        private final Pizza cenapizzy;
        private final String nazwaPizzy = " z pieczarkami";

        public PizzaZPrzieczarkami(Pizza cenapizzy)
        {
            this.cenapizzy = cenapizzy;
        }

        @Override
        public double getCena()
        {
            return cenapizzy.getCena() + cenaPizzy;
        }

        @Override
        public String getNazwaPizzy()
        {
            return cenapizzy.getNazwaPizzy() + nazwaPizzy;
        }
    }

    public static void main(String[] args)
    {
        Pizza zwykla = new Pizza();
        Pizza zOregano = new PizzaZOregano(zwykla);
        Pizza zSzynka = new PizzaZSzynka(zwykla);
        Pizza zPieczarkami = new PizzaZPrzieczarkami(zwykla);
        Pizza zSzynkaIOregano = new PizzaZSzynka(zOregano);
        Pizza zSzynkaIOreganoIPieczarkami = new PizzaZPrzieczarkami(zSzynkaIOregano);

        for (Pizza pizza : List.of(zwykla, zOregano, zSzynka, zPieczarkami, zSzynkaIOregano, zSzynkaIOreganoIPieczarkami))
        {
            BigDecimal bd = new BigDecimal(pizza.getCena()).setScale(2, RoundingMode.HALF_DOWN);
            System.out.println(pizza.getNazwaPizzy() + ", koszt pizzy: " + bd + "zł");
        }
    }
}
