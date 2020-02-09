package CodingInterviews2018.P17;

import java.util.Arrays;
import java.util.Random;

public class q17_3 {

    private static int[] pickM(int[] arr , int m) {
        int[] ans = arr.clone();
        Random rand = new Random();
        for (int i = ans.length - 1; i >= 0; i--) {
            swap(ans, i, rand.nextInt(i + 1));
        }
        return Arrays.copyOf(ans,m);
    }

    private static void swap(int[] cards, int i, int j) {
        int tmp = cards[i];
        cards[i] = cards[j];
        cards[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[20];
        Arrays.setAll(a, i -> i);
        int m = 5;
        System.out.printf("Picked %d random nums from %s: %s%n", m , Arrays.toString(a), Arrays.toString(pickM(a, m)));
    }
}
