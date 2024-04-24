package Zadanie1;

public class Main {
    public static void main(String[] args) {
        Calka calka = new Calka();
        Funkcja1 funkcja1 = new Funkcja1();
        Funkcja2 funkcja2 = new Funkcja2();
        double wynikFunkcja1 = 0;
        double sr_blad = 0;
        double sr_wynik = 0;



        System.out.println("za każądym razem licze średnią dla 10 powtórzeń");

        System.out.println("--------------------Funkcja1      : 3------------------------");
        // Przykładowe użycie dla funkcji 1
        for (int i=10; i<=100000; i=i*10) {
            for (int j=1; j<=10; j++){
                wynikFunkcja1 = calka.calculate(1,Math.exp(1), funkcja1, i);
                sr_wynik += wynikFunkcja1;
                sr_blad += Math.abs(3-wynikFunkcja1);
            }
            sr_wynik /= 10;
            sr_blad /= 10;

            System.out.println("średnio Funkcja1 (dla n=" + i +"): " + sr_wynik + "   a średni blad: " + sr_blad);
            sr_blad = 0;
            sr_wynik = 0;
        }
        System.out.println("---------------------------Funkcja2 = 0,829887  ----------------------------");
        double wynikFunkcja2 = 0;

        // Przykładowe użycie dla funkcji 2
        for (int i=10; i<=100000; i=i*10) {
            for (int j=1; j<=10; j++){
                wynikFunkcja1 = calka.calculate(1,Math.exp(1), funkcja1, i);
                sr_wynik += wynikFunkcja1;
                sr_blad += Math.abs(3-wynikFunkcja1);
            }
            sr_wynik /= 10;
            sr_blad /= 10;

            System.out.println("średnio Funkcja2 (dla n=" + i +"): " + sr_wynik + "   a średni blad: " + sr_blad);
            sr_blad = 0;
            sr_wynik = 0;
        }



    }
}
