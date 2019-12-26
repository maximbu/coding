package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p7 {
    /*
    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    What is the 10 001st prime number?
     */
    public static long questionNaive(int n) {
        long curr = 2;
        long lastPrime = 2;
        int primes = 0;
        while (primes < n) {
            if (isPrime(curr)) {
                primes++;
                lastPrime = curr;
            }
            curr++;
        }
        return lastPrime;
    }

    private static boolean isPrime(long n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        for (long i = 5; i <= (long) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] st) {
        p7 q = new p7();
        System.out.println(questionNaive(10001));
    }
}
