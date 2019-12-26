package ProjectAuler;


import java.util.HashSet;

/**
 * Created by max on 1/27/2017.
 */
public class p37 {
    /*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
Similarly we can work from right to left: 3797, 379, 37, and 3.
Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/


    public int questionNaive(int n) {
        int cnt = 0;
        HashSet<Integer> primes = getPrimesTill(1000000);
        int count = 0;
        for (int p : primes) {
            if (isTruncatable(p, primes)) {
                cnt += p;
                count++;
            }
            if (count == 11) break;
        }
        return cnt;
    }

    private boolean isTruncatable(int p, HashSet<Integer> primes) {
        int orig = p;
        if (p < 10) return false;
        while (p > 0) {
            if (!primes.contains(p)) return false;
            p /= 10;
        }
        int m = 10;
        while (m < orig) {
            p = orig % m;
            if (!primes.contains(p)) return false;
            m *= 10;
        }
        return true;
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
        p37 q = new p37();
        System.out.println(q.isTruncatable(3797, q.getPrimesTill(3798)));
        System.out.println(q.questionNaive(1000000));
    }
}
