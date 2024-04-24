package paczka2;

import dissimlab.broker.INotificationEvent;
import dissimlab.broker.IPublisher;
import dissimlab.simcore.BasicSimObj;

public class Interesant extends BasicSimObj {
    private int ID;

    private double OkresZniecierpliwiania;

    public double getOkresZniecierpliwiania() {
        return OkresZniecierpliwiania;
    }


    private boolean ifOstatni=false;
    private double czasWejscia;

    public int getID() {
        return ID;
    }

    public double getCzasWejscia() {
        return czasWejscia;
    }

    public Interesant(int ID){
        this.ID = ID;
        czasWejscia=simTime();
    }

    public void zmiana(){ifOstatni = true;}
    public boolean Czyostatni(){return ifOstatni;}
    @Override
    public void reflect(IPublisher iPublisher, INotificationEvent iNotificationEvent) {

    }

    @Override
    public boolean filter(IPublisher iPublisher, INotificationEvent iNotificationEvent) {
        return false;
    }
}
