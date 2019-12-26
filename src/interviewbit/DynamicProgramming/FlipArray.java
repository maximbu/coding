package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible). Return the minimum no. of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.
 *
 * Constraints:
 *
 *  1 <= n <= 100
 * Sum of all the elements will not exceed 10,000.
 *
 * Example:
 *
 * A = [15, 10, 6]
 * ans = 1 (Here, we will flip the sign of 15 and the resultant sum will be 1 )
 *
 * A = [14, 10, 4]
 * ans = 1 (Here, we will flip the sign of 14 and the resultant sum will be 0)
 *
 *  Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there are not minimum
 */
public class FlipArray {
    static class dpHelper {
        int val;
        int cnt;

        public dpHelper() {

        }

        public dpHelper(int v, int c) {
            val = v;
            cnt = c;
        }
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        int sum = A.stream().mapToInt(Integer::intValue).sum();
        dpHelper[][] dp = new dpHelper[sum / 2 + 1][A.size()];
        for (dpHelper[] row : dp) {
            Arrays.fill(row, new dpHelper());
        }
        List<Integer> B = new ArrayList<>(A);
        B.sort(Integer::compareTo);
        Collections.reverse(B);
        for (int j = 0; j < A.size(); j++) {
            for (int i = 1; i < sum / 2 + 1; i++) {
                if (j == 0) {
                    if (i >= B.get(j)) {
                        dp[i][j] = new dpHelper(B.get(j), 1);
                    }
                    continue;
                }
                dp[i][j] = dp[i][j - 1];
                if (i - B.get(j) >= 0) {
                    int valWithNewElem = dp[i - B.get(j)][j - 1].val + B.get(j);
                    int cntWithNewElem = dp[i - B.get(j)][j - 1].cnt + 1;
                    if (valWithNewElem > dp[i][j].val) {
                        dp[i][j] = new dpHelper(valWithNewElem, cntWithNewElem);
                    }
                    if (valWithNewElem == dp[i][j].val) {
                        dp[i][j].cnt = Math.min(dp[i][j].cnt, cntWithNewElem);
                    }
                }
            }
        }
        return dp[sum / 2][A.size() - 1].cnt;
    }

    public static void main(String[] st) {
        FlipArray q = new FlipArray();
        System.out.println(q.solve(Arrays.asList(11, 37, 7, 23, 13, 4, 32, 47, 5, 21, 25, 19, 41, 41, 35, 18, 28, 6, 7, 5, 7)));
        System.out.println(q.solve(Arrays.asList(15, 10, 6)));
        System.out.println(q.solve(Arrays.asList(14, 10, 4)));
        System.out.println(q.solve(Arrays.asList(11, 10, 8, 6, 8, 11, 1, 10, 2, 3, 8, 3, 8, 12, 11, 1, 7, 5, 5, 12, 9, 4, 10, 3, 3, 3, 8, 8, 8, 6, 7, 7, 7, 6, 4, 2, 5, 8, 11, 10, 10, 10, 12, 9, 2, 3, 9, 12, 7, 6, 11, 8, 9, 9, 10, 3, 3, 5, 2, 10, 10, 9, 4, 9, 6, 11, 10, 2, 6, 1, 4, 7, 10, 3, 4, 3, 9, 4, 3, 8, 1, 1, 3)));
        System.out.println(q.solve(Arrays.asList(8, 4, 5, 7, 6, 2)));
    }
}
