package interviewbit.Ninja;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * For a A * B matrix of all distinct numbers from 1 to A * B, we first sort each column and then concatenate all columns in increasing order of indices to form an array of size A * B. Columns are numbered in increasing order from left to right.
 *
 * For example, if matrix is
 *
 * [1 5 6]
 * [3 2 4]
 *
 * We first sort all columns to get
 *
 * [1 2 4]
 * [3 5 6]
 *
 * Now, we concatenate columns in increasing order of indices to get an array
 *
 * [1, 3, 2, 5, 4, 6]
 * Given this final array, you have to count how many distinct initial matrices are possible. Return the required answer modulo 109+7.
 *
 * Two matrices are distinct if:
 *
 * Either their dimensions are different.
 * Or if any of the corresponding row in two matrices are different.
 * Example:
 *
 * If input array is [1, 3, 2, 4], distinct initial matrices possible are:
 *
 * [1 3 2 4]
 * -----------------------
 * [1 2]
 * [3 4]
 * -----------------------
 * [1 4]
 * [3 2]
 * -----------------------
 * [3 2]
 * [1 4]
 * -----------------------
 * [3 4]
 * [1 2]
 * -----------------------
 *
 * that is, a total of 5 matrices.
 */
public class DistinctInitialMatrices {

  // 6 - 765
  public int cntMatrix(ArrayList<Integer> A) {
    int n = A.size();
    long ans = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0 && isValidCut(A, i)) {
        ans = (ans + pow(fact(i), n / i)) % 1000000007;
      }
    }
    return (int) ans;
  }

  private boolean isValidCut(ArrayList<Integer> A, int cutSize) {
    for (int start = 0; start < A.size(); start += cutSize) {
      for (int j = start + 1; j < start + cutSize; j++) {
        if (A.get(j - 1) > A.get(j)) {
          return false;
        }
      }
    }
    return true;
  }

  private long pow(long x, int y) {
    long ans = 1;
    while (y > 0) {
      ans = (ans * x) % 1000000007;
      y--;
    }
    return ans;
  }

  private long fact(int x) {
    long ans = 1;
    while (x > 0) {
      ans = (ans * x) % 1000000007;
      x--;
    }
    return ans;
  }

  public static void main(String[] st) {
    DistinctInitialMatrices q = new DistinctInitialMatrices();
    System.out.println(q.cntMatrix(new ArrayList<>(Arrays.asList(1, 3, 2, 4))));
    System.out.println(q.cntMatrix(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    System.out.println(q.cntMatrix(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 46, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 25, 47, 48, 49, 50))));
    //784534666
  }
}
