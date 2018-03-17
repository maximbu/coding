package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

class Q11498_DivisionOfNlogonia {

  public static void main(String[] st) {
    Q11498_DivisionOfNlogonia p = new Q11498_DivisionOfNlogonia();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    while (true) {
      int n = sc.nextInt();
      if(n == 0) return;
      sc.nextLine();
      int[] divPoint = null;
      while(n-- >= 0) {
        String[] input = sc.nextLine().split("\\s+");
        int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        if(divPoint == null){
          divPoint = line;
          continue;
        }
        String result = solve(divPoint , line);
        out.println(result);
      }
    }
  }

  private String solve(int[] divPoint , int[] line) {
    if(divPoint[0] == line[0] || divPoint[1] == line[1]) return "divisa";
    if(divPoint[0] < line[0] && divPoint[1] < line[1]) return "NE";
    if(divPoint[0] < line[0] && divPoint[1] > line[1]) return "SE";
    if(divPoint[0] > line[0] && divPoint[1] > line[1]) return "SO";
    return "NO";
  }

}
