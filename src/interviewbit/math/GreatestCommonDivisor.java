package interviewbit.math;

/**
 * Created by max on 7/19/2017.
 * Given 2 non negative integers m and n, find gcd(m, n)

 GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
 Both m and n fit in a 32 bit signed integer.
 NOTE : DO NOT USE LIBRARY FUNCTIONS
 */
public class GreatestCommonDivisor {
    public static void main(String[] st) {
        GreatestCommonDivisor q = new GreatestCommonDivisor();

        int N = 6;
        int M = 9;
        System.out.println(q.gcd(N, M));

        N = 2;
        M = 3;
        System.out.println(q.gcd(N, M));
    }

    public int gcd(int a, int b) {
        int bigger = a;
        int smaller = b;
        if (a < b) {
            bigger = b;
            smaller = a;
        }
        while (smaller > 0) {
            int tmp = bigger % smaller;
            bigger = smaller;
            smaller = tmp;
        }
        return bigger;
    }
}
