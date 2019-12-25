package CodingInterviews.P16;

import java.util.Arrays;

/**
 * Created by max on 1/21/2017.
 */
public class q16_6 {
    public static int minDist(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < a.length && j < b.length) {
            i = Math.min(i, a.length - 1);
            j = Math.min(j, b.length - 1);
            int d = Math.abs(a[i] - b[j]);
            if (d <= min) {
                min = d;
                if (a[i] < b[j]) i++;
                else j++;
            } else return min;
        }
        return min;
    }

    public static void main(String[] st) {
        int[] a = new int[]{1, 2, 11, 15};
        int[] b = new int[]{4, 12, 19, 23, 127, 235};
        System.out.println(minDist(a, b));
    }
}
