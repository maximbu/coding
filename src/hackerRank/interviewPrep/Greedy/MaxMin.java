package hackerRank.interviewPrep.Greedy;

import java.util.Arrays;

public class MaxMin {
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int min = arr[i];
            int max = arr[i + k - 1];
            int diff = max - min;
            ans = Math.min(ans, diff);
        }
        return ans;
    }

    public static void main(String[] s) {
        maxMin(3, new int[]{100, 200, 300, 350, 400, 401, 402});
        maxMin(3, new int[]{10, 100, 300, 200, 1000, 20, 30});
    }
}
