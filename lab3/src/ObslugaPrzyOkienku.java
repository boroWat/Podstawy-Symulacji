import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;
import dissimlab.random.RNGenerator;

    public class ObslugaPrzyOkienku extends BasicSimEvent<Kolejka, Object> {
        RNGenerator random = new RNGenerator();
        private Okienko[] okienka;
        private int liczbaOkienek;
        //boolean zaparkowany = false;
        public ObslugaPrzyOkienku(Kolejka kolejka, Object params, double period) throws SimControlException {
            super(kolejka, params, period);
        }

        @Override
        protected void stateChange() {
            Kolejka kolejka = getSimObj();

            for (Klient klient : kolejka.listaKlientów) {
                if (klient.czasZniecierpliwienia >= simTime()) {


                    }


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

