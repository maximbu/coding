package interviewbit.Ninja;

import java.util.ArrayList;

/**
 * You are given an array of N positive integers, A1, A2 ,…, AN.
 *
 * Let’s denote by A[i, j] the subarray Ai, Ai+1 ,…, Aj.
 *
 * Count pairs (i, j) such that 1 ≤ i ≤ j ≤ N and subarray A[i, j] is increasing. Return the value modulo 109 + 7.
 *
 * Notes
 *
 * A subarray A1, A2 ,…, AN is increasing if Ai < Ai+1, for all 1 ≤ i < N.
 * For example,
 *
 * A=[4, 5, 1, 2]
 *
 * All subarrays of size 1 are increasing.
 *
 * Subarrays A[1, 2], A[3, 4] of size 2 are increasing.
 *
 * No subarray of size 3 and 4 is increasing.
 *
 * So, total of 6 subarrays are increasing.
 */
public class IncreasingSubArrays {

  public int cntInc(ArrayList<Integer> A) {
    int sum = 0;
    for (int i = 0; i < A.size(); i++) {
      sum = (sum + 1) % 1000000007;
      for (int j = i + 1; j < A.size() && A.get(j - 1) < A.get(j); j++) {
        sum = (sum + 1) % 1000000007;
      }
    }
    return sum;
  }
}
