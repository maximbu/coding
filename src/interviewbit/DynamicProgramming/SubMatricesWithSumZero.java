package interviewbit.DynamicProgramming;

import java.util.ArrayList;

/**
 * Given a 2D matrix, find the number non-empty sub matrices, such that the sum of the elements inside the sub matrix is equal to 0. (note: elements might be negative).
 *
 * Example:
 *
 * Input
 *
 * -8 5  7
 * 3  7 -8
 * 5 -8  9
 * Output
 * 2
 *
 * Explanation
 * -8 5 7
 * 3 7 -8
 * 5 -8 9
 *
 * -8 5 7
 * 3 7 -8
 * 5 -8 9
 */
public class SubMatricesWithSumZero {

  public int solve(ArrayList<ArrayList<Integer>> A) {
    if (A.isEmpty() || A.get(0).isEmpty())
      return 0;
    int m = A.size();
    int n = A.get(0).size();
    int ans = 0;
    for (int i = 0; i < m; i++) {
      int[] dp = new int[n];
      for (int j = i; j < m; j++) {
        for (int k = 0; k < n; k++) {
          dp[k] += A.get(j).get(k);
        }
        ans += sumZero(dp);
      }
    }
    return ans;
  }

  private int sumZero(int[] a) {
    int ans = 0;
    for (int i = 0; i < a.length; i++) {
      int sum = 0;
      for (int j = i; j < a.length; j++) {
        sum += a[j];
        if (sum == 0) {
          ans++;
        }
      }
    }
    return ans;
  }

  public static void main(String[] st) {
    SubMatricesWithSumZero q = new SubMatricesWithSumZero();
    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    ArrayList<Integer> a0 = new ArrayList<>();
    ArrayList<Integer> a1 = new ArrayList<>();
    a0.add(0);
    a0.add(0);
    a.add(a0);
    a1.add(0);
    a1.add(0);
    a.add(a1);
    System.out.println(q.solve(a));
  }
}
