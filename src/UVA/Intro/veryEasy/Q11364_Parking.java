package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

class Q11364_Parking {

  public static void main(String[] st) {
    Q11364_Parking p = new Q11364_Parking();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    while (2 * (n--) > 0) {
      sc.nextLine();
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println(result);
    }
  }

  private int solve(int[] line) {
    int min = Arrays.stream(line).min().getAsInt();
    int max = Arrays.stream(line).max().getAsInt();
    return 2 * (max - min);
  }

}
