package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

class Q12403_SaveSetu {
  public static void main(String[] st) {
    Q12403_SaveSetu p = new Q12403_SaveSetu();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    long total = 0;
    while (n-- > 0) {
      String line = sc.nextLine();
      if(line.equals("report")){
        out.println(total);
      }
      else {
        total += Integer.parseInt(line.split("\\s+")[1]);
      }
    }
  }

}
