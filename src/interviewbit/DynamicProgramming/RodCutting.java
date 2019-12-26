package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * There is a rod of length N lying on x-axis with its left end at x = 0 and right end at x = N. Now, there are M weak points on this rod denoted by positive integer values(all less than N) A1, A2, …, AM. You have to cut rod at all these weak points. You can perform these cuts in any order. After a cut, rod gets divided into two smaller sub-rods. Cost of making a cut is the length of the sub-rod in which you are making a cut.
 *
 * Your aim is to minimise this cost. Return an array denoting the sequence in which you will make cuts. If two different sequences of cuts give same cost, return the lexicographically smallest.
 *
 * Notes:
 *
 * Sequence a1, a2 ,…, an is lexicographically smaller than b1, b2 ,…, bm, if and only if at the first i where ai and bi differ, ai < bi, or if no such i found, then n < m.
 * N can be upto 109.
 * For example,
 *
 * N = 6
 * A = [1, 2, 5]
 *
 * If we make cuts in order [1, 2, 5], let us see what total cost would be.
 * For first cut, the length of rod is 6.
 * For second cut, the length of sub-rod in which we are making cut is 5(since we already have made a cut at 1).
 * For third cut, the length of sub-rod in which we are making cut is 4(since we already have made a cut at 2).
 * So, total cost is 6 + 5 + 4.
 *
 * Cut order          | Sum of cost
 * (lexicographically | of each cut
 *  sorted)           |
 * ___________________|_______________
 * [1, 2, 5]          | 6 + 5 + 4 = 15
 * [1, 5, 2]          | 6 + 5 + 4 = 15
 * [2, 1, 5]          | 6 + 2 + 4 = 12
 * [2, 5, 1]          | 6 + 4 + 2 = 12
 * [5, 1, 2]          | 6 + 5 + 4 = 15
 * [5, 2, 1]          | 6 + 5 + 2 = 13
 *
 *
 * So, we return [2, 1, 5].
 */
public class RodCutting {

    class dpData {

        long val;
        int cut;

        dpData() {
        }

        dpData(long val, int cut) {
            this.val = val;
            this.cut = cut;
        }
    }


    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        B.add(0, 0);
        B.add(A);
        dpData[][] dp = new dpData[B.size() + 1][B.size() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = +i; j < dp[i].length; j++) {
                dp[i][j] = new dpData();
            }
        }
        for (int len = 1; len <= B.size(); len++) {
            for (int start = 0; start < B.size() - len; start++) {
                int end = start + len;
                long bestVal = Integer.MAX_VALUE;
                for (int k = start + 1; k < end; k++) {
                    long val = dp[start][k].val + dp[k][end].val + B.get(end) - B.get(start);
                    if (val < bestVal) {
                        bestVal = val;
                        dp[start][end] = new dpData(bestVal, k);
                    }
                }
            }
        }
        fillAns(dp, ans, B, 0, B.size() - 1);

        return ans;
    }

    private void fillAns(dpData[][] dp, ArrayList<Integer> ans, ArrayList<Integer> B, int start, int end) {
        if (start + 1 < end) {
            int cutInd = dp[start][end].cut;
            ans.add(B.get(cutInd));
            fillAns(dp, ans, B, start, cutInd);
            fillAns(dp, ans, B, cutInd, end);
        }
    }

    public static void main(String[] st) {
        RodCutting q = new RodCutting();
        System.out.println(q.rodCut(6, new ArrayList<>(Arrays.asList(1, 2, 5))));
    }
}
