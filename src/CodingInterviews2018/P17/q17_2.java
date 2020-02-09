package CodingInterviews2018.P17;

import java.util.Arrays;
import java.util.Random;

public class q17_2 {

    private static void shuffle(int[] cards) {
        Random rand = new Random();
        for (int i = cards.length - 1; i >= 0; i--) {
            swap(cards, i, rand.nextInt(i + 1));
        }
    }

    private static void swap(int[] cards, int i, int j) {
        int tmp = cards[i];
        cards[i] = cards[j];
        cards[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[52];
        Arrays.setAll(a, i -> i);
        shuffle(a);
        System.out.printf("Shuffled desc is : %s%n", Arrays.toString(a));
    }
}
