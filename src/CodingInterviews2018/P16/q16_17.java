package CodingInterviews2018.P16;

import java.util.Arrays;

public class q16_17 {

    private static int contSeq(int[] arr) {
        int max = arr[0];
        int sum = 0;
        int negSeq = 0;
        for (int value : arr) {
            if (value >= 0 || value > max) {
                sum = Math.max(sum + value + negSeq, value);
                negSeq = 0;
                max = Math.max(sum, max);
            } else {
                negSeq += value;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {2, -8, 3, -2, 4, -10};
        System.out.println("contSeq for:" + Arrays.toString(arr) + " is:" + contSeq(arr));
        int[] arr2 = {-2, -8, -3, -2, 4, -10};
        System.out.println("contSeq for:" + Arrays.toString(arr2) + " is:" + contSeq(arr2));
        int[] arr3 = {-2, -8, -3, -1, -4, -10};
        System.out.println("contSeq for:" + Arrays.toString(arr3) + " is:" + contSeq(arr3));
    }
}
