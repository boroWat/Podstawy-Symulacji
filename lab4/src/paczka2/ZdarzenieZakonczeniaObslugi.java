package paczka2;

import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

public class ZdarzenieZakonczeniaObslugi extends BasicSimEvent<Urzad, Interesant> {

    public ZdarzenieZakonczeniaObslugi(Urzad urzad, double delay, Interesant interesant) throws SimControlException {
        super(urzad, delay, interesant);
    }

    @Override
    protected void stateChange() throws SimControlException {
        Urzad urzad = getSimObj();
        urzad.zwolnijOkienko();
        urzad.updateCzasPrzebywania(getEventParams().getCzasWejscia());
        if(urzad.czyKolejkaMaInteresantow()){
            new ZdarzenieRozpoczecieObslugi(urzad);
        }
        if(getEventParams().Czyostatni()){
            stopSimulation(0);
        }
    }


    @Override
    protected void onTermination() throws SimControlException {
    }

    @Override
    public Interesant getEventParams() {
        return eventParams;
    }
}
