package interviewbit.DynamicProgramming;

/**
 * You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to accommodate the horses into the stables in such a way that the following conditions are satisfied:
 *
 * You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put horse 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
 * No stable should be empty and no horse should be left unaccommodated.
 * Take the product (number of white horses * number of black horses) for each stable and take the sum of all these products. This value should be the minimum among all possible accommodation arrangements
 * Example:
 *
 *
 * Input: {WWWB} , K = 2
 * Output: 0
 *
 * Explanation:
 * We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
 * for first choice we will get 1*0 + 2*1 = 2.
 * for second choice we will get 2*0 + 1*1 = 1.
 * for third choice we will get 3*0 + 0*1 = 0.
 *
 * Of the 3 choices, the third choice is the best option.
 */
public class ArrangeII {

  public int arrange(String A, int B) {
    if (A.length() < B)
      return -1;
    int[][] dp = new int[A.length()][B];
    int w = 0;
    int b = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == 'W') {
        w++;
      } else {
        b++;
      }
      dp[i][0] = b * w;
    }

    for (int i = 1; i < B; i++) {
      for (int j = 0; j < A.length(); j++) {
        if (i > j) {
          dp[j][i] = Integer.MAX_VALUE;
          continue;
        }
        dp[j][i] = getMinVal(A, dp, i, j);
      }
    }
    return (Math.max(dp[A.length() - 1][B - 1], 0));
  }

  private int getMinVal(String A, int[][] dp, int i, int j) {
    int w = 0;
    int b = 0;
    int minVal = Integer.MAX_VALUE;
    for (int k = j - 1; k >= 0; k--) {
      if (A.charAt(k + 1) == 'W') {
        w++;
      } else {
        b++;
      }
      int kVal = dp[k][i - 1] + w * b;
      if (kVal >= 0 && kVal < minVal)
        minVal = kVal;
    }
    return minVal;
  }
}
