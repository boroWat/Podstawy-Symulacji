package Zadanie1;

class Funkcja1 implements IFunc {
    @Override
    public double func(double x) {
        // Implementacja funkcji 1
        return 3 / x;
    }

    @Override
    public double max(double a, double b) {
        // Implementacja funkcji max dla funkcji 1
        double maxValue = func(a);
        for (double i = a; i <= b; i=i+0.1) {
            double currentVal = func(i);
            if (currentVal > maxValue) {
                maxValue = currentVal;
            }
        }
        return maxValue;
    }
}