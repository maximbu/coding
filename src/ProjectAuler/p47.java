package ProjectAuler;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 1/27/2017.
 */
public class p47 {
    /*
The first two consecutive numbers to have two distinct prime factors are:
14 = 2 × 7
15 = 3 × 5
The first three consecutive numbers to have three distinct prime factors are:
644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.
Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
*/


    public int questionNaive(int n) {
        List<Integer> primes = getPrimesTill(10000);
        int start = 1;
        for (int i = 0; i < n; i++) {
            start *= primes.get(i);
        }
        int con = 0;
        while (con < n) {
            if (getPrimesFactorCount(start, primes) >= n) {
                con++;
            } else {
                con = 0;
            }
            start++;
        }
        return start - n;
    }

    private int getPrimesFactorCount(int start, List<Integer> primes) {
        int primeFactorCount = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (start % primes.get(i) == 0) {
                primeFactorCount++;
                while (start % primes.get(i) == 0) {
                    start /= primes.get(i);
                    if (start == 1) return primeFactorCount;
                }
            }
        }
        return 0;
    }

    private List<Integer> getPrimesTill(int n) {
        boolean[] nonPrimes = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();
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
        p47 q = new p47();
        System.out.println(q.questionNaive(4));
    }
}
