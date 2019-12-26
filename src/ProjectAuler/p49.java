package ProjectAuler;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by max on 1/27/2017.
 */
public class p49 {
    /*
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
What 12-digit number do you form by concatenating the three terms in this sequence?
*/


    public String questionNaive(int n) {
        List<Integer> primes = getPrimes(1488, 10000);
        int i = 0;
        while (true) {
            int prime = primes.get(i++);
            List<Integer> perm = getPermutations(prime);
            for (Integer per : perm) {
                if (per > prime && primes.contains(per)) {
                    int next = prime + 2 * (per - prime);
                    if (primes.contains(next) && perm.contains(next)) {
                        return String.format("%1$d%2$d%3$d", prime, per, next);
                    }
                }
            }
        }
    }

    private List<Integer> getPermutations(int n) {
        String st = String.valueOf(n);
        return getPermutations(st, st.length() - 1).stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    private List<String> getPermutations(String n, int ind) {
        if (ind == 0) {
            List<String> l = new ArrayList<>();
            l.add(n.substring(0, 1));
            return l;
        }
        List<String> withoutI = getPermutations(n, ind - 1);
        List<String> l = new ArrayList<>();
        for (String st : withoutI) {
            for (int j = 0; j <= ind; j++) {
                l.add(st.substring(0, j) + n.charAt(ind) + st.substring(j, ind));
            }
        }
        return l;
    }

    private boolean arePermutation(int a, int b) {
        char[] a1 = String.valueOf(a).toCharArray();
        char[] b1 = String.valueOf(b).toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);
        return Arrays.equals(a1, b1);
    }

    private List<Integer> getPrimes(int from, int till) {
        boolean[] nonPrimes = new boolean[till + 1];
        List<Integer> list = new ArrayList<>();
        if (from <= 2) {
            list.add(2);
        }
        Scanner a = new Scanner(System.in);

        for (int i = 3; i < till + 1; i += 2) {
            if (!nonPrimes[i]) {
                if (i >= from) {
                    list.add(i);
                }
                for (int j = 2 * i; j < till + 1; j += i) {
                    nonPrimes[j] = true;
                }
            }
        }
        return list;
    }

    public static void main(String[] st) {
        p49 q = new p49();
        System.out.println(q.questionNaive(4));
    }
}
