package interviewbit.math;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

/**
 * Created by max on 7/16/2017.
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * If there are more than one solutions possible, return the lexicographically smaller solution.
  */
public class PrimeSum {
  public static void main(String[] st) {
    PrimeSum q = new PrimeSum();

    int N = 24;
    System.out.println(q.primesum(N));
  }

  public ArrayList<Integer> sieve(int a) {
    ArrayList<Integer> ans = new ArrayList<>();
    if (a < 2)
      return ans;
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

  public ArrayList<Integer> primesum(int a) {
    ArrayList<Integer> primes = sieve(a);
    HashSet<Integer> hash = new HashSet<>(primes);
    for (Integer prime : primes) {
      if (hash.contains(a - prime)) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(prime);
        ans.add(a - prime);
        return ans;
      }
    }
    return new ArrayList<>();
  }


}
