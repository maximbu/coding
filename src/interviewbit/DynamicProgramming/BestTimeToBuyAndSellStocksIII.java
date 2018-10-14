package interviewbit.DynamicProgramming;

import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example :
 *
 * Input : [1 2 1 2]
 * Output : 2
 *
 * Explanation :
 *   Day 1 : Buy
 *   Day 2 : Sell
 *   Day 3 : Buy
 *   Day 4 : Sell
 */
public class BestTimeToBuyAndSellStocksIII {

  public int maxProfit(final List<Integer> A) {
    if (A == null || A.size() < 2) {
      return 0;
    }

    int[] left = new int[A.size()];
    left[0] = 0;
    int min = A.get(0);
    for (int i = 1; i < A.size(); i++) {
      min = Math.min(min, A.get(i));
      left[i] = Math.max(left[i - 1], A.get(i) - min);
    }

    int[] right = new int[A.size()];
    right[A.size() - 1] = 0;
    int max = A.get(A.size() - 1);
    for (int i = A.size() - 2; i >= 0; i--) {
      max = Math.max(max, A.get(i));
      right[i] = Math.max(right[i + 1], max - A.get(i));
    }

    int profit = 0;
    for (int i = 0; i < A.size(); i++) {
      profit = Math.max(profit, left[i] + right[i]);
    }

    return profit;
  }
}
