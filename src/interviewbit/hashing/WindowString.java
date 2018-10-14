package interviewbit.hashing;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
 * Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.
 *
 * Example :
 *
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC"
 *
 *  Note:
 * If there is no such window in S that covers all characters in T, return the empty string ''.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */
public class WindowString {

  public String minWindow(String A, String B) {
    int[] chB = new int[256];
    int[] chA = new int[256];
    //HashMap<Character,Integer> chB = new HashMap<>();
    //HashMap<Character,Integer> chA = new HashMap<>();
    if (B.length() > A.length())
      return "";
    String best = "";
    int min = Integer.MAX_VALUE;
    if (A.length() == B.length()) {
      return A.equals(B) ? A : "";
    }
    for (int i = 0; i < B.length(); i++) {
      chB[B.charAt(i)]++;
    }
    /*
    for (char c:B.toCharArray()) {
      chB.put(c, chB.getOrDefault(c, 0) + 1);
    }
    */
    int from = 0;
    int to = 0;
    while (from < A.length()) {
      while (to < A.length()) {
        //chA.put(A.charAt(to), chA.getOrDefault(A.charAt(to), 0) + 1);
        chA[A.charAt(to)]++;
        to++;
        while (contains(chA, chB)) {
          //chA.put(A.charAt(from), chA.get(A.charAt(from)) - 1);
          chA[A.charAt(from)]--;
          from++;
          if (!contains(chA, chB)) {
            if (to - from < min) {
              min = to - from;
              best = A.substring(from - 1, to);
            }
            break;
          }
        }
      }
      from++;
    }
    return best;
  }

  private boolean contains(HashMap<Character,Integer> big, HashMap<Character,Integer> small) {
    return small.entrySet().stream().noneMatch(e -> big.getOrDefault(e.getKey(), 0) < e.getValue());
  }

  private boolean contains(int[] big, int[] small) {
    for (int i = 0; i < small.length; i++) {
      if (small[i] > big[i])
        return false;
    }
    return true;
  }

  public static void main(String[] st) {
    WindowString q = new WindowString();
    System.out.println(q.minWindow("AAAAAA", "AA"));
    System.out.println(q.minWindow(
            "xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh",
            "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h"));
    System.out.println(q.minWindow("0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes", "rsm2ty04PYPEOPYO5"));
    System.out.println(q.minWindow("w", "o"));
    System.out.println(q.minWindow("ADOBECODEBANC", "ABC"));
  }
}
