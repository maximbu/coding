package interviewbit.bitManipulation;

import java.util.List;

/**
 * Given an array of integers, every element appears thrice except for one which occurs once.
 *
 * Find that element which does not appear thrice.
 *
 * Note: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 * Example :
 *
 * Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 * Output : 4
 */
public class SingleNumberII {

    public int singleNumber(final List<Integer> A) {
        int oneOcc = 0;
        int twoOcc = 0;
        int threeOcc;
        for(int x:A){
            twoOcc |= x&oneOcc;
            oneOcc ^= x;
            threeOcc = oneOcc & twoOcc;
            oneOcc &= ~threeOcc;
            twoOcc &= ~threeOcc;
        }
        return oneOcc;
    }
}
