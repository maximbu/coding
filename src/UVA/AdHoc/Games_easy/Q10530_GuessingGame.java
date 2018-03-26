package UVA.AdHoc.Games_easy;

import java.util.Scanner;

class Q10530_GuessingGame {

  public static void main(String[] st) {
    Q10530_GuessingGame p = new Q10530_GuessingGame();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int low = 0;
    int high = 11;
    while (true) {
      int guess = Integer.parseInt(sc.nextLine());
      if (guess == 0) {
        return;
      }
      String feedback = sc.nextLine();
      if (feedback.equals("too high")) {
        high = Math.min(high, guess);
      }
      if (feedback.equals("too low")) {
        low = Math.max(low, guess);
      }
      if (feedback.equals("right on")) {
        boolean ans = (low < guess && guess < high);
        low = 0;
        high = 11;
        System.out.println(ans ? "Stan may be honest" : "Stan is dishonest");
      }
    }
  }

}

