package UVA.Intro.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q11764_JumpingMario {

  public static void main(String[] st) {
    Q11764_JumpingMario p = new Q11764_JumpingMario();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int numOfTests = sc.nextInt();
    sc.nextLine();
    int caseNum = 1;
    while (numOfTests-- > 0) {
      int numOfWalls = sc.nextInt();
      sc.nextLine();
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int high = 0;
      int low = 0;
      for (int i = 1; i < numOfWalls; i++) {
        if (line[i] > line[i - 1])
          high++;
        if (line[i] < line[i - 1])
          low++;
      }
      System.out.println("Case " + (caseNum++) + ": " + high + " " + low);
    }
  }
}
