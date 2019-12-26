package interviewbit.math;


import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by max on 7/16/2017.
 * Given a number N, find all prime numbers upto N ( N included ).
 */
public class PrimeNumbers {
    public static void main(String[] st) {
        PrimeNumbers q = new PrimeNumbers();

        int N = 7;
        System.out.println(q.sieve(N));
    }

    public ArrayList<Integer> sieve(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (a < 2) return ans;
        BitSet notPrimes = new BitSet(a);
        ans.add(2);
        for (int i = 3; i <= a; i += 2) {
            if (!notPrimes.get(i)) {
                ans.add(i);
                for (int j = 2 * i; j <= a; j += i) {
                    notPrimes.set(j);
                }
            }
        }
        return ans;
    }
}
