package UVA.AdHoc.Palindrome;

import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;
import static java.lang.System.out;

class Q353_PeskyPalindromes {
  public static void main(String[] st) {
    Q353_PeskyPalindromes p = new Q353_PeskyPalindromes();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    while (sc.hasNextLine()) {
      String input = sc.nextLine().trim();
      int result = solve(input);
      out.println("The string '" + input + "' contains " + result + " palindromes.");
    }
  }

  private int solve(String st) {
    HashSet<String> palindromes = new HashSet<>();
    for (int i = 0; i < st.length(); i++) {
      for (int j = i + 1; j < st.length(); j++) {
        String sub = st.substring(i, j);
        if (isPalindrome(sub)) {
          palindromes.add(sub);
        }
      }
      String sub = st.substring(i);
      if (isPalindrome(sub)) {
        palindromes.add(sub);
      }
    }
    return palindromes.size();
  }

  private boolean isPalindrome(String sub) {
    return IntStream.range(0, sub.length())
            .allMatch(i -> sub.charAt(i) == sub.charAt(sub.length() - i - 1));
  }

}
