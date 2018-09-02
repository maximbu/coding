package CodingInterviews2018.P1;

import java.util.HashSet;
import java.util.Set;

public class q1_4 {
  private static boolean isPalindromePermutation(String s) {
    char[] chars = s.toCharArray();
    Set<Character> set = new HashSet<>();
    for (char c : chars) {
      if(Character.isLetter(c)) {
        if (!set.remove(Character.toLowerCase(c))) {
          set.add(Character.toLowerCase(c));
        }
      }
    }
    return set.size() < 1;
  }

  public static void main(String[] args) {
    System.out.println("isPalindromePermutation(Tact Coa)"+"->"+isPalindromePermutation("Tact Coa"));
    System.out.println("isPalindromePermutation(Tact Coa)"+"->"+isPalindromePermutation("Tact Cot"));
    System.out.println("isPalindromePermutation(ABCca)"+"->"+isPalindromePermutation("ABCca"));
    System.out.println("isPalindromePermutation(ABCcad)"+"->"+isPalindromePermutation("ABCcad"));
  }
}
