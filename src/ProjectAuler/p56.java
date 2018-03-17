package ProjectAuler;


import java.math.BigInteger;

/**
 * Created by max on 1/27/2017.
 */
public class p56 {
    /*
A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
*/


    public int questionNaive() {
        int biggestSum = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                int digSum = digitSum(a,b);
                if(digSum > biggestSum){
                    biggestSum = digSum;
                }
            }
        }
        return biggestSum;
    }

    private int digitSum(int a, int b) {
        BigInteger n = new BigInteger(String.valueOf(a)).pow(b);
        char[] digits = n.toString().toCharArray();
        int sum = 0;
        for (char digit : digits) {
            sum += digit - '0';
        }
        return sum;
    }


    public static void main(String[] st) {
        p56 q = new p56();
        System.out.println(q.questionNaive());
}
}
