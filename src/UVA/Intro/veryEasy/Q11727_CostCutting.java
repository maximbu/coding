package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

class Q11727_CostCutting {

  public static void main(String[] st) {
    Q11727_CostCutting p = new Q11727_CostCutting();
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
      int result = solve(line);
      out.println("Case " + i++ + ": " + result);
    }
  }

  private int solve(int[] line) {
    Arrays.sort(line);
    return line[1];
  }
}
