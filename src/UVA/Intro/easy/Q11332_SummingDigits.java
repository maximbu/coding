package UVA.Intro.easy;

import java.util.Scanner;

class Q11332_SummingDigits {
  public static void main(String[] st) {
    Q11332_SummingDigits p = new Q11332_SummingDigits();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int num = sc.nextInt();
      sc.nextLine();
      if (num == 0) return;
      int ans = solve(num);
      System.out.println(ans);
    }
  }

  private int solve(int num) {
    if (num < 10)
      return num;
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return solve(sum);
  }

}
