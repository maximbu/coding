package interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 *
 * Assume that there will only be one solution
 *
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class ThreeSum {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        if (A.size() < 3)
            return 0;
        A.sort(Integer::compareTo);
        long bestSum = A.get(0) + A.get(1) + A.get(2);
        for (int i = 0; i < A.size(); i++) {
            int from = i + 1;
            int to = A.size() - 1;
            while (to > from) {
                long sum = (long) A.get(i) + A.get(from) + A.get(to);
                if (Math.abs(sum - B) < Math.abs(bestSum - B)) {
                    bestSum = sum;
                }
                if (sum == B)
                    return B;
                if (sum > B) {
                    to--;
                }
                if (sum < B) {
                    from++;
                }
            }
        }
        return (int) bestSum;
    }

    public static void main(String[] st) {
        ThreeSum q = new ThreeSum();
        System.out.println(q.threeSumClosest(new ArrayList<>(Arrays.asList(5, -2, -1, -10, 10)), 5));
    }
}
