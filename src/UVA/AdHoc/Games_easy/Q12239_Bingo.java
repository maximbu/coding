package UVA.AdHoc.Games_easy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q12239_Bingo {

  public static void main(String[] st) {
    Q12239_Bingo p = new Q12239_Bingo();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int N = line[0];
      if(line[0] == 0 && line[1]==0) return;
      input = sc.nextLine().split("\\s+");
      line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      boolean ans = solve(N,line);
      System.out.println(ans?"Y":"N");
    }
  }

  private boolean solve(int n, int[] line) {
    boolean[] comb = new boolean[n+1];
    Arrays.sort(line);
    for (int i = 0; i < line.length; i++) {
      for (int j = i+1; j < line.length; j++) {
        comb[line[j]-line[i]] = true;
      }
    }
    return IntStream.range(1, comb.length).allMatch(i -> comb[i]);
  }


}
