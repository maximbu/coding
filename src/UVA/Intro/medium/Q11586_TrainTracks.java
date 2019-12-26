package UVA.Intro.medium;

import java.util.Scanner;

class Q11586_TrainTracks {

  public static void main(String[] st) {
    Q11586_TrainTracks p = new Q11586_TrainTracks();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    sc.nextLine();
    while (cases-- > 0) {
      String[] input = sc.nextLine().split("\\s+");
      String ans = solve(input);
      System.out.println(ans);
    }
  }

  private String solve(String[] input) {
    boolean canLoop = false;
    if (input.length > 1) {
      int leftM = 0;
      int leftF = 0;
      int rightM = 0;
      int rightF = 0;
      for (String piece : input) {
        if (piece.charAt(0) == 'M') leftM++;
        else leftF++;
        if (piece.charAt(1) == 'M') rightM++;
        else rightF++;
      }
      canLoop = ((leftF == rightM) || (leftM == rightF));
    }

    return (canLoop ? "" : "NO ") + "LOOP";
  }


}
