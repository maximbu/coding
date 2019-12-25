package CodingInterviews.P10;

import java.util.BitSet;

/**
 * Created by max on 12/30/2016.
 */
public class q10_8 {
    public static void printDupes(int[] arr) {
        BitSet b = new BitSet(32001);
        for (int n : arr) {
            if (b.get(n)) {
                System.out.print(n + ", ");
            }
            b.set(n);
        }
        System.out.println();
    }

    public static void main(String[] st) {
        int[] a = new int[32020];
        for (int i = 0; i < a.length; i++) {
            a[i] = (i + 1) % 32000;
        }
        printDupes(a);
    }
}
