package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.
 *
 * Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).
 *
 * Example :
 *
 * Input :
 * 	S = [1, 2, 3]
 * 	N = 4
 *
 * Return : 4
 *
 * Explanation : The 4 possible ways are
 * {1, 1, 1, 1}
 * {1, 1, 2}
 * {2, 2}
 * {1, 3}
 * Note that the answer can overflow. So, give us the answer % 1000007
 */
public class CoinSumInfinite {
    public int coinchange2(ArrayList<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>(A);
        int[] ans = new int[B + 1];
        ans[0] = 1;
        for (int x : set) {
            for (int i = x; i <= B; i++) {
                ans[i] = (ans[i] + ans[i - x]) % 1000007;
            }
        }
        return ans[B];
    }

    public static void main(String[] st) {
        CoinSumInfinite q = new CoinSumInfinite();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(q.coinchange2(a, 4));
    }
}
