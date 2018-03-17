package UVA.Intro.medium;

import java.util.Scanner;

class Q11687_Digits {

  public static void main(String[] st) {
    Q11687_Digits p = new Q11687_Digits();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String input = sc.nextLine();
      if (input.equals("END"))
        return;
      int cnt = 1;
      while (!input.equals("1")) {
        cnt++;
        input = String.valueOf(input.length());
      }
      System.out.println(cnt);
    }
  }
}
