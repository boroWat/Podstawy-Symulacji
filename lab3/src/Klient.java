import dissimlab.random.RNGenerator;


public class Klient {

    //RNGenerator random = new RNGenerator();
    public RNGenerator rng;
    public int ID;
    //public double predkosc1, predkosc2, parkowanie;
    //public double przebytaDroga;
    double czasPojawienia;
    double czasZniecierpliwienia;

    //int poprzedniKrok;
    //double pozycja;
    //boolean cierpliwość;
    //double czasWSystemie;

    //double czasObslugi;

    public Klient(int ID, double czasPojawienia, double czaszniecierpliwienia){
        this.ID = ID;
        //this.czasWSystemie = 0;
        this.czasPojawienia = czasPojawienia;
        this.czasZniecierpliwienia = czaszniecierpliwienia;
        //this.poprzedniKrok = poprzedniKrok;
        //czasObslugi = 0;
        //pozycja = 0;
        //cierpliwość = false;
    }
}

