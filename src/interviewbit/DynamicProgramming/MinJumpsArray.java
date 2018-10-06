package interviewbit.DynamicProgramming;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example :
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * If it is not possible to reach the end index, return -1.
 */
public class MinJumpsArray {

    public int jump(int[] A) {
        int[] jumps = new int[A.length];
        if (A.length == 1)
            return 0;
        jumps[0] = 1;
        int lastInd = 0;
        for (int i = 0; i < A.length; i++) {
            if (jumps[i] > 0 && lastInd < i + A[i] + 1) {
                lastInd = i + A[i] + 1;
                if (lastInd >= A.length) {
                    return jumps[i];
                }
                for (int k = i; k < lastInd; k++) {
                    if (jumps[k] == 0) {
                        jumps[k] = jumps[i] + 1;
                    } else {
                        jumps[k] = Math.min(jumps[i] + 1, jumps[k]);
                    }
                }
            }
        }
        return -1;
    }
}
