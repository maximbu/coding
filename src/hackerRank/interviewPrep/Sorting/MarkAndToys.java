package hackerRank.interviewPrep.Sorting;

import java.util.Arrays;

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > k) {
                return i;
            }
            k -= prices[i];
        }
        return prices.length;
    }
}
