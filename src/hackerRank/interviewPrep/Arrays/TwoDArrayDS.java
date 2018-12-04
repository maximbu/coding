package hackerRank.interviewPrep.Arrays;

public class TwoDArrayDS {

    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                maxSum = Math.max(maxSum, calcHourglassSumVal(arr, i, j));
            }
        }
        return maxSum;
    }

    private static int calcHourglassSumVal(int[][] arr, int i, int j) {
        int sum = arr[i + 1][j + 1];
        for (int k = 0; k < 3; k++) {
            sum += arr[i][j + k] + arr[i + 2][j + k];
        }
        return sum;
    }
}
