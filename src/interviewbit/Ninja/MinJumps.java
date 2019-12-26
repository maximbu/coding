package interviewbit.Ninja;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer B which denotes that from any index i, you can jump to any of the indices i+1, i+2, …, i+B. Also, if you step on index i, you have to pay Ai coins. If Ai is -1, it means you can’t land on index i.
 *
 * You start from index 1, and your aim is to reach index N. Return the path you should take to minimise the number of coins required. If there are multiple paths with same cost, return the lexicographically smallest such path. If its not possible to reach index N return empty array.
 *
 * Notes
 *
 * Ai is either > 0(denoting cost) or -1(denoting that it is not possible to land on index i).
 * You have to pay coins both at starting and ending indices.
 * Path a1, a2 ,…, an is lexicographically smaller than b1, b2 ,…, bm, if and only if at the first i where ai and bi differ, ai < bi, or if no such i exists, then n < m.
 * For example,
 *
 * A=[1, 2, 4, -1, 2] and B = 2
 *
 * The path which requires minimum coins is to start at index 1 and then move to index 3 and then to 5.
 * So return [1, 3, 5].
 *
 * Another example,
 *
 * A=[1, 2, 4, -1, 2] and B = 1
 *
 * In this case it is not possible to reach index 5. So return empty array [].
 */
public class MinJumps {

  static class DPData {

    int fromInd;
    int cost;

    DPData(int fromInd, int cost) {
      this.cost = cost;
      this.fromInd = fromInd;
    }

    @Override
    public String toString() {
      return "DPData{" +
              "fromInd=" + fromInd +
              ", cost=" + cost +
              '}';
    }
  }

  public ArrayList<Integer> minJumps(ArrayList<Integer> A, int B) {
    ArrayList<Integer> ans = new ArrayList<>();
    if (A == null || A.size() == 0 || B == 0 || A.get(0) == -1 || A.get(A.size() - 1) == -1)
      return ans;
    DPData[] dp = new DPData[A.size()];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = new DPData(-1, Integer.MAX_VALUE);
    }
    dp[0] = new DPData(-1, A.get(0));
    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) != -1 && dp[i].cost != Integer.MAX_VALUE) {
        for (int k = i + 1; k < Math.min(i + B + 1, A.size()); k++) {
          if (A.get(k) != -1) {
            if (dp[k].cost > dp[i].cost + A.get(k)) {
              dp[k].cost = dp[i].cost + A.get(k);
              dp[k].fromInd = i;
            }
          }
        }
      }
    }
    DPData last = dp[A.size() - 1];
    if (last.cost == Integer.MAX_VALUE)
      return ans;
    ans.add(0, A.size());
    while (last.fromInd != -1) {
      ans.add(0, last.fromInd + 1);
      last = dp[last.fromInd];
    }
    return ans;
  }

  public static void main(String[] st) {
    MinJumps q = new MinJumps();
    // System.out.println(q.minJumps(new ArrayList<>(Arrays.asList(1, 2, 4, -1, 2)),2));
    System.out.println(q.minJumps(new ArrayList<>(Arrays.asList(933, 815, -1, -1, -1, -1, -1, -1, -1, 469, 902, 228, 728, 764, 999, 818)), 6));
  }
}
