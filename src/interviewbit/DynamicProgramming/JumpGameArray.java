package interviewbit.DynamicProgramming;

import java.util.ArrayList;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return 1 ( true ).
 *
 * A = [3,2,1,0,4], return 0 ( false ).
 *
 * Return 0/1 for this problem
 */
public class JumpGameArray {
    public int canJump(ArrayList<Integer> A) {
        boolean[] arr = new boolean[A.size()];
        arr[0] = true;
        for (int i = 0; i < A.size(); i++) {
            int jump = A.get(i);
            if (arr[i]) {
                for (int j = i; j <= i + jump; j++) {
                    if (j < A.size()) {
                        arr[j] = true;
                    }
                }
            }
        }
        return arr[A.size() - 1] ? 1 : 0;
    }
}
