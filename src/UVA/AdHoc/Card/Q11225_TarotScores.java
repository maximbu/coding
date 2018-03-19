package UVA.AdHoc.Card;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Q11225_TarotScores {

  public static void main(String[] st) {
    Q11225_TarotScores p = new Q11225_TarotScores();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);

    int cases = sc.nextInt();
    sc.nextLine();
    int currCase = 0;
    List<String> oudlers = Arrays.asList("fool", "twenty-one of trumps", "one of trumps");
    Map<String, Double> cardValue = new HashMap<>();
    cardValue.put("king", 4.5);
    cardValue.put("queen", 3.5);
    cardValue.put("knight", 2.5);
    cardValue.put("jack", 1.5);
    Map<Integer, Integer> oudlersToPoints = new HashMap<>();
    oudlersToPoints.put(3, 36);
    oudlersToPoints.put(2, 41);
    oudlersToPoints.put(1, 51);
    oudlersToPoints.put(0, 56);
    while (currCase++ < cases) {
      int cards = sc.nextInt();
      sc.nextLine();
      double score = 0;
      int oudlersCount = 0;
      for (int i = 0; i < cards; i++) {
        String card = sc.nextLine();
        if (oudlers.contains(card)) {
          oudlersCount++;
          score += 4.5;
        } else {
          String rank = card.split("\\s+")[0];
          score += cardValue.getOrDefault(rank, 0.5);
        }
      }
      int wonBy = (int) score - oudlersToPoints.get(oudlersCount);

      if (currCase > 1) {
        System.out.println();
      }
      System.out.println("Hand #" + currCase);
      System.out.println(
          "Game " + (wonBy < 0 ? "lost" : "won") + " by " + Math.abs(wonBy) + " point(s).");
    }
  }

}