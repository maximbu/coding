package CodingInterviews.P10;

import java.util.Arrays;

/**
 * Created by max on 12/29/2016.
 */
public class q10_1 {
    public static void sortedMerge(int[] a, int[] b) {
        if (b.length == 0) {
            return;
        }
        int ins = a.length - 1;
        int i = a.length - b.length - 1;
        int j = b.length - 1;

        while (j >= 0) {
            if (i >= 0 && a[i] > b[j]) {
                a[ins--] = a[i--];
            } else {
                a[ins--] = b[j--];
            }
        }
    }


    public static void main(String[] st) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 6, 7, 7, 7};
        sortedMerge(a, b);
        System.out.print(Arrays.toString(a));
    }
}
