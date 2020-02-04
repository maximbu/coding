package CodingInterviews2018.P16;

import java.util.Arrays;

public class q16_6 {

    private static int smallestDiff(int[] a , int[] b) {
        int ans = Integer.MAX_VALUE;
        if (a.length == 0 || b.length == 0) return ans;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            int diff = Math.abs(a[i] - b[j]);
            ans = Math.min(diff, ans);
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 15, 11, 2 };
        int[] b = {23, 127, 235, 19, 8};
        System.out.println(smallestDiff(a,b));
    }
}
