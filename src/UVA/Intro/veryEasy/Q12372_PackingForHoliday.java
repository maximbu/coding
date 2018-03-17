package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

class Q12372_PackingForHoliday {
  public static void main(String[] st) {
    Q12372_PackingForHoliday p = new Q12372_PackingForHoliday();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    int i = 1;
    sc.nextLine();
    while (n-- > 0) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      String result = solve(line);
      out.println("Case " + i++ + ": " + result);
    }
  }

  private String solve(int[] line) {
    return Arrays.stream(line).allMatch(t -> t <= 20) ? "good" : "bad";
  }
}
