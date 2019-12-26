package ProjectAuler;

import java.math.BigInteger;

/**
 * Created by max on 1/27/2017.
 */
public class p16 {
    /*
 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
     */


    public static long questionNaive(int pow) {
        char[] digits = new BigInteger("2").pow(pow).toString().toCharArray();
        int sum = 0;
        for (char digit : digits) {
            sum += digit - '0';
        }
        return sum;
    }


    public static void main(String[] st) {
        p16 q = new p16();

        System.out.println(questionNaive(1000));
    }
}
