package UVA.Intro.veryEasy;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q11547_AutomaticAnswer {
  public static void main(String[] st) {
    Q11547_AutomaticAnswer p = new Q11547_AutomaticAnswer();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    while (n-- > 0) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println(result);
    }
  }

  private int solve(int[] line) {
    long x = line[0];
    return (int) Math.abs((x * 315 + 36962) % 100) / 10;
  }
}
