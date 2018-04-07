package UVA.AdHoc.Games_harder;

import java.text.DecimalFormat;
import java.util.Scanner;

class Q10903_RockPaperScissorsTournament {

  public static void main(String[] st) {
    Q10903_RockPaperScissorsTournament p = new Q10903_RockPaperScissorsTournament();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    boolean first = true;
    while (true) {
      int n = sc.nextInt();
      if (n == 0)
        return;
      int k = sc.nextInt();
      sc.nextLine();
      int[] wins = new int[n];
      int[] losses = new int[n];

      for (int i = 0; i < (k * n * (n - 1)) / 2; i++) {
        int p1 = sc.nextInt() - 1;
        String m1 = sc.next();
        int p2 = sc.nextInt() - 1;
        String m2 = sc.next();
        sc.nextLine();
        int c = compare(m1, m2);
        if (c > 0) {
          wins[p1]++;
          losses[p2]++;
        }
        if (c < 0) {
          wins[p2]++;
          losses[p1]++;
        }
      }

      if (!first) {
        System.out.println();
      }

      first = false;
      printOutput(wins, losses);
    }

  }

  private void printOutput(int[] wins, int[] losses) {
    for (int i = 0; i < wins.length; i++) {
      if (wins[i] + losses[i] == 0) {
        System.out.println("-");
      } else {
        double val = (double) wins[i] / (wins[i] + losses[i]);
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(val));
      }
    }
  }

  private int compare(String m1, String m2) {
    if (m1.equals(m2))
      return 0;
    if (m1.equals("rock") && m2.equals("scissors"))
      return 1;
    if (m1.equals("scissors") && m2.equals("paper"))
      return 1;
    if (m1.equals("paper") && m2.equals("rock"))
      return 1;
    return -1;
  }

}
