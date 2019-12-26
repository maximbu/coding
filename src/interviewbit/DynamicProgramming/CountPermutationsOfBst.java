package interviewbit.DynamicProgramming;

import java.math.BigInteger;

public class CountPermutationsOfBst {

  int MOD = 1000000007;

  public int cntPermBST(int A, int B) {
    long[] facts = getFacts(A);
    return cntPerm(A, B, facts);
  }

  public int countPermBSTBDP(int A, int B) {
    long[][] dp = new long[A + 1][B + 1];
    dp[0][0] = 1;
    dp[1][0] = 1;
    for (int i = 1; i <= B; i++) {
      dp[0][i] = 0;
      dp[1][i] = 0;
    }
    long[] facts = getFacts(A);
    long res = 0;
    for (int i = 2; i <= A; i++) {
      for (int h = 1; h <= B && h < i; h++) {
        for (int nums = 1; nums <= i; nums++) {
          int x = nums - 1;
          int y = i - nums;

          long rightHeight = getHeightDP(h - 2, dp[x], dp[y][h - 1]);
          long leftHeight = getHeightDP(h - 2, dp[y], dp[x][h - 1]);

          long bothHeight = mul(dp[x][h - 1], dp[y][h - 1]);
          long totalForI = add(rightHeight, add(leftHeight, bothHeight));
          res = add(res, mul(totalForI, choose(x + y, y, facts)));
        }
        dp[i][h] = res;
      }
    }

    return (int) dp[A][B];
  }

  private long getHeightDP(int till, long[] dp, long constLen) {
    long rightHeight = 0;
    for (int h = 0; h <= till; h++) {
      rightHeight = add(rightHeight, mul(dp[h], constLen));
    }
    return rightHeight;
  }

  private long[] getFacts(int x) {
    long[] ans = new long[x + 1];
    ans[0] = 1;
    for (int i = 1; i < x + 1; i++) {
      ans[i] = (ans[i - 1] * i) % MOD;
    }
    return ans;
  }

  private int cntPerm(int A, int B, long[] facts) {
    if (A <= 0) {
      return B == 0 ? 1 : 0;
    }
    long total = 0;
    for (int i = 1; i <= A; i++) {
      int leftSize = i - 1;
      int rightSize = A - i;

      long rightHeight = getOneChildHeightCombinations(B, facts, leftSize, rightSize);
      long leftHeight = getOneChildHeightCombinations(B, facts, rightSize, leftSize);
      long bothHeight = mul(cntPerm(leftSize, B - 1, facts), cntPerm(rightSize, B - 1, facts));
      //((long) cntPerm(leftSize, B - 1, facts) % MOD) * ((long) cntPerm(rightSize, B - 1, facts) % MOD)) % MOD;
      long totalForI = add(rightHeight, add(leftHeight, bothHeight));
      totalForI = mul(totalForI, choose(A - 1, (int) leftHeight, facts));
      //totalForI = totalForI+(totalForI*choose(A-1,(int)leftHeight,facts))%100000007;
      total = add(total, totalForI);
    }
    return (int) total;
  }

  private long getOneChildHeightCombinations(int B, long[] facts, int lessThenHeightSize, int exactHeightSize) {
    long ans = 0;
    for (int h = 0; h < B - 1; h++) {
      ans = add(ans, mul(cntPerm(lessThenHeightSize, h, facts), cntPerm(exactHeightSize, B - 1, facts)));
      //ans = (ans + ((long) cntPerm(lessThenHeightSize, h, facts) % MOD) * ((long) cntPerm(exactHeightSize, B - 1, facts) % MOD)) % MOD;
    }
    return ans;
  }

  private long add(long x, long y) {
    return (x % MOD + y % MOD) % MOD;
  }

  private long mul(long x, long y) {
    return (x % MOD * y % MOD) % MOD;
  }

  private long choose(int n, int k, long[] facts) {
    return facts[n] / mul(facts[k], facts[n - k]);
  }

  public static BigInteger choose2(int x, int y) {
    BigInteger res = fact(x);
    res = res.divide(fact(x - y));
    res = res.divide(fact(y));
    res = res.remainder(BigInteger.valueOf(1000000007));
    return res;
  }

  public static BigInteger fact(int x) {
    BigInteger temp = BigInteger.ONE;
    for (int i = 1; i <= x; i++) {
      temp = temp.multiply(BigInteger.valueOf(i));
    }
    return temp;
  }

  public static void main(String[] st) {
    CountPermutationsOfBst q = new CountPermutationsOfBst();
    //System.out.println(q.cntPermBST(1, 1));
    //System.out.println(q.cntPermBST(2, 2));
    System.out.println(q.countPermBSTBDP(3, 1));
    System.out.println(q.countPermBSTBDP(3, 2));
  }
}
