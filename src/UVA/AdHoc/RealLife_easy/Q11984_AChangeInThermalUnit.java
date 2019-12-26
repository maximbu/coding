package UVA.AdHoc.RealLife_easy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q11984_AChangeInThermalUnit {

  public static void main(String[] st) {
    Q11984_AChangeInThermalUnit p = new Q11984_AChangeInThermalUnit();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int cases = sc.nextInt();
    int i = 1;
    while (cases-- > 0) {
      sc.nextLine();
      int cel = sc.nextInt();
      int f = sc.nextInt();
      double totalF = 9.0 * cel / 5 + 32 + f;
      double total = (totalF - 32) / 1.8;

      out.println(String.format("Case %d: %.2f", i++, round(total, 2)));
    }
  }

  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }


}
