package interviewbit.bitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 *
 * Example:
 *
 * The 32-bit integer 11 has binary representation
 *
 * 00000000000000000000000000001011
 * so the function should return 3.
 *
 * Note that since Java does not have unsigned int, use long for Java
 */
public class NumberOf2Bits {

    public int numSetBits(long a) {
        int cnt = 0;
        while (a > 0) {
            a = a & a - 1;
            cnt++;
        }
        return cnt;
    }
}
