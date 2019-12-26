package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p34 {
    /*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
Find the sum of all numbers which are equal to the sum of the factorial of their digits.
Note: as 1! = 1 and 2! = 2 are not sums they are not included.
*/

    private long[] factorials = new long[10];

    public long questionNaive() {
        generateFactorials();
        long sum = 0;
        for (int i = 11; i < factorials[9] * 7; i++) {
            int x = i;
            long tmpSum = 0;
            while (x > 0) {
                tmpSum += factorials[x % 10];
                x /= 10;
            }
            if (tmpSum == i) {
                sum += i;
            }
        }
        return sum;
    }

    private void generateFactorials() {
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorials[i] = i * factorials[i - 1];
        }
    }


    public static void main(String[] st) {
        p34 q = new p34();
        System.out.println(q.questionNaive());
    }
}
