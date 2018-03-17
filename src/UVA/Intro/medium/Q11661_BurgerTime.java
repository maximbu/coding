package UVA.Intro.medium;

import java.util.Scanner;

class Q11661_BurgerTime {

  public static void main(String[] st) {
    Q11661_BurgerTime p = new Q11661_BurgerTime();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int len = sc.nextInt();
      if(len == 0) return;
      sc.nextLine();
      String road = sc.nextLine();
      int ans = solve(road);
      System.out.println(ans);
    }
  }

  private int solve(String road) {
    char[] chars = road.toCharArray();
    int closestDist = Integer.MAX_VALUE;
    char cToFind = 'x';
    int prevLoc = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == 'Z') {
        return 0;
      }
      if (chars[i] == 'R' || chars[i] == 'D') {
        if (cToFind == chars[i]) {
          closestDist = Math.min(closestDist, i - prevLoc);
        }
        prevLoc = i;
        cToFind = (chars[i] == 'R')?'D':'R';

      }
    }
    return closestDist;
  }

}
