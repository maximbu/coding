package ProjectAuler;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by max on 1/27/2017.
 */
public class p50 {
    /*
The prime 41, can be written as the sum of six consecutive primes:
41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.
The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/


    public long questionNaive(int n) {
        List<Integer> primes = getPrimesTill(n);
        Set<Integer> set = new HashSet<>(primes);
        Integer[] arr = primes.toArray(new Integer[0]);
        int longest = 0;
        long longestSum = 0;
        int lastInd = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
            if (arr[i] > n) {
                lastInd = i;
                break;
            }
        }
        for (int i = 0; i < lastInd; i++) {
            for (int j = i + 1; j < lastInd; j++) {
                int num = arr[j] - arr[i];
                if (set.contains(num) && longest < j - i) {
                    longest = j - i;
                    longestSum = num;
                }
            }
        }
        return longestSum;
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
        p50 q = new p50();
        System.out.println(q.questionNaive(1000000));
    }
}
