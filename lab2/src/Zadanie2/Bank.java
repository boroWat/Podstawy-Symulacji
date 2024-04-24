package Zadanie2;

import dissimlab.random.RNGenerator;

public class Bank {
    private int liczbaOkienek;
    private Okienko[] okienka;

    public Bank(int liczbaOkienek) {
        this.liczbaOkienek = liczbaOkienek;
        this.okienka = new Okienko[liczbaOkienek];
        for (int i = 0; i < liczbaOkienek; i++) {
            okienka[i] = new Okienko();
        }
    }

    public double symuluj(double czasSystemowy, int liczbaKlientow) {
        double aktualnyCzas = 0;
        int obsluzeni = 0;
        int odrzuceni = 0;

        RNGenerator RNGenerator = new RNGenerator(System.nanoTime());


        double czasPojawienia;
        boolean obsluzony;

        while (aktualnyCzas < czasSystemowy && obsluzeni + odrzuceni < liczbaKlientow) {
            // Symuluj pojawienie się nowego klienta
            czasPojawienia = RNGenerator.exponential(1.0);
            aktualnyCzas += czasPojawienia;

            // Znajdź pierwsze wolne okienko lub sprawdź, czy trzeba odrzucić zgłoszenie
            obsluzony = false;
            for (int i=0; i<okienka.length; i++) {
                if (okienka[i].czyWolne(aktualnyCzas)) {
                    double czasObslugi = RNGenerator.exponential(1.0);
                    okienka[i].zajmij(aktualnyCzas, czasObslugi);
                    obsluzeni++;
                    obsluzony = true;
                    //System.out.println("klient nr: " + (obsluzeni + odrzuceni) + " przyjęto w czasie: " + aktualnyCzas + "okienko nr: " + (i+1) + ", zajęte do: " +(aktualnyCzas+ czasObslugi));
                    break;
                }

            }

            if (obsluzony == false) {
                odrzuceni++;
                //System.out.println((obsluzeni + odrzuceni) + " nieprzyjęto: " + aktualnyCzas);
            }
        }

        //System.out.println("Liczba obsłużonych: " + obsluzeni);
        //System.out.println("Liczba odrzuconych: " + odrzuceni);
        return (double)(obsluzeni) / (double)(liczbaKlientow);
    }
}
