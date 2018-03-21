package UVA.AdHoc.Chess;

import java.util.Scanner;

class Q696_HowManyKnights {

  public static void main(String[] st) {
    Q696_HowManyKnights p = new Q696_HowManyKnights();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      sc.nextLine();
      if(m==0 && n==0) return;
      int ans = solveKnight(m,n);
      System.out.println(ans +" knights may be placed on a "+ m +" row "+n+" column board.");
    }
  }


  /*
  x		x
	  x		x
  x		x
	  x		x
  x		x
   */
  private int solveKnight(int m, int n) {
    if(m==0 || n==0) return 0;
    if(m == 1 || n== 1 )
      return Math.max(m, n);
    if(m == 2 || n==2){
      int ans = Math.max(m,n) % 4 + Math.max(m,n);
      if(Math.max(m,n) % 4 == 3) ans-=2;
      return ans;
    }
    int ans = Math.min(m, n) * Math.max(m, n) / 2;
    return ans + (m * n % 2);
  }


}
