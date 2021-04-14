package ZPO.Strategia;
import java.util.Random;

public class cw1
{
    public static class kaczka
    {
        int wiek;
        String nazwa;
        float waga;

        kaczka(String nazwa, int wiek, float waga)
        {
            this.nazwa = nazwa;
            this.wiek = wiek;
            this.waga = waga;
        }
        public void wypiszDane()
        {
            System.out.println("Nazwa: " + nazwa + "\n" + "Wiek: " + wiek + " lat" + "\n" + "Waga: " + waga + " kg");
        }

        public int getWiek()
        {
            return wiek;
        }
    }

    public static void main(String[] args)
    {
        kaczka kaczka1 = new kaczka("młoda", 3, 0.5f);
        kaczka kaczka2 = new kaczka("stara", 7, 1.1f);
        kaczka kaczka3 = new kaczka("srednia", 5, 0.7f);
        kaczka kaczka4 = new kaczka("najstarsza", 9, 1.4f);
        kaczka kaczka5 = new kaczka("najmlodsza", 1, 0.4f);
        kaczka kaczka6 = new kaczka("gumowa", 25, 0.1f);

        kaczka[] kaczki = new kaczka[6];

        kaczki[0] = kaczka1;
        kaczki[1] = kaczka2;
        kaczki[2] = kaczka3;
        kaczki[3] = kaczka4;
        kaczki[4] = kaczka5;
        kaczki[5] = kaczka6;

        Random random = new Random();
        int liczba = random.nextInt(4 - 1) + 1;
        long start;
        long koniec;

        switch (liczba)
        {
            case 1:
                start = System.nanoTime();
                sortowanieBabelkowe(kaczki);
                koniec = System.nanoTime();
                System.out.println("Sortowanie bąbelkowe. Czas sortowania: " + (koniec - start));
                break;
            case 2:
                start = System.nanoTime();
                sortowaniePrzezWstawianie(kaczki);
                koniec = System.nanoTime();
                System.out.println("Sortowanie przez wstawianie. Czas sortowania: " + (koniec - start));

                break;
            case 3:
                start = System.nanoTime();
                sortowaniePrzezWybieranie(kaczki);
                koniec = System.nanoTime();
                System.out.println("Sortowanie przez wybieranie. Czas sortowania: " + (koniec - start));
                break;
        }
        wyswietlTabile(kaczki);
    }

    public static void sortowanieBabelkowe(kaczka arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getWiek() > arr[j + 1].getWiek())
                {
                    kaczka temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void sortowaniePrzezWstawianie(kaczka arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i)
        {
            kaczka temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getWiek() > temp.getWiek())
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }

    public static void sortowaniePrzezWybieranie (kaczka arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j].getWiek() < arr[min_idx].getWiek())
                    min_idx = j;

            kaczka temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void wyswietlTabile(kaczka arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
        {
            arr[i].wypiszDane();
        }
        System.out.println();
    }
}
