package UVA.AdHoc.Games_harder;

import java.util.Scanner;

class Q584_Bowling {

  public static void main(String[] st) {
    Q584_Bowling p = new Q584_Bowling();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String in = sc.nextLine();
      if (in.equals("Game Over")) {
        return;
      }
      in += " 0 0"; // avoid out of index
      String[] input = in.split("\\s+");

      int ans = solve(input);
      System.out.println(ans);
    }
  }

  boolean isStrike(String s) {
    return s.equals("X");
  }

  boolean isSpare(String s) {
    return s.equals("/");
  }

  int value(String s) {
    if (isSpare(s) || isStrike(s))
      return 10;
    return Integer.valueOf(s);
  }

  private int solve(String[] input) {
    int score = 0;
    for (int i = 0, round = 1; i < input.length && round < 11; i++, round++) {
      if (!isStrike(input[i])) { // can't be spare
        score += handleRegular(input[i], input[i + 1], input[i + 2]);
        i++;
      } else {
        score += handleStrike(input[i + 1], input[i + 2]);
      }
    }
    return score;
  }

  private int handleRegular(String current, String next, String nextNext) {
    if (isSpare(next)) {
      return 10 + value(nextNext);
    }
    return value(current) + value(next);
  }


  private int handleStrike(String next, String nextNext) {
    if (isStrike(next)) {
      return 20 + value(nextNext);
    }
    return isSpare(nextNext) ? 20 : 10 + value(next)
            + value(nextNext);
  }


}
