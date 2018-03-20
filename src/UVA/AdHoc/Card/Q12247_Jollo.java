package UVA.AdHoc.Card;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q12247_Jollo {

  //int t= 1;
  public static void main(String[] st) {
    Q12247_Jollo p = new Q12247_Jollo();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      if (Arrays.stream(line).allMatch(t -> t == 0))
        return;
      int ans = solve(line);
      System.out.println(ans);
      //System.out.println((t++)+" : "+ans + " for :"+ Arrays.toString(line));
    }
  }

  private int solve(int[] line) {
    int[] princess = Arrays.stream(line).limit(3).sorted().toArray();
    int[] prince = Arrays.stream(line).skip(3).sorted().toArray();
    if (prince[0] > princess[2]) {
      return getValue(line, 1);
    }
    if (prince[1] < princess[1] || (prince[1] < princess[2] && prince[0] < princess[1]))
      return -1;
    if (prince[0] < princess[0] || prince[0] > princess[0] && princess[1] > prince[0])
      return getValue(line, princess[2] + 1);
    else
      return getValue(line, princess[1] + 1);
  }

  private int getValue(int[] line, int i) {
    for (int j = i; j < 53; j++) {
      int finalJ = j;
      if (IntStream.of(line).noneMatch(x -> x == finalJ))
        return j;
    }
    return -1;
  }
}
