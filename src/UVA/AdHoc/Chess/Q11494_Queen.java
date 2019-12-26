package UVA.AdHoc.Chess;

import java.util.Arrays;
import java.util.Scanner;

class Q11494_Queen {

  public static void main(String[] st) {
    Q11494_Queen p = new Q11494_Queen();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      if (Arrays.stream(line).sum() == 0) return;
      int ans = solve(line);
      System.out.println(ans);
    }
  }

  private int solve(int[] line) {
    if (line[0] == line[2]) {
      return line[1] == line[3] ? 0 : 1;
    }
    if (line[1] == line[3]) {
      return 1;
    }
    return sameDiagonal(line[0], line[1], line[2], line[3]) ? 1 : 2;
  }

  private boolean sameDiagonal(int i, int i1, int i2, int i3) {
    boolean sameLeftDiagonal = ((i - i2) == (i1 - i3));
    boolean sameRightDiagonal = ((i - i2) == -1 * (i1 - i3));
    return sameLeftDiagonal || sameRightDiagonal;
  }


}
