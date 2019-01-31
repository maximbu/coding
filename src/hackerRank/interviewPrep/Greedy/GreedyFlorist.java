package hackerRank.interviewPrep.Greedy;

import java.util.Arrays;

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int cost = 0;
        int mul = 1;
        int i = c.length - 1;
        while (i >= 0) {
            int t = k;
            while (t > 0 && i >= 0) {
                cost += mul * c[i--];
                t--;
            }
            mul++;
        }
        return cost;
    }
}
