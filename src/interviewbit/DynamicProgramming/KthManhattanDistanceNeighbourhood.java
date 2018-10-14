package interviewbit.DynamicProgramming;

import java.util.Arrays;

/**
 * Given a matrix M of size nxm and an integer K, find the maximum element in the K manhattan distance neighbourhood for all elements in nxm matrix.
 * In other words, for every element M[i][j] find the maximum element M[p][q] such that abs(i-p)+abs(j-q) <= K.
 *
 * Note: Expected time complexity is O(N*N*K)
 *
 * Constraints:
 *
 * 1 <= n <= 300
 * 1 <= m <= 300
 * 1 <= K <= 300
 * 0 <= M[i][j] <= 1000
 * Example:
 *
 * Input:
 * M  = [[1,2,4],[4,5,8]] , K = 2
 *
 * Output:
 * ans = [[5,8,8],[8,8,8]]
 */
public class KthManhattanDistanceNeighbourhood {

  public int[][] solve(int A, int[][] B) {
    if (A == 0)
      return B;
    int[][] ans = new int[B.length][B[0].length];
    int[][][] dp = new int[B.length][B[0].length][A];
    for (int k = 0; k < A; k++) {
      for (int i = 0; i < B.length; i++) {
        for (int j = 0; j < B[0].length; j++) {
          int best = get(dp, B, i, j, k - 1);
          best = Math.max(best, get(dp, B, i - 1, j, k - 1));
          best = Math.max(best, get(dp, B, i + 1, j, k - 1));
          best = Math.max(best, get(dp, B, i, j - 1, k - 1));
          best = Math.max(best, get(dp, B, i, j + 1, k - 1));
          dp[i][j][k] = best;
        }
      }
    }
    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < B[0].length; j++) {
        ans[i][j] = dp[i][j][A - 1];
      }
    }
    return ans;
  }

  private int get(int[][][] dp, int[][] B, int i, int j, int k) {
    if (i < 0 || j < 0 || i >= B.length || j >= B[0].length) {
      return Integer.MIN_VALUE;
    }
    return k < 0 ? B[i][j] : dp[i][j][k];
  }

  public static void main(String[] st) {
    KthManhattanDistanceNeighbourhood q = new KthManhattanDistanceNeighbourhood();
    int[][] A = {{1, 2, 4}, {4, 5, 8}};
    System.out.println(Arrays.deepToString(q.solve(2, A)));
  }
}
