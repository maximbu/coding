package UVA.Intro.medium;

import java.util.Arrays;
import java.util.Scanner;

class Q573_TheSnail {

  public static void main(String[] st) {
    Q573_TheSnail p = new Q573_TheSnail();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      if (line[0] == 0)
        return;
      String ans = solve(line);
      System.out.println(ans);
    }
  }

  private String solve(int[] line) {
    int day = 0;
    int height = line[0];
    int distancePerDay = line[1];
    int slidePerNight = line[2];
    int fatigue = line[3];
    double currPos = 0;
    double totalFatigue = 0;
    while (true) {
      day++;

      currPos += Math.max(0, distancePerDay - totalFatigue);

      if (currPos > height)
        return "success on day " + day;

      currPos -= slidePerNight;

      if (currPos < 0)
        return "failure on day " + day;

      totalFatigue += distancePerDay * fatigue / 100.0;
    }
  }
}
