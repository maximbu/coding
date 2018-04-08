package UVA.AdHoc.Palindrome;

import static java.lang.System.in;

import java.util.Scanner;

class Main {

  public static void main(String[] st) {
    Main p = new Main();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int cases = Integer.valueOf(sc.nextLine());
    int c = 0;
    while (c++ < cases) {
      String input = sc.nextLine().trim();

      String ans = solve(input);
      System.out.println(ans);
    }
  }

  private String solve(String input) {
        
    return "00:00";
  }

}
