package UVA.AdHoc.RealLife_easy;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q10812_BeatTheSpread {

  public static void main(String[] st) {
    Q10812_BeatTheSpread p = new Q10812_BeatTheSpread();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int cases = sc.nextInt();
    while (cases-- > 0) {
      sc.nextLine();
      int sum = sc.nextInt();
      int diff = sc.nextInt();
      long b = diff + (sum - diff) / 2;
      long s = sum - b;
      if ((b - s) == diff && b >= 0 && s >= 0) {
        out.println(b + " " + s);
      } else {
        out.println("impossible");
      }
    }
  }


}
