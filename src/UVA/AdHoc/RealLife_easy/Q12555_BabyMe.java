package UVA.AdHoc.RealLife_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Q12555_BabyMe {

  public static void main(String[] st) throws IOException {
    Q12555_BabyMe p = new Q12555_BabyMe();
    p.solve();
  }

  private void solve() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    int testCase = 1;
    while (testCase <= cases) {
      double a = 0;
      String s = br.readLine();
      int index = 0;
      char c = s.charAt(index++);
      while (Character.isDigit(c)) {
        a = a * 10 + (c - '0');
        c = s.charAt(index++);
      }

      double b = 0;
      while (index < s.length()) {
        c = s.charAt(index++);
        if (Character.isDigit(c)) {
          b = b * 10 + (c - '0');
        }
      }

      a = a * 0.5;
      b = b * 0.05;

      String result = String.valueOf(a + b);
      if (result.endsWith(".0")) {
        result = result.substring(0, result.length() - 2);
      }
      String sb = String.format("Case %d: %s", testCase, result);
      System.out.println(sb);
      testCase++;
    }
  }

}
