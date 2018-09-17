package interviewbit.DynamicProgramming;

import java.util.ArrayList;

/**
 * Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
 * is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
 *
 * Example:
 *
 * Grid:
 * 	1 2 3 4
 * 	2 3 4 5
 * so we will choose
 * 3 and 5 so sum will be 3 + 5 = 8
 *
 *
 * Note that you can choose more than 2 numbers
 */
public class MaxSumWithoutAdjacentElements {

    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int best = 0;

        for (int i = 0, withPrev = 0, withoutPrev = 0; i < A.get(0).size(); i++) {
            int tmp = withPrev;
            withPrev = withoutPrev + Math.max(A.get(0).get(i), A.get(1).get(i));
            withoutPrev = Math.max(withoutPrev, tmp);
            best = Math.max(withoutPrev, withPrev);
        }

        return best;
    }
}
