package UVA.Intro.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q10963_TheSwallowingGround {

  public static void main(String[] st) {
    Q10963_TheSwallowingGround p = new Q10963_TheSwallowingGround();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int numOfTests = sc.nextInt();
    sc.nextLine();
    while (numOfTests-- > 0) {
      sc.nextLine();
      int numOfCols = sc.nextInt();
      sc.nextLine();
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int diff = line[0] - line[1];
      boolean canClose = true;
      while (--numOfCols > 0) {
        input = sc.nextLine().split("\\s+");
        line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        if (diff != line[0] - line[1]) {
          canClose = false;
        }
      }
      System.out.println(canClose ? "yes" : "no");
      if (numOfTests != 0)
        System.out.println();
    }
  }

}
