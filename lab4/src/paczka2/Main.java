package paczka2;

import dissimlab.monitors.Diagram;
import dissimlab.monitors.MonitoredVar;
import dissimlab.monitors.Statistics;
import dissimlab.simcore.SimControlException;
import dissimlab.simcore.SimManager;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws SimControlException {
        SimManager sm = SimManager.getInstance();


        double mi = 0.4;
        double lambda = 0.5;
        int maxKlientow = 50;
        MonitoredVar czasPrzebywania = new MonitoredVar();
        MonitoredVar dlugoscKolejki = new MonitoredVar();
        MonitoredVar zajetosc = new MonitoredVar();

        Urzad urzad = new Urzad(mi, lambda, czasPrzebywania, dlugoscKolejki, zajetosc, maxKlientow);
        ZdarzenieNowyInteresant start = new ZdarzenieNowyInteresant(urzad, 0);
        sm.startSimulation();

        System.out.println("Średnia długość kolejki: " + Statistics.weightedMean(dlugoscKolejki));
        System.out.println("Średni czas obslugi klienta: " + Statistics.weightedMean(czasPrzebywania));
        System.out.println("Średnia zajętość kasy: " + Statistics.weightedMean(zajetosc));

        Diagram diagram1 = new Diagram(Diagram.DiagramType.DISTRIBUTION, "Dystrybuanta czasu obslugi");
        diagram1.add(czasPrzebywania, Color.PINK);
        diagram1.show();

        Diagram diagram2 = new Diagram(Diagram.DiagramType.TIME, "Zmiana w czasie dlugosci kolejki");
        diagram2.add(dlugoscKolejki, Color.ORANGE);
        diagram2.show();

        Diagram diagram3 = new Diagram(Diagram.DiagramType.TIME, "Zajetosc okienek");
        diagram3.add(zajetosc, Color.MAGENTA);
        diagram3.show();
    }
}




