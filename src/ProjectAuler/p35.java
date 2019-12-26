package ProjectAuler;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by max on 1/27/2017.
 */
public class p35 {
    /*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
How many circular primes are there below one million?
*/


    public int questionNaive(int n) {
        int cnt = 0;
        Set<Integer> primes = getPrimesTill(n);
        for (int prime : primes) {
            if (isAllRotationsPrime(prime, primes)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isAllRotationsPrime(int prime, Set<Integer> primes) {
        if (prime < 10) return true;
        int rotated = getNextRotation(prime);
        while (prime != rotated) {
            if (!primes.contains(rotated)) return false;
            rotated = getNextRotation(rotated);
        }
        return true;
    }

    private int getNextRotation(int rotated) {
        int lastD = rotated % 10;
        rotated /= 10;
        int d = 1;
        while (d <= rotated) {
            d *= 10;
            lastD *= 10;
        }
        return rotated + lastD;
    }

    private HashSet<Integer> getPrimesTill(int n) {
        boolean[] nonPrimes = new boolean[n + 1];
        HashSet<Integer> list = new HashSet<>();
        list.add(2);
        for (int i = 3; i < n + 1; i += 2) {
            if (!nonPrimes[i]) {
                list.add(i);
                for (int j = 2 * i; j < n + 1; j += i) {
                    nonPrimes[j] = true;
                }
            }
        }
        return list;
    }


    public static void main(String[] st) {
        p35 q = new p35();
        System.out.println(q.questionNaive(1000000));
    }
}
