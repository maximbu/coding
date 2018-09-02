package interviewbit.bitManipulation;

import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example :
 *
 * Input : [1 2 2 3 1]
 * Output : 3
 */
public class SingleNumber {

    public int singleNumber(final List<Integer> A) {
        long x = 0;
        for (int a : A) {
            x ^= a;
        }
        return (int) x;
    }
}
