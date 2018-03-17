package ProjectAuler;

import java.math.BigInteger;
import java.util.Calendar;

/**
 * Created by max on 1/27/2017.
 */
public class p20 {
    /*
n! means n × (n − 1) × ... × 3 × 2 × 1
For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
Find the sum of the digits in the number 100!
     */



    public static int questionNaive(int n) {
        BigInteger b = new BigInteger("1");
        for (int i = 2; i < n+1; i++) {
            b= b.multiply(new BigInteger(String.valueOf(i)));
        }
        int sum = 0;
        BigInteger ten =new BigInteger("10");
        while (!b.equals(new BigInteger("0"))){
            sum+=b.mod(ten).intValue();
            b = b.divide(ten);
        }
        return sum;
    }



    public static void main(String[] st) {
        p20 q = new p20();
        int num = 100;
        System.out.println(questionNaive(num));
    }
}
