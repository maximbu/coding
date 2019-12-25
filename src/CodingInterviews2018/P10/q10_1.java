package CodingInterviews2018.P10;

import java.util.Arrays;

public class q10_1 {
    private static void sortedMerge(int[] longA, int[] shortA) {
        int s = shortA.length - 1;
        int insert = longA.length - 1;
        int l = insert - s - 1;
        while (insert >= 0) {
            longA[insert--] = (s < 0 || (l >= 0 && (shortA[s] < longA[l]))) ? longA[l--] : shortA[s--];
        }
    }


    public static void main(String[] st) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 6, 7, 7, 7};
        sortedMerge(a, b);
        System.out.print(Arrays.toString(a));
    }
}
