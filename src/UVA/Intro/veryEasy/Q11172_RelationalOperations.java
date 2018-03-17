package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

class Q11172_RelationalOperations {

  public static void main(String[] st) {
    Q11172_RelationalOperations p = new Q11172_RelationalOperations();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    while (n-- > 0) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      char result = solve(line);
      out.println(result);
    }
  }

  private char solve(int[] line) {
    return line[0] < line[1] ? '<' : line[0] > line[1] ? '>' : '=';
  }
}
