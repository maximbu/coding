package UVA.Intro.medium;

import java.util.Arrays;
import java.util.Scanner;

class Q11683_LaserSculpture {

  public static void main(String[] st) {
    Q11683_LaserSculpture p = new Q11683_LaserSculpture();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      long height = sc.nextInt();
      if (height == 0)
        return;
      long len = sc.nextInt();
      sc.nextLine();
      String[] input = sc.nextLine().split("\\s+");
      long[] line = Arrays.stream(input).mapToLong(Long::parseLong).toArray();
      long ans = solve(height, line);
      System.out.println(ans);
    }
  }

  private long solve(long height, long[] line) {
    long cnt = height - line[0];
    for (int i = 1; i < line.length; i++) {
      if (line[i] < line[i - 1]) {
        cnt += line[i - 1] - line[i];
      }
    }
    return cnt;
  }


}
