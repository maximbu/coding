package UVA.AdHoc.Chess;

import java.util.Arrays;
import java.util.Scanner;

class Q10849_MoveTheBishop {

  public static void main(String[] st) {
    Q10849_MoveTheBishop p = new Q10849_MoveTheBishop();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    while (cases-- > 0) {
      sc.nextLine();
      int currBoardCases = sc.nextInt();
      sc.nextLine();
      int n = sc.nextInt();
      sc.nextLine();
      while (currBoardCases-- > 0) {
        String[] input = sc.nextLine().split("\\s+");
        long[] line = Arrays.stream(input).mapToLong(Long::parseLong).toArray();
        int ans = solve(n, line);
        if (ans == -1) {
          System.out.println("no move");
        } else {
          System.out.println(ans);
        }
      }
    }
  }

  private int solve(int n, long[] line) {
    if (Arrays.stream(line).anyMatch(t -> t > n || t < 1))
      return -1;
    if ((line[0] == line[2]) && (line[1] == line[3]))
      return 0;
    long diff1 = Math.abs(line[0] - line[2]);
    long diff2 = Math.abs(line[1] - line[3]);
    if (diff1 == diff2) return 1;
    return diff1 % 2 == diff2 % 2 ? 2 : -1;
  }

}
