package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 *  Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class MinSumPathInTriangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int[] dp = new int[a.get(a.size() - 1).size()];
        for (ArrayList<Integer> row : a) {
            int[] prev = Arrays.copyOf(dp, dp.length);
            for (int i = 0; i < row.size(); i++) {
                dp[i] = row.get(i);
                if (i == 0) {
                    dp[i] += prev[0];
                    continue;
                }
                if (i == row.size() - 1) {
                    dp[i] += prev[row.size() - 2];
                    continue;
                }
                dp[i] += Math.min(prev[i], prev[i - 1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x : dp) {
            min = Math.min(min, x);
        }
        return min;
    }
}
