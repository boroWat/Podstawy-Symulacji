/*package paczka2;
import dissimlab.simcore.BasicSimEvent;

import dissimlab.simcore.SimControlException;

import java.util.Iterator;

public class ZdarzenieZniecierpliwienie extends BasicSimEvent<Urzad, Object> {

    public ZdarzenieZniecierpliwienie(Urzad urzad) throws SimControlException {
        super(urzad);
    }
    @Override
    protected void stateChange() throws SimControlException {

        Urzad urzad = getSimObj();

        Iterator<Interesant> iterInteresanci= urzad.kolejka.iterator();

        while(iterInteresanci.hasNext() && !urzad.kolejka.isEmpty())
        {
            Interesant sprawdzanyInteresant = iterInteresanci.next();
            if(sprawdzanyInteresant.getOkresZniecierpliwiania() <= simTime())
            {
                iterInteresanci.remove();
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
}*/

