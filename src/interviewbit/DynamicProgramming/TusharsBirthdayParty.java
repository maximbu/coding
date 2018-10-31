package interviewbit.DynamicProgramming;

import java.util.Arrays;

/**
 * As it is Tushar’s Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
 * Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar’s friends are satisfied (reached their eating capacity).
 *
 * NOTE:
 *
 * Each dish is supposed to be eaten by only one person. Sharing is not allowed.
 * Each friend can take any dish unlimited number of times.
 * There always exists a dish with filling capacity 1 so that a solution always exists.
 * Input Format
 *
 * Friends : List of integers denoting eating capacity of friends separated by space.
 * Capacity: List of integers denoting filling capacity of each type of dish.
 * Cost :    List of integers denoting cost of each type of dish.
 * Constraints:
 * 1 <= Capacity of friend <= 1000
 * 1 <= No. of friends <= 1000
 * 1 <= No. of dishes <= 1000
 *
 * Example:
 *
 * Input:
 *     2 4 6
 *     2 1 3
 *     2 5 3
 *
 * Output:
 *     14
 *
 * Explanation:
 *     First friend will take 1st and 2nd dish, second friend will take 2nd dish twice.  Thus,
 */
public class TusharsBirthdayParty {

  public int solve(final int[] A, final int[] B, final int[] C) {
    int max = A[0];
    for (int a : A) {
      max = Math.max(max, a);
    }
    long[][] dp = calcDP(B, C, max);
    return Arrays.stream(A).map(friend -> (int)dp[B.length - 1][friend]).sum();
  }

  private long[][] calcDP(int[] cap, int[] cost, int maxCap) {
    long[][] dp = new long[cap.length][maxCap + 1];
    for (long[] row : dp) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    for (int i = 0; i < cap.length; i++) {
      for (int j = 0; j <= maxCap; j++) {
        if (j == 0) {
          dp[i][j] = 0;
          continue;
        }
        if (i > 0) {
          dp[i][j] = dp[i - 1][j];
        }
        if (j >= cap[i]) {
          dp[i][j] = Math.min(dp[i][j], cost[i] + dp[i][j - cap[i]]);
        }
        if (i > 0) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
        }
      }
    }
    return dp;
  }

  public static void main(String[] st) {
    TusharsBirthdayParty q = new TusharsBirthdayParty();
    System.out.println(q.solve(new int[]{2, 3, 1, 5, 4},new int[]{3, 2, 4, 1},new int[]{1, 2, 5, 10}));
  }
}
