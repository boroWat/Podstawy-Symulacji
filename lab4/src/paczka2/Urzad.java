package paczka2;

import dissimlab.broker.INotificationEvent;
import dissimlab.broker.IPublisher;
import dissimlab.monitors.MonitoredVar;
import dissimlab.random.RNGenerator;
import dissimlab.simcore.BasicSimObj;
import paczka2.Interesant;

import java.util.ArrayList;

public class Urzad extends BasicSimObj {
    private RNGenerator rng;
    private double lambda;
    private double mi;
    public ArrayList<Interesant> kolejka;

    private Interesant obslugiwany;

    private MonitoredVar czasPrzebywania, dlugoscKolejki, zajetoscOkienka;
    private int licznikKlientow;
    private int maxKlientow;



    public Urzad(double mi, double lambda, MonitoredVar czasPrzebywania, MonitoredVar dlugoscKolejki, MonitoredVar zajetoscKasy, int maxKlientow){
        rng = new RNGenerator(RNGenerator.generateSeed());
        this.mi = mi;
        this.lambda = lambda;
        kolejka = new ArrayList<>();
        this.czasPrzebywania = czasPrzebywania;
        this.dlugoscKolejki = dlugoscKolejki;
        this.zajetoscOkienka = zajetoscKasy;
        licznikKlientow = 0;
        this.maxKlientow = maxKlientow;
    }

    public void zajmijOkienko(){
        if (kolejka.size() > 0)
            obslugiwany = kolejka.get(0);
        else
            obslugiwany = null;
        zajetoscOkienka.setValue(1, simTime());
    }

    public void zwolnijOkienko(){
        obslugiwany = null;
        zajetoscOkienka.setValue(0, simTime());
    }

    public boolean getOkienkoZajeta(){
        return zajetoscOkienka.getValue() == 1;
    }

    public boolean dodajDoKolejki(Interesant interesant){
        kolejka.add(interesant);
        updateDlugpscKolejki();
        return true;
    }

    public Interesant pobierzZKolejki(){
        if(czyKolejkaMaInteresantow()){
            Interesant klientZKolejki = kolejka.remove(0);
            updateDlugpscKolejki();
            return klientZKolejki;
        }else return null;
    }

    public boolean czyKolejkaMaInteresantow(){
        return  kolejka.size() > 0;
    }

    public double generujCzasObslugi(){
        return rng.exponential(mi);
    }

    public void updateCzasPrzebywania(double czasWejscia){
        czasPrzebywania.setValue(simTime()-czasWejscia);
    }

    public void updateDlugpscKolejki(){
        dlugoscKolejki.setValue(kolejka.size());
    }


    public int getMaxKlientow() {return maxKlientow;}
    public int getLicznikKlientow() {return licznikKlientow;}
    public double getDelay(){
        return rng.exponential(lambda);
    }

    public int getNextID(){
        return licznikKlientow++;
    }

    public boolean czyMoznaDodacKlienta(){
        return licznikKlientow < maxKlientow;
    }

    @Override
    public void reflect(IPublisher iPublisher, INotificationEvent iNotificationEvent) {

    }

    @Override
    public boolean filter(IPublisher iPublisher, INotificationEvent iNotificationEvent) {
        return false;
    }
}
