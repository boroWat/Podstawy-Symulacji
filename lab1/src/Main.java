import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 97;
        int b = 1;
        int M = 100;
        int x0 = 11;
        RandGenerator Rand = new RandGenerator(a, b, M, x0);
        int spr = Rand.nextInt();
        System.out.println(spr);
        double spr2 = Rand.nextDouble();
        System.out.println(spr2);
        double spr3 = Rand.nextDouble(3,30);
        System.out.println(spr3);
        double spr4 = Rand.exponential(3);
        System.out.println(spr4);

        //1.4 ocena generatorów
        double pom_avg = 0;
        System.out.println("Wstępna ocena generatorów:");
        int liczba = 1000;
        for (int i = 0; i < liczba; i++) {
            pom_avg += (double)Rand.nextInt();
        }
        pom_avg /= (double)liczba;
        System.out.println("Wartość teoretyczna średniej F1: " + M/2);
        System.out.println("średnia F1: "+pom_avg);
        System.out.println("różnica: "+ (pom_avg - M/2));
        pom_avg = 0;

        for (int i = 0; i < 1000; i++) {
            pom_avg += Rand.nextDouble();
        }
        pom_avg /= (double)liczba;
        System.out.println("Wartość teoretyczna średniej F2: "+ ((double)(M)/2)/((double)(M)));
        System.out.println("średnia F2: "+pom_avg);
        System.out.println("średnia F2: "+(pom_avg - ((double)(M)/2)/((double)(M))));
        pom_avg = 0;

        double low = 12;
        double high = 18;
        for (int i = 0; i < 1000; i++) {
            pom_avg += Rand.nextDouble(low,high);
        }
        pom_avg /= (double)liczba;
        System.out.println("Wartość teoretyczna średniej F3: " + ((low+ high) /2));
        System.out.println("średnia F3: "+pom_avg);
        System.out.println("Różnica: "+(pom_avg - ((low+ high) /2)));
        pom_avg = 0;

        double lambda = 0.1;
        for (int i = 0; i < 1000; i++) {
            pom_avg += Rand.exponential(lambda);
        }
        pom_avg /= (double)liczba;
        System.out.println("Wartość teoretyczna średniej F4: " + (1/lambda));
        System.out.println("średnia F4: "+pom_avg);
        System.out.println("różnica: "+ (pom_avg - (1/lambda)));
        pom_avg = 0;


        System.out.println("Porównanie z random:");

        for (int i = 0; i < liczba; i++) {
            pom_avg += (double)Rand.nextInt();
        }
        pom_avg /= (double)liczba;
        System.out.println("średnia F1: "+pom_avg);

        pom_avg = 0;


        Random random = new Random();
        for (int i = 0; i < liczba; i++) {
            pom_avg += random.nextInt(M);
        }
        pom_avg /= (double)liczba;
        System.out.println("średnia Random: "+pom_avg);
        pom_avg = 0;

        lambda = 0.1; //parametr rozkładu wykładniczego
        System.out.println("wylosowana liczba dla rozkładu wykładniczego z parametrem lambda = " + lambda +" wynosi: " + Rand.exponential(lambda));


        for (int i = 0; i < liczba; i++) {
            pom_avg += Rand.rozklad1();
        }
        pom_avg /= (double)liczba;
        System.out.println("średnia teoretyczna: 0");
        System.out.println("średnia która wyszła z rozkład1: "+pom_avg);
        pom_avg = 0;

        double[] xx = new double[7];
        double[] p = new double[7];

        xx[0] = -2;
        xx[1] = -1;
        xx[2] = 0;
        xx[3] = 1;
        xx[4] = 2;
        xx[5] = 3;
        xx[6] = 4;

        p[0] = 0.1;
        p[1] = 0.1;
        p[2] = 0.1;
        p[3] = 0.1;
        p[4] = 0.2;
        p[5] = 0.2;
        p[6] = 0.2;

        for (int i = 0; i < 1000; i++) {
            pom_avg += Rand.dyskret(xx,p);
        }
        pom_avg /= (double)liczba;
        System.out.println("średnia wyszła: " + pom_avg);
        pom_avg =0;
        //średnia teoretyczna dla rozkładu dyskretnnego
        for (int i = 0; i < p.length; i++)
            pom_avg += xx[i] * p[i];
        System.out.println("średnia która wyszła z rozkład1: "+pom_avg);






    }
}