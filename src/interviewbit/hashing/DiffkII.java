package interviewbit.hashing;

import java.util.HashSet;
import java.util.List;

/**
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 * Example :
 *
 * Input :
 *
 * A : [1 5 3]
 * k : 2
 * Output :
 *
 * 1
 * as 3 - 1 = 2
 *
 * Return 0 / 1 for this problem.
 */
public class DiffkII {
    public int diffPossible(final List<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a + B) || set.contains(a - B)) {
                return 1;
            }
            set.add(a);
        }
        return 0;
    }

}
