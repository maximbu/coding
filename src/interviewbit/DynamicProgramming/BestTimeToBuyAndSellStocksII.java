package interviewbit.DynamicProgramming;

import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example :
 *
 * Input : [1 2 3]
 * Return : 2
 */
public class BestTimeToBuyAndSellStocksII {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A.size() < 2)
            return 0;
        int sum = 0;
        int currMin = A.get(0);
        for (Integer price : A) {
            if (price > currMin) {
                sum += price - currMin;
            }
            currMin = price;
        }
        return sum;
    }
}
