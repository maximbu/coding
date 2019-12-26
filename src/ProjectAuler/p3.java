package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p3 {
    /*
   The prime factors of 13195 are 5, 7, 13 and 29.
    What is the largest prime factor of the number 600851475143 ?
     */
    public static long questionNaive(long n) {
        long s = (long) Math.sqrt(n);
        while (s > 0) {
            if (n % s == 0 && isPrime(s)) return s;
            s--;
        }
        return 1;
    }

    private static boolean isPrime(long n) {
        if (n % 2 == 0) return n == 2;
        for (long i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] st) {
        p3 q = new p3();
        System.out.println(questionNaive(600851475143L));
    }
}
