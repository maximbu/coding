package UVA.AdHoc.Palindrome;

import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;

class Q11309_CountingChaos {

  public static void main(String[] st) {
    Q11309_CountingChaos p = new Q11309_CountingChaos();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int cases = Integer.parseInt(sc.nextLine());
    int c = 0;
    while (c++ < cases) {
      String input = sc.nextLine().trim();

      String ans = solve(input);
      System.out.println(ans);
    }
  }

  private String solve(String input) {
    int h = Integer.parseInt(input.substring(0, 2));
    int m = Integer.parseInt(input.substring(3));
    if (h == 0) {
      while (m < 60) {
        if (isPalindrome(String.valueOf(++m))) {
          return "00:" + (m < 10 ? "0" : "") + m;
        }
      }
      return "01:01";
    }
    for (int i = h; i < 24; i++) {
      for (int j = 0; j < 60; j++) {
        if (i == h && j <= m)
          continue;
        String time = String.valueOf(i) + (j < 10 ? "0" : "") + String.valueOf(j);
        if (isPalindrome(time)) {
          return (i < 10 ? "0" : "") + String.valueOf(i) + (j < 10 ? ":0" : ":") + String
                  .valueOf(j);
        }
      }
    }
    return "00:00";
  }

  private boolean isPalindrome(String st) {
    return IntStream.range(0, st.length() / 2)
            .allMatch(i -> st.charAt(i) == st.charAt(st.length() - i - 1));
  }

}
