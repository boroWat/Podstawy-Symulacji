package Zadanie2;

public class Main {
    public static void main(String[] args) {

        //int[] array = {1, 2, 3};
        //int length = array.length;
        //System.out.println("Ilość elementów w tablicy: " + length);

        Bank bank = new Bank(3); // Ustaw liczbę okienek
        double oszacowanie = 0;
        for (int i = 10; i<10000000;i=i*10) {
            oszacowanie = bank.symuluj(999999999, i);
            System.out.println("względna ilosc przyjetych klientow: "+ oszacowanie);
        }

    }
}
