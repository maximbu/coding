package UVA.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q12468_Zapping {

  public static void main(String[] st) {
    Q12468_Zapping p = new Q12468_Zapping();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      if(line[0] == -1 && line[1] == -1) return;
      int a = line[0];
      int b = line[1];
      System.out.println(Math.min(Math.floorMod(a - b, 100),Math.floorMod(b - a, 100)));
    }
  }
}
