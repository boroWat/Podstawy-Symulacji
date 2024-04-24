import dissimlab.broker.INotificationEvent;
import dissimlab.broker.IPublisher;
import dissimlab.monitors.MonitoredVar;
import dissimlab.random.RNGenerator;
import dissimlab.simcore.BasicSimObj;

import java.util.ArrayList;
import java.util.List;

    public class Kolejka extends BasicSimObj {
        public RNGenerator rng;
        public List<Klient> listaKlientów;
        //MonitoredVar czasWSystemie;
        //MonitoredVar liczbaKlientowWKolejce;

        double czasPojawieniaSieNowegoKlienta;
        double A, B, mi, sigma, lambda;
        int L;
        //double krokowWOdcinku;

        public Kolejka(double v1, double v2, double lam, double p1, double p2, int l) {
            super();
            rng = new RNGenerator();
            //czasWSystemie = new MonitoredVar(0);
            //liczbaKlientowWKolejce = new MonitoredVar(0);
            listaKlientów = new ArrayList<>();
            //dlugosc = d;
            A = v1;
            B = v2;
            lambda = lam;
            mi = p1;
            sigma = p2;
            L = l;
            //odcinek = odc;
            //krokowWOdcinku = (int)ileOdc;
            czasPojawieniaSieNowegoKlienta = simTime() +;
        }


        @Override
        public void reflect(IPublisher iPublisher, INotificationEvent iNotificationEvent) {
        }

        @Override
        public boolean filter(IPublisher iPublisher, INotificationEvent iNotificationEvent) {
            return true;
        }
    }
