package paczka2;

import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

public class ZdarzenieNowyInteresant extends BasicSimEvent<Urzad, Object> {



    public ZdarzenieNowyInteresant(Urzad urzad, double delay) throws SimControlException {
        super(urzad, delay);
    }

    @Override
    protected void stateChange() throws SimControlException {

        Urzad urzad = getSimObj();

        Interesant interesant = new Interesant(urzad.getNextID());
        if (interesant.getID() == urzad.getMaxKlientow()-1) {
            interesant.zmiana();
        }
        urzad.dodajDoKolejki(interesant);
        /*if(interesant.getOkresZniecierpliwiania() <=simTime())
            new ZdarzenieZniecierpliwienie(urzad);*/
        /*else*/{
            new ZdarzenieRozpoczecieObslugi(urzad);
            if(urzad.czyMoznaDodacKlienta()) {
                new ZdarzenieNowyInteresant(urzad, urzad.getDelay());
            }
        }
    }

    @Override
    protected void onTermination() throws SimControlException {

    }

    @Override
    public Object getEventParams() {
        return null;
    }
}
