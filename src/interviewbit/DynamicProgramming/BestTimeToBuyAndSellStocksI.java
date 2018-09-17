package interviewbit.DynamicProgramming;

import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Example :
 *
 * Input : [1 2]
 * Return :  1
 */
public class BestTimeToBuyAndSellStocksI {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A.size() < 2)
            return 0;
        int max = 0;
        int currMin = A.get(0);
        for (Integer price : A) {
            if (price < currMin) {
                currMin = price;
            } else {
                max = Math.max(price - currMin, max);
            }
        }
        return max;
    }
}
