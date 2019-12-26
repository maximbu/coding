package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p1 {
    /*
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
     */
    public static int questionNaive(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return sum;
    }

    public static int question(int n) {
        return sumOfNubsDivisibleBy(3, n) + sumOfNubsDivisibleBy(5, n) - sumOfNubsDivisibleBy(15, n);
    }

    private static int sumOfNubsDivisibleBy(int i, int n) {
        int numbers = n / i;
        int last = numbers * i;
        return (i + last) * numbers / 2;
    }

    public static void main(String[] st) {
        p1 q = new p1();
        System.out.println(questionNaive(999));
        System.out.println(question(999));
    }
}
