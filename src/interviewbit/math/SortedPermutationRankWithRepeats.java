package interviewbit.math;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Given a string, find the rank of the string amongst its permutations sorted lexicographically.
 Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
 The answer might not fit in an integer, so return your answer % 1000003
 */
public class SortedPermutationRankWithRepeats {

  public static void main(String[] st) {
    SortedPermutationRankWithRepeats q = new SortedPermutationRankWithRepeats();

    String input = "aba";
    System.out.println(q.findRank(input));

    input = "baa";
    System.out.println(q.findRank(input));

    input = "bbbbaaaa";
    System.out.println(q.findRank(input));
  }


  private static final int M = 1000003;

  public int findRank(String a) {
    int n = a.length();
    long[] facts = new long[n + 1];
    long[] infacts = new long[n + 1];
    facts[0] = infacts[0] = 1;
    for (int i = 1; i <= n; i++) {
      facts[i] = (facts[i - 1] * i) % M;
      infacts[i] = modExp(facts[i], M - 2);
    }

    int[] c = new int[52];
    for (char ch : a.toCharArray()) {
      c[o(ch)]++;
    }

    long rank = 0;
    int count = a.length();
    for (char ch : a.toCharArray()) {
      count--;
      for (int t = 0; t < o(ch); t++) {
        if (c[t] > 0) {
          c[t]--;
          long trank = facts[count];
          for (int i = 0; i < 52; i++) {
            if (c[i] > 0) {
              trank = (trank * infacts[c[i]]) % M;
            }
          }
          rank = (rank + trank) % M;
          c[t]++;
        }
      }
      c[o(ch)]--;
    }
    return (int)(rank + 1) % M;
  }

  private int o(char ch) {
    return ch <= 'Z' ? ch - 'A' : ch - 'a' + 26;
  }

  private long modExp(long xint, long yint) {
    long res = 1;
    long x = xint;
    long y = yint;
    while (y > 0) {
      if ((y & 1) == 1) {
        res = (res * x) % M;
      }
      x = (x * x) % M;
      y >>= 1;
    }
    return res;
  }
}


