package paczka2;

import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

public class ZdarzenieRozpoczecieObslugi extends BasicSimEvent<Urzad, Object> {

    public ZdarzenieRozpoczecieObslugi(Urzad urzad) throws SimControlException {
        super(urzad);
    }

    @Override
    protected void stateChange() throws SimControlException {
        Urzad urzad = getSimObj();
        if(!urzad.getOkienkoZajeta()){
            Interesant interesant = urzad.pobierzZKolejki();
            if(interesant !=null){
                urzad.zajmijOkienko();
                new ZdarzenieZakonczeniaObslugi(urzad, urzad.generujCzasObslugi(), interesant);
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

