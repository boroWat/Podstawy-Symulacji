package Zadanie1;

class Funkcja2 implements IFunc {
    @Override
    public double func(double x) {
        // Implementacja funkcji 2
        return (3 + Math.sin(x)) / (x*x);
    }

    @Override
    public double max(double a, double b) {
        // Implementacja funkcji max dla funkcji 2
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
