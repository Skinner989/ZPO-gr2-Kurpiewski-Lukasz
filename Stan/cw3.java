package ZPO.Stan;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class cw3
{
    public static void main(String[] args)
    {
        Autoryzacja test1 = new Autoryzacja();
        test1.sprawdz();
        Autoryzacja test2 = new Autoryzacja();
        test2.sprawdz();
        test2.sprawdz();
        test2.sprawdz();
    }

    public interface Stan {
        public void sprawdz();
    }

    public static class Autoryzacja
    {
        private SprawdzanieStan sprawdzanieStan;
        private AutoryzacjaPoprawnaStan autoryzacjaPoprawnaStan;
        private BladAutoryzacjiStan bladAutoryzacjiStan;
        private BladAutoryzacji3RazyStan bladAutoryzacji3RazyStan;
        private Stan stan;

        Autoryzacja() {
            sprawdzanieStan = new SprawdzanieStan(this);
            autoryzacjaPoprawnaStan = new AutoryzacjaPoprawnaStan(this);
            bladAutoryzacjiStan = new BladAutoryzacjiStan(this);
            bladAutoryzacji3RazyStan = new BladAutoryzacji3RazyStan(this);
            stan = sprawdzanieStan;
        }

        void setStan(Stan stan) {
            this.stan = stan;
        }

        Stan getStan() {
            return stan;
        }

        void sprawdz() {
            stan.sprawdz();
        }

        Stan getStanSprawdzania() {
            return sprawdzanieStan;
        }

        Stan getStanAutoryzacjiPoprawnej() {
            return autoryzacjaPoprawnaStan;
        }

        Stan getStanBleduAutoryzacji() {
            return bladAutoryzacjiStan;
        }

        Stan getStanBleduAutoryzacji3Razy() {
            return bladAutoryzacji3RazyStan;
        }
    }

    public static class SprawdzanieStan implements Stan
    {
        String login = "testLogin";
        String haslo = "testHaslo";
        int licznik = 0;
        private Autoryzacja autoryzacja;
        SprawdzanieStan(Autoryzacja autoryzacja) {
            this.autoryzacja = autoryzacja;
        }
        public void sprawdz() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj login:");
            String podanyLogin = scan.nextLine();
            System.out.println("Podaj haslo");
            String podaneHaslo = scan.nextLine();
            if((podanyLogin.equals(this.login)) && (podaneHaslo.equals(this.haslo)))
            {
                autoryzacja.setStan(autoryzacja.getStanAutoryzacjiPoprawnej());
                autoryzacja.sprawdz();
            }
            else
            {
                this.licznik += 1;
                if(this.licznik == 3)
                {
                    this.licznik = 0;
                    autoryzacja.setStan(autoryzacja.getStanBleduAutoryzacji3Razy());
                    autoryzacja.sprawdz();
                }
                else
                {
                    autoryzacja.setStan(autoryzacja.getStanBleduAutoryzacji());
                    autoryzacja.sprawdz();
                }
            }
        }
    }

    public static class AutoryzacjaPoprawnaStan implements Stan
    {
        AutoryzacjaPoprawnaStan(Autoryzacja autoryzacja) {
        }
        public void sprawdz() {
            System.out.println("Zalogowano");
        }
    }

    public static class BladAutoryzacjiStan implements Stan {
        private Autoryzacja autoryzacja;
        BladAutoryzacjiStan(Autoryzacja autoryzacja)
        {
            this.autoryzacja = autoryzacja;
        }
        public void sprawdz()
        {
            System.out.println("Niepoprawny login lub hasło");
            autoryzacja.setStan(autoryzacja.getStanSprawdzania());
        }
    }

    public static class BladAutoryzacji3RazyStan implements Stan
    {
        private Autoryzacja autoryzacja;
        private Long czas = -1l;
        BladAutoryzacji3RazyStan(Autoryzacja autoryzacja) {
            this.autoryzacja = autoryzacja;
        }
        public void sprawdz()
        {
            GregorianCalendar gc = new GregorianCalendar();
            if (czas == -1l)
            {
                czas = gc.getTime().getTime();
            }
            if ((gc.getTime().getTime() - czas) >= 30000) {
                autoryzacja.setStan(autoryzacja.getStanSprawdzania());
                autoryzacja.getStan().sprawdz();
                czas = -1l;
                return;
            }
            System.out.println("Podano trzy razy nieprawidłowy login lub hasło, możliwość logowania zostałą zablokowana na 30 sekund");
        }
    }
}
