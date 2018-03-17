package UVA.easy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q11942_LumberjackSequencing {

  public static void main(String[] st) {
    Q11942_LumberjackSequencing p = new Q11942_LumberjackSequencing();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int numOfTests = sc.nextInt();
    sc.nextLine();
    System.out.println("Lumberjacks:");
    while (numOfTests-- > 0) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      boolean ans = solve(line);
      System.out.println(ans ? "Ordered" : "Unordered");
    }
  }

  private boolean solve(int[] line) {
    return IntStream.range(1, line.length).allMatch(i -> line[i] < line[i - 1])
        || IntStream.range(1, line.length).allMatch(i -> line[i] > line[i - 1]);
  }
}
