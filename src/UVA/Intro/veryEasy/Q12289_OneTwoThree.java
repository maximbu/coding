package UVA.Intro.veryEasy;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q12289_OneTwoThree {
  public static void main(String[] st) {
    Q12289_OneTwoThree p = new Q12289_OneTwoThree();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    while (n-- > 0) {
      int result = solve(sc.nextLine());
      out.println(result);
    }
  }

  private int solve(String line) {
    if (line.length() == 5) return 3;
    String oneStr = "one";
    String twoStr = "two";
    int one = 0;
    int two = 0;
    for (int i = 0; i < 3; i++) {
      if (line.charAt(i) == oneStr.charAt(i)) one++;
      if (line.charAt(i) == twoStr.charAt(i)) two++;
    }
    return one > two ? 1 : 2;
  }
}
