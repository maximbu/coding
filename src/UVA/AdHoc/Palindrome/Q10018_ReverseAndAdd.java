package UVA.AdHoc.Palindrome;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;
import java.util.stream.IntStream;

class Q10018_ReverseAndAdd {
  public static void main(String[] st) {
    Q10018_ReverseAndAdd p = new Q10018_ReverseAndAdd();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int cases = Integer.valueOf(sc.nextLine());
    while (cases-- > 0) {
      String input = sc.nextLine().trim();
      String num = input;
      int i = 0;
      do {
        num = String.valueOf(Long.parseLong(num) + reversed(num));
        i++;
      } while (!isPalindrome(num));
      out.println(i + " " + num);
    }
  }

  private long reversed(String num) {
    StringBuilder input1 = new StringBuilder();

    input1.append(num);

    return Long.parseLong(input1.reverse().toString());
  }

  private boolean isPalindrome(String st) {
    return IntStream.range(0, st.length()/2)
        .allMatch(i -> st.charAt(i) == st.charAt(st.length() - i - 1));
  }

}
