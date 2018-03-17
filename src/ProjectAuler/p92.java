package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p92 {
    /*
A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.
For example,
44 → 32 → 13 → 10 → 1 → 1
85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
How many starting numbers below ten million will arrive at 89?
*/


    public int questionNaive(int n) {
        int sum = 0;
        for (long i = 1; i < n; i++) {
            if (isEightyNineSeq(i)) sum++;
        }
        return sum;
    }

    private boolean isEightyNineSeq(long i) {
        while (true) {
            if (i == 1) return false;
            if (i == 89) return true;
            long digSquareSum = 0;
            while (i > 0) {
                long dig = i % 10;
                digSquareSum += dig * dig;
                i /= 10;
            }
            i = digSquareSum;
        }
    }


    public static void main(String[] st) {
        p92 q = new p92();
        long startTime = System.currentTimeMillis();
        int ans = q.questionNaive(10000000);
        long stopTime = System.currentTimeMillis();
        System.out.println(ans);
        long elapsedTime = stopTime - startTime;
        System.out.println("Solution took:" + elapsedTime + " milisec");
    }
}
