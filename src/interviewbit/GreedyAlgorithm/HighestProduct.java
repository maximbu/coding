package interviewbit.GreedyAlgorithm;

import java.util.ArrayList;

/**
 * Given an array of integers, return the highest product possible by multiplying 3 numbers from the array
 *
 * Input:
 *
 * array of integers e.g {1, 2, 3}
 *  NOTE: Solution will fit in a 32-bit signed integer
 * Example:
 *
 * [0, -1, 3, 100, 70, 50]
 *
 * => 70*50*100 = 350000
 */
public class HighestProduct {
    public int maxp3(ArrayList<Integer> A) {
        A.sort(Integer::compareTo);
        return Math.max(A.get(A.size() - 1) * A.get(A.size() - 2) * A.get(A.size() - 3), A.get(A.size() - 1) * A.get(0) * A.get(1));
    }
}
