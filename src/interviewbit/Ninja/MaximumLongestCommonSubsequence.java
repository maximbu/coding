package interviewbit.Ninja;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Defining substring
 * For a string P with characters P1, P2 ,…, Pq, let us denote by P[i, j] the substring Pi, Pi+1 ,…, Pj.
 *
 * Defining longest common subsequence(LCS)
 * A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. LCS(A, B) of 2 sequences A and B is a subsequence, with maximal length, which is common to both the sequences.
 *
 * Given a string S with small alphabet characters S1, S2 ,…, SN, return an array with two elements. First is the smallest j (1 ≤ j < N) for which LCS(S[1, j], rev(S[j + 1, N])) is maximal and second is the maximal value of LCS(S[1, j], rev(S[j + 1, N])).
 * Here, rev(A) denotes reverse of string A.
 *
 * For example,
 *
 * S="abba"
 *
 * LCS(S[1, 1], rev(S[2, 4])) = LCS("a", "abb") = 1
 * LCS(S[1, 2], rev(S[3, 4])) = LCS("ab", "ab") = 2
 * LCS(S[1, 3], rev(S[4, 4])) = LCS("abb", "a") = 1
 *
 * Hence, we return [2, 2].
 */
public class MaximumLongestCommonSubsequence {

  public ArrayList<Integer> maxLCS(String A) {
    int bestJ = 1;
    int bestVal = 0;
    for (int i = 0; i < A.length() - 1; i++) {
      int x = findAns(A, i);
      if (x > bestVal) {
        bestVal = x;
        bestJ = i + 1;
      }
    }
    return new ArrayList<>(Arrays.asList(bestJ, bestVal));
  }

  private int findAns(String A, int ind) {
    return lcs(A.substring(0, ind + 1), new StringBuilder(A.substring(ind + 1)).reverse().toString());
  }

  private int lcs(String a, String b) {
    int[][] dp = new int[a.length() + 1][b.length() + 1];
    for (int i = 0; i < a.length() + 1; i++) {
      for (int j = 0; j < b.length() + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
          continue;
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return dp[a.length()][b.length()];
  }
}
