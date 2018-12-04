package hackerRank.interviewPrep.Arrays;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = createDiffArray(n, queries);
        return getMax(arr);
    }

    private static long[] createDiffArray(int n, int[][] queries) {
        long[] arr = new long[n + 1];
        for (int[] q : queries) {
            arr[q[0] - 1] += q[2];
            arr[q[1]] -= q[2];

        }
        return arr;
    }

    private static long getMax(long[] arr) {
        long max = arr[0];
        long sum = 0;
        for (long x : arr) {
            sum += x;
            max = Math.max(max, sum);
        }
        return max;
    }
}
