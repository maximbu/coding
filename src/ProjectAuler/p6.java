package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p6 {
    /*
   The sum of the squares of the first ten natural numbers is,
    1^2 + 2^2 + ... + 10^2 = 385
    The square of the sum of the first ten natural numbers is,
    (1 + 2 + ... + 10)^2 = 55^2 = 3025
    Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
    Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
     */
    public static long questionNaive(int max) {
        long ans = 0;
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            int n = i * i;
            sum += i;
            ans -= n;
        }
        return sum * sum + ans;
    }


    public static long question(int max) {
        long sum = (1 + max) * max / 2;
        long sumSq = (2 * max + 1) * (max + 1) * max / 6;
        return sum * sum - sumSq;
    }

    public static void main(String[] st) {
        p6 q = new p6();
        System.out.println(questionNaive(100));
        System.out.println(question(100));
    }
}
