package UVA.Intro.veryEasy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;
import static java.lang.System.out;

class Q10550_CombinationLock {

  public static void main(String[] st) {
    Q10550_CombinationLock p = new Q10550_CombinationLock();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      if (IntStream.of(line).noneMatch(t -> t != 0))
        return;
      int result = solve(line);
      out.println(result);
    }
  }

  private int solve(int[] comb) {
    int fullRound = 360;
    int toDegree = 360 / 40;
    int totalDeg = 2 * fullRound + Math.floorMod(comb[0] - comb[1], 40) * toDegree + fullRound;
    totalDeg += Math.floorMod(comb[2] - comb[1], 40) * toDegree;
    totalDeg += Math.floorMod(comb[2] - comb[3], 40) * toDegree;
    return totalDeg;
  }

}
