package UVA.Intro.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q11679_Subprime {

  public static void main(String[] st) {
    Q11679_Subprime p = new Q11679_Subprime();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      if (input.length == 2 && input[0].equals("0") && input[1].equals("0")) {
        return;
      }
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int banks = line[0];
      int debenturesCount = line[1];
      input = sc.nextLine().split("\\s+");
      int[] reserves = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int[][] debentures = new int[debenturesCount][3];
      for (int i = 0; i < debenturesCount; i++) {
        input = sc.nextLine().split("\\s+");
        debentures[i] = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      }
      char ans = solve(reserves, debentures);
      System.out.println(ans);
    }
  }

  private char solve(int[] reserves, int[][] debentures) {
    for (int[] debenture : debentures) {
      reserves[debenture[0] - 1] -= debenture[2];
      reserves[debenture[1] - 1] += debenture[2];
    }
    return Arrays.stream(reserves).anyMatch(t -> t < 0) ? 'N' : 'S';
  }

}
