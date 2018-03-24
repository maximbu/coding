package UVA.AdHoc.Games_easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Q340_MasterMindHints {

  public static void main(String[] st) {
    Q340_MasterMindHints p = new Q340_MasterMindHints();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int game = 1;
    while (true) {
      int N = sc.nextInt();
      if (N == 0) {
        return;
      }
      sc.nextLine();
      String[] input = sc.nextLine().split("\\s+");
      int[] cypher = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      System.out.println("Game " + (game++) + ":");
      while (true) {
        input = sc.nextLine().split("\\s+");
        int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        if (Arrays.stream(line).sum() == 0)
          break;
        String ans = solve(cypher , line);
        System.out.println(ans);
      }
    }
  }

  private String solve(int[] cypher, int[] line) {
    int strong = 0;
    Set<Integer> usedCypher = new HashSet<>();
    Set<Integer> usedLine = new HashSet<>();
    for (int i = 0; i < cypher.length; i++) {
      if (cypher[i] == line[i]) {
        strong++;
        usedCypher.add(i);
        usedLine.add(i);
      }
    }

    int weak = 0;
    for (int i = 0; i < cypher.length; i++) {
      for (int j = 0; j < line.length; j++) {
        if (cypher[i] == line[j] && !usedCypher.contains(i) && !usedLine.contains(j)) {
          weak++;
          usedCypher.add(i);
          usedLine.add(j);
          break;
        }
      }
    }

    return String.format("    (%d,%d)", strong, weak);
  }




}
