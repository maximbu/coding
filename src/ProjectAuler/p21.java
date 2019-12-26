package ProjectAuler;

import java.util.HashMap;

/**
 * Created by max on 1/27/2017.
 */
public class p21 {
    /*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
Evaluate the sum of all the amicable numbers under 10000.
     */
    private static HashMap<Integer, Integer> nums = new HashMap<>();


    public static int questionNaive(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int divSum = divisorsSum(i);
            if (nums.getOrDefault(divSum, -1) == i) {
                sum += i + divSum;
            }
            nums.put(i, divSum);
        }
        return sum;
    }

    private static int divisorsSum(int n) {
        int sum = 1;
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0) sum += j + n / j;
        }
        return sum;
    }


    public static void main(String[] st) {
        p21 q = new p21();
        System.out.println(divisorsSum(220));
        System.out.println(divisorsSum(284));
        System.out.println(questionNaive(10000));
    }
}
