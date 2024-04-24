package Zadanie1;

import dissimlab.random.RNGenerator;
class Calka {
    public double calculate(double a, double b, IFunc f, int rep) {
        double x = 0;
        double y = 0;
        double max = f.max(a, b);
        int trafione = 0;

        RNGenerator RNGenerator = new RNGenerator(System.nanoTime());




        for (int i = 0; i < rep; i++) {
            x = RNGenerator.uniform(a, b);
            y = RNGenerator.uniform(0, max);

            if (y <= f.func(x)) {
                trafione++;
            }
        }

        return (double)(trafione) / (double)(rep) * (b - a) * max;
    }
}