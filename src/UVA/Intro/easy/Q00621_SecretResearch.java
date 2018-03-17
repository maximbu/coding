package UVA.easy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

class Q00621_SecretResearch {
  public static void main(String[] st) {
    Q00621_SecretResearch p = new Q00621_SecretResearch();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    while (n-- > 0) {
      String input  = sc.nextLine();
      char result = solve(input);
      out.println(result);
    }
  }

  private char solve(String num) {
    if(num.equals("1") || num.equals("4") || num.equals("78")) return '+';
    if(num.endsWith("35")) return '-';
    if(num.startsWith("9") && num.endsWith("4")) return '*';
    return '?';
  }

}
