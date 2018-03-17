package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

class Q11044_SearchingForNessy {

  public static void main(String[] st){
    Q11044_SearchingForNessy p = new Q11044_SearchingForNessy();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    while(n-- > 0){
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println(result);
    }
  }

  private int solve(int[] line) {
    return (line[0]/3)*(line[1]/3);
  }
}
