package interviewbit.twoPointers;

import java.util.ArrayList;

/**
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 *
 * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
 * i.e. minimize | max(a,b,c) - min(a,b,c) |.
 *
 * Example :
 *
 * Input:
 *
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 * Output:
 *
 * 1
 * Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 */
public class MinimizeTheAbsoluteDifference {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int a = 0;
        int b = 0;
        int c = 0;
        int minD = Integer.MAX_VALUE;
        while (a < A.size() && b < B.size() && c < C.size()) {
            int maxVal = Math.max(Math.max(A.get(a), B.get(b)), C.get(c));
            int minVal = Math.min(Math.min(A.get(a), B.get(b)), C.get(c));
            int d = Math.abs(maxVal - minVal);
            minD = Math.min(d, minD);
            if (minVal == A.get(a)) {
                a++;
            } else if (minVal == B.get(b)) {
                b++;
            } else if (minVal == C.get(c)) {
                c++;
            }
        }
        return minD;
    }
}
