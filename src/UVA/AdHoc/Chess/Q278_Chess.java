package UVA.AdHoc.Chess;

import java.util.Scanner;

class Q278_Chess {


  public static void main(String[] st) {
    Q278_Chess p = new Q278_Chess();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    sc.nextLine();
    while (cases > 0) {
      String[] input = sc.nextLine().split("\\s+");
      if(input.length == 3) {
        int ans = solve(input);
        System.out.println(ans);
        cases--;
      }
    }
  }

  private int solve(String[] line) {
    int m = Integer.parseInt(line[1]);
    int n = Integer.parseInt(line[2]);
    switch (line[0]){
      case "r": return solveRook(m,n);
      case "k": return solveKnight(m,n);
      case "Q": return solveQueen(m,n);
      case "K": return solveKing(m,n);
    }
    return 0;
  }

  /*
  x		x		x

  x		x		x

  x		x		x

   */
  private int solveKing(int m, int n) {
    return ((m+1)/2) * ((n+1)/2);
  }


  /*
    		x
  x
			    x
	  x

   */
  private int solveQueen(int m, int n) {
    return  Math.min(m, n);
  }

  /*
  x		x
	  x		x
  x		x
	  x		x
  x		x
   */
  private int solveKnight(int m, int n) {
    int ans = Math.min(m, n) * Math.max(m, n) / 2;
    return ans + (m * n % 2);
  }

  /*
    x
      x
        x
          x
   */
  private int solveRook(int m, int n) {
    return Math.min(m,n);
  }


}
