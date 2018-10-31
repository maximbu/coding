package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Find longest Arithmetic Progression in an integer array and return its length. More formally, find longest sequence of indeces, 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression. Arithmetic Progression is a sequence in which all the differences between consecutive pairs are the same, i.e sequence B[0], B[1], B[2], …, B[m - 1] of length m is an Arithmetic Progression if and only if B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2].
 * Examples
 * 1) 1, 2, 3(All differences are equal to 1)
 * 2) 7, 7, 7(All differences are equal to 0)
 * 3) 8, 5, 2(Yes, difference can be negative too)
 *
 * Samples
 * 1) Input: 3, 6, 9, 12
 * Output: 4
 *
 * 2) Input: 9, 4, 7, 2, 10
 * Output: 3(If we choose elements in positions 1, 2 and 4(0-indexed))
 */
public class LongestArithmeticProgression {

  public int solve(final int[] A) {
    if (A.length <= 2)
      return A.length;
    int[] B = Arrays.copyOf(A, A.length);
    Arrays.sort(B);
    int[][] dp = new int[A.length][A.length];
    int max = 2;
    for (int i = 0; i < A.length; i++) {
      dp[i][A.length - 1] = 2;
    }
    for (int last = A.length - 2; last >= 1; last--) {
      int left = last - 1;
      int right = last + 1;
      while (left >= 0 && right < A.length) {
        int sum = B[left] + B[right];
        if (sum < 2 * B[last]) {
          right++;
          continue;
        }
        if (sum > 2 * B[last]) {
          dp[left][last] = 2;
          left--;
          continue;
        }
        dp[left][last] = dp[last][right] + 1;
        max = Math.max(max, dp[left][last]);
        left--;
        right++;
      }
      while (left >= 0) {
        dp[left--][last] = 2;
      }
    }
    return max;
  }

  public static void main(String[] st) {
    LongestArithmeticProgression q = new LongestArithmeticProgression();
    System.out.println(q.solve(new int[]{1, 1, 1, 1}));
    System.out.println(q.solve(new int[]{9, 4, 7, 2, 10}));
  }
}
