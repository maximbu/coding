package UVA.Intro.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Q12015_GoogleIsFeelingLucky {

  public static void main(String[] st) {
    Q12015_GoogleIsFeelingLucky p = new Q12015_GoogleIsFeelingLucky();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int numOfTests = sc.nextInt();
    sc.nextLine();
    int caseNum = 1;
    while (numOfTests-- > 0) {
      HashMap<Integer, List<String>> map = new HashMap<>();
      for (int i = 0; i < 10; i++) {
        String[] input = sc.nextLine().split("\\s+");
        int rank = Integer.parseInt(input[1]);
        String site = input[0];
        map.putIfAbsent(rank, new LinkedList<>());
        map.get(rank).add(site);
      }
      int highest = map.keySet().stream().mapToInt(t -> t).max().getAsInt();
      System.out.println("Case #" + (caseNum++) + ":");
      map.get(highest).forEach(System.out::println);
    }
  }
}
