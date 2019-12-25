package hackerRank.interviewPrep.Greedy;

import java.util.Arrays;

public class MinimunAbsoluteDiffInAnArray {
    static int minimumAbsoluteDifference(int[] arr) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            ans = Math.min(ans, Math.abs(arr[i] - arr[i - 1]));
        }
        return ans;
    }

    public static void main(String[] s) {
        System.out.println(minimumAbsoluteDifference(new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}));
        System.out.println(minimumAbsoluteDifference(new int[]{1, -3, 71, 68, 17}));
    }
}
