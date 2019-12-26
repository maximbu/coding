package UVA.Intro.medium;

import java.util.Scanner;

class Q10424_LoveCalculator {

  public static void main(String[] st) {
    Q10424_LoveCalculator p = new Q10424_LoveCalculator();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String name1 = sc.nextLine();
      String name2 = sc.nextLine();
      int val1 = evaluate(name1);
      int val2 = evaluate(name2);
      double calc = 100.0 * Math.min(val1, val2) / Math.max(val1, val2);
      System.out.println(String.format("%.2f", calc) + " %");
    }
  }

  private int evaluate(String name) {
    char[] chars = name.toCharArray();
    int sum = 0;
    for (char c : chars) {
      if (c >= 'a' && c <= 'z')
        sum += c - 'a' + 1;
      if (c >= 'A' && c <= 'Z')
        sum += c - 'A' + 1;
    }
    while (sum >= 10) {
      int tmpSum = 0;
      while (sum > 0) {
        tmpSum += sum % 10;
        sum /= 10;
      }
      sum = tmpSum;
    }
    return sum;
  }
}
