package ProjectAuler;


import java.math.BigInteger;

/**
 * Created by max on 1/27/2017.
 */
public class p48 {
    /*
The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
*/


    public String questionNaive(int n) {
        BigInteger sum = new BigInteger("0");
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            sum = sum.add(new BigInteger(s).pow(i));
        }
        return sum.toString().substring(sum.toString().length() - 10);
    }


    public static void main(String[] st) {
        p48 q = new p48();
        System.out.println(q.questionNaive(1000));
    }
}
