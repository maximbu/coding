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
    return set.size() < 2;
  }

  private static boolean isPalindrome(String s) {
    char[] chars = s.toCharArray();
    int left=0;
    int right = s.length()-1;
    while (right>left){
      if(!Character.isLetter(chars[left])){
        left++;
        continue;
      }
      if(!Character.isLetter(chars[right])){
        right--;
        continue;
      }

      if(Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])){
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("isPalindromePermutation(Tact Coa)"+"->"+isPalindromePermutation("Tact Coa"));
    System.out.println("isPalindromePermutation(Tact Coa)"+"->"+isPalindromePermutation("Tact Cot"));
    System.out.println("isPalindromePermutation(ABCca)"+"->"+isPalindromePermutation("ABCca"));
    System.out.println("isPalindromePermutation(ABCcad)"+"->"+isPalindromePermutation("ABCcad"));

    System.out.println("isPalindrome(a oct Coa)"+"->"+isPalindrome("a oct Coa"));
  }
}
