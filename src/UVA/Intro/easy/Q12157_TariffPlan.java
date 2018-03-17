package UVA.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q12157_TariffPlan {

  public static void main(String[] st) {
    Q12157_TariffPlan p = new Q12157_TariffPlan();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int numOfTests = sc.nextInt();
    sc.nextLine();
    int caseNum = 1;
    while (numOfTests-- > 0) {
      int numOfCalls = sc.nextInt();
      sc.nextLine();
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      String ans = solve(line);
      System.out.println("Case " + (caseNum++) + ": " + ans);
    }
  }

  private String solve(int[] line) {
    long mile = 0;
    long juice = 0;
    for (int aLine : line) {
      mile += (1 + (aLine / 30)) * 10;
      juice += (1 + (aLine / 60)) * 15;
    }
    if (mile < juice)
      return "Mile " + mile;
    if (juice < mile)
      return "Juice " + juice;
    return "Mile Juice " + mile;
  }
}
