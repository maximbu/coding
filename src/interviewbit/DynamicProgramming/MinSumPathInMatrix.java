package interviewbit.DynamicProgramming;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 *  Note: You can only move either down or right at any point in time.
 * Example :
 *
 * Input :
 *
 *     [  1 3 2
 *        4 3 1
 *        5 6 1
 *     ]
 *
 * Output : 8
 *      1 -> 3 -> 2 -> 1 -> 1
 */
public class MinSumPathInMatrix {
    public int minPathSum(int[][] A) {
        int[][] tmp = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0 && j == 0) {
                    tmp[i][j] = A[i][j];
                    continue;
                }
                tmp[i][j] = Math.min((i > 0 ? tmp[i - 1][j] : Integer.MAX_VALUE), (j > 0 ? tmp[i][j - 1] : Integer.MAX_VALUE)) + A[i][j];
            }
        }
        return tmp[A.length - 1][A[0].length - 1];
    }

    public static void main(String[] st) {
        MinSumPathInMatrix q = new MinSumPathInMatrix();
        int[][] A = {
                {20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
                {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
                {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
                {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
                {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
                {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
                {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
                {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
        };
        System.out.println(q.minPathSum(A));
    }
}
