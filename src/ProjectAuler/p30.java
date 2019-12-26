package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p30 {
    /*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/


    public long questionNaive(int n) {
        long sum = 0;
        long max = getMaxNum(n);
        for (long i = 10; i <= max; i++) {
            long powSum = digitsPowSum(i, n);
            if (i == powSum) {
                sum += i;
            }
        }
        return sum;
    }

    private long getMaxNum(int n) {
        long num = 10;
        int digits = 1;
        while (true) {
            long maxNum = (long) Math.pow(9, n) * digits;
            if (maxNum < num) return maxNum;
            digits++;
            num *= 10;
        }
    }

    private long digitsPowSum(long i, int n) {
        long ans = 0;
        while (i > 0) {
            int digit = (int) i % 10;
            i /= 10;
            ans += Math.pow(digit, n);
        }
        return ans;
    }


    public static void main(String[] st) {
        p30 q = new p30();
        System.out.println(q.questionNaive(5));
    }
}
