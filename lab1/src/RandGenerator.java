

public class RandGenerator {
    public int a;
    public int b;
    public int M;
    public int x0;

    public RandGenerator(int a, int b, int M, int x0) {
        this.a = a;
        this.b = b;
        this.M = M;
        this.x0 = x0;
    }

    public int nextInt() {
        x0 = (a * x0 + b) % M;
        return x0;
    }

    public double nextDouble() {
        return (double)nextInt() / M;
    }

    public double nextDouble(double low, double high) {
        return nextDouble() * (high - low) + low;
    }

    public double exponential(double lambda) {
        return -Math.log(1 - nextDouble()) / lambda;
    }

    public double rozklad1(){
        double n = (double)nextInt();
        if(n < M/2) return nextDouble(-1,0);
        else return nextDouble(0,2);
    }

    public double dyskret(double[] xx, double[] p)  {
        double prawdo = nextDouble(0, 1);
        double a = 0;
        double wynik;
        int i = 0;
        while (( a <= prawdo) && (i < p.length)){
            a += p[i];
            i++;
        }

        return xx[i-1];
    }

}
