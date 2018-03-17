package UVA.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q11799_HorrorDash {

  public static void main(String[] st) {
    Q11799_HorrorDash p = new Q11799_HorrorDash();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int numOfTests = sc.nextInt();
    sc.nextLine();
    int caseNum = 1;
    while (numOfTests-- > 0) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      System.out
          .println("Case " + (caseNum++) + ": " + Arrays.stream(line).skip(1).max().getAsInt());
    }
  }
}
