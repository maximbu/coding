package hackerRank.interviewPrep.DynamicProgramming;

public class MaxArraySum {

    static int maxSubsetSum(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = Math.max(0, arr[0]);
        max[1] = Math.max(0, Math.max(arr[0], arr[1]));
        for (int i = 2; i < arr.length; i++) {
            max[i] = Math.max(Math.max(0, arr[i]), Math.max(arr[i] + max[i - 2], max[i - 1]));
        }
        return max[arr.length - 1];
    }
}
