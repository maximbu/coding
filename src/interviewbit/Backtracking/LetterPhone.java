package interviewbit.Backtracking;

import java.util.ArrayList;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 *
 * The digit 0 maps to 0 itself.
 * The digit 1 maps to 1 itself.
 *
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Make sure the returned strings are lexicographically sorted.
 */
public class LetterPhone {

  public ArrayList<String> letterCombinations(String A) {
    ArrayList<String> ans = new ArrayList<>();
    letterCombinations(A, new StringBuilder(), ans);
    return ans;
  }

  private void letterCombinations(String A, StringBuilder curr, ArrayList<String> ans) {
    if (A.length() == 0) {
      ans.add(curr.toString());
      return;
    }
    for (char c : options(A.charAt(0))) {
      curr.append(c);
      letterCombinations(A.substring(1), curr, ans);
      curr.deleteCharAt(curr.length() - 1);
    }
  }

  private char[] options(char d) {
    switch (d) {
      case '0':
        return new char[]{'0'};
      case '1':
        return new char[]{'1'};
      case '2':
        return new char[]{'a', 'b', 'c'};
      case '3':
        return new char[]{'d', 'e', 'f'};
      case '4':
        return new char[]{'g', 'h', 'i'};
      case '5':
        return new char[]{'j', 'k', 'l'};
      case '6':
        return new char[]{'m', 'n', 'o'};
      case '7':
        return new char[]{'p', 'q', 'r', 's'};
      case '8':
        return new char[]{'t', 'u', 'v'};
      case '9':
        return new char[]{'w', 'x', 'y', 'z'};
    }
    throw new IllegalStateException();
  }
}
