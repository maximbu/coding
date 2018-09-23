package interviewbit.strings;

import java.math.BigInteger;

/**
 * Find if Given number is power of 2 or not.
 * More specifically, find if given number can be expressed as 2^k where k >= 1.
 *
 * Input:
 *
 * number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
 * Output:
 *
 * return 1 if the number is a power of 2 else return 0
 *
 * Example:
 *
 * Input : 128
 * Output : 1
 */
public class PowerOfTwo {
    public int power(String A) {
        BigInteger b = new BigInteger(A);
        if(b.bitLength() == 1) return 0;
        for (int i = 0; i < b.bitLength()-1; i++) {
            if(b.testBit(i)){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] st) {
        PowerOfTwo q = new PowerOfTwo();
        System.out.println(q.power("0"));
        System.out.println(q.power("1"));
        System.out.println(q.power("2"));
        System.out.println(q.power("128"));
    }
}
