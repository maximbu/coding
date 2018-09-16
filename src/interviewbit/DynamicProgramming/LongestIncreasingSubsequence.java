package interviewbit.DynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Find the longest increasing subsequence of a given sequence / array.
 *
 * In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible.
 * This subsequence is not necessarily contiguous, or unique.
 * In this case, we only care about the length of the longest increasing subsequence.
 *
 * Example :
 *
 * Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 * Output : 6
 * The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
public class LongestIncreasingSubsequence {

    public int lis(final List<Integer> A) {
        int[] ans = new int[A.size()];
        ans[0] = 1;
        for (int i = 1; i < A.size(); i++) {
            int max = ans[0];
            for (int j = 0; j < i; j++) {
                if (A.get(j) < A.get(i)) {
                    max = Math.max(max, ans[j] + 1);
                }
            }
            ans[i] = max;
        }
        return Arrays.stream(ans).max().getAsInt();
    }
}
