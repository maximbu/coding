package interviewbit.DynamicProgramming;

import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Return an integer corresponding to the maximum product possible.
 *
 * Example :
 *
 * Input : [2, 3, -2, 4]
 * Return : 6
 *
 * Possible with [2, 3]
 */
public class MaxProductSubarray {
    public int maxProduct(final List<Integer> A) {
        long[] max = new long[A.size()];
        long[] min = new long[A.size()];
        long totalMax = max[0] = min[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            int x = A.get(i);
            if (x > 0) {
                max[i] = x * max[i - 1];
                min[i] = x * min[i - 1];
            }
            if (x == 0) {
                max[i] = 1;
                min[i] = 1;
            }
            if (x < 0) {
                max[i] = Math.max(x * min[i - 1], 1);
                min[i] = x * max[i - 1];
            }
            totalMax = Math.max(totalMax, max[i]);
        }
        if (totalMax == 1) {
            return A.stream().max(Integer::compareTo).get();
        }
        return (int) totalMax;
    }
}
