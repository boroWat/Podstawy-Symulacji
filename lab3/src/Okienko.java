public class Okienko {
    public double czasZajetosci;

    public Okienko() {
        this.czasZajetosci = 0;
    }

    public boolean czyWolne(double aktualnyCzas) {return aktualnyCzas >= czasZajetosci;
    }

    public void zajmij(double aktualnyCzas, double czasObslugi) {
        this.czasZajetosci = aktualnyCzas + czasObslugi;
    }
}
