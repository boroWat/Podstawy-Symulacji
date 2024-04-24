import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;
import dissimlab.random.RNGenerator;

    public class NowyKlientSimEvent extends BasicSimEvent<Kolejka, Object> {
        RNGenerator random = new RNGenerator();
        int ID = 0;
        public NowyKlientSimEvent(Kolejka kolejka, Object params, double period) throws SimControlException {
            super(kolejka, params, period);
        }

        @Override
        protected void stateChange(){
            Kolejka kolejka = getSimObj();
            if(kolejka.czasPojawieniaSieNowegoKlienta <= simTime())
            {
                double czasZniecierliwienia = kolejka.rng.uniform(kolejka.A, kolejka.B);

                Klient klient = new Klient( ID, simTime(), czasZniecierliwienia);
                ID++;
                kolejka.listaKlientów.add(klient);

                kolejka.czasPojawieniaSieNowegoKlienta = random.exponential(kolejka.lambda) + simTime();
                System.out.println("Czas:" + simTime() + " Nowy klient,  nr " + klient.ID);
            }
        }

        @Override
        protected void onTermination() {
        }

        @Override
        public Object getEventParams() {
            return null;
        }
    }


