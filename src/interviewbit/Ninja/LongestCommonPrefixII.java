package interviewbit.Ninja;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Defining substring
 * For a string P with characters P1, P2 ,…, Pq, let us denote by P[i, j] the substring Pi, Pi+1 ,…, Pj.
 *
 * Defining longest common prefix
 * LCP(S1, S2 ,…, SK), is defined as largest possible integer j such that S1[1, j] = S2[1, j] = … = SK[1, j].
 *
 * You are given an array of N strings, A1, A2 ,…, AN and an integer K. Count how many indices (i, j) exist such that 1 ≤ i ≤ j ≤ N and LCP(Ai, Ai+1 ,…, Aj) ≥ K. Print required answer modulo 109+7.
 *
 * Note that K does not exceed the length of any of the N strings. K <= min(len(A_i)) for all i
 *
 * For example,
 *
 * A = ["ab", "ac", "bc"] and K=1.
 *
 * LCP(A[1, 1]) = LCP(A[2, 2]) = LCP(A[3, 3]) = 2
 * LCP(A[1, 2]) = LCP("ab", "ac") = 1
 * LCP(A[1, 3]) = LCP("ab", "ac", "bc") = 0
 * LCP(A[2, 3]) = LCP("ac", "bc") = 0
 *
 * So, answer is 4.
 * Return your answer % MOD = 1000000007
 *
 * Constraints
 * 1 ≤ Sum of length of all strings ≤ 5*105
 * Strings consist of small alphabets only.
 */
public class LongestCommonPrefixII {

  public int LCPrefix2(ArrayList<String> A, int B) {
    int sum = 0;
    String prev = "";
    for (int i = 0; i < A.size(); i++) {
      for (int j = i; j < A.size(); j++) {
        prev = (j == i) ? A.get(i).substring(0,B) : common(prev, A.get(j));
        if (prev.length() == B) {
          sum = (sum + 1) % 1000000007;
        } else
          break;
      }
    }
    return sum;
  }

  public int LCPrefix(ArrayList<String> A, int B) {
    int sum = 0;
    int till = 0;
    for (int i = 0; i < A.size(); i++) {
      int good = 0;
      int bad = A.size()-1;
      if(A.size()<=till || common(A.get(i),A.get(till)).length()>=B){
        good = till;
      }
      else {
        bad = till;
      }
      till = findLastRelevant(A,i,B,good,bad);
      sum = (sum + till) % 1000000007;
    }
    return sum;
  }

  private int findLastRelevant(ArrayList<String> a, int i, int b,int good,int bad) {
    int till = a.size()-1;
    if(commonLen(a,i,till)>=b){
      return till-i+1;
    }

    while(good+1 < bad){
      till = (good+bad)/2;
      if(commonLen(a,i,till)>=b){
          good=till;
      }
      else{
        bad = till;
      }
    }
    return good-i+1;
  }

  private int commonLen(ArrayList<String> a, int start, int till) {
    String s = a.get(start);
    for (int j = 0; j < s.length(); j++) {
      for (int i = start; i <= till; i++) {
        if (a.get(i).length() <= j || s.charAt(j) != a.get(i).charAt(j)) {
          return j;
        }
      }
    }
    return s.length();
  }

  private String common(String s1, String s2) {
    int len = Math.min(s1.length(), s2.length());
    for (int i = 0; i < len; i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        return (i == 0) ? "" : s1.substring(0, i);
      }
    }
    return s1.substring(0, len);
  }

  public static void main(String[] st) {
    LongestCommonPrefixII q = new LongestCommonPrefixII();
    System.out.println(q.LCPrefix(new ArrayList<>(Arrays.asList("ailuhkovar", "ailuhkqqhu", "ailuhkjsnr", "ailuhktgty", "ailuhkcpol")), 6));
    System.out.println(q.LCPrefix(new ArrayList<>(Arrays.asList("ab", "ac", "bc")), 1));
  }
}
