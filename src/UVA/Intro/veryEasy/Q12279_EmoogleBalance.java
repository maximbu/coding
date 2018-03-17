package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

class Q12279_EmoogleBalance {

  public static void main(String[] st) {
    Q12279_EmoogleBalance p = new Q12279_EmoogleBalance();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int i = 1;
    while (true) {
      int n = sc.nextInt();
      if (n == 0)
        return;
      sc.nextLine();
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println("Case " + i++ + ": " + result);
    }
  }

  private int solve(int[] line) {
    int nonZero = (int) Arrays.stream(line).filter(t -> t > 0).count();
    int zero = (int) Arrays.stream(line).filter(t -> t == 0).count();
    return nonZero - zero;
  }

}
