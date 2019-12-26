package UVA.AdHoc.RealLife_easy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q11945_FinancialManagement {

  public static void main(String[] st) {
    Q11945_FinancialManagement p = new Q11945_FinancialManagement();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int cases = sc.nextInt();
    sc.nextLine();
    int i = 1;
    while (cases-- > 0) {
      double sum = 0;
      for (int j = 0; j < 12; j++) {
        sum += Double.parseDouble(sc.nextLine());
      }

      out.print(String.format("%d $%,.2f%n", i++, round(sum / 12, 2)));
    }
  }

  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }


}
