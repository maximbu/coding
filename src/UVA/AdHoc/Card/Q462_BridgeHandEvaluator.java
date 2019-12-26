package UVA.AdHoc.Card;

import java.util.HashMap;
import java.util.Scanner;

class Q462_BridgeHandEvaluator {

  public static void main(String[] st) {
    Q462_BridgeHandEvaluator p = new Q462_BridgeHandEvaluator();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    char[] suits = {'S', 'H', 'D', 'C'};
    HashMap<Character, Integer> rankScore = new HashMap<>();
    rankScore.put('A', 4);
    rankScore.put('K', 3);
    rankScore.put('Q', 2);
    rankScore.put('J', 1);

    while (sc.hasNextLine()) {
      String[] cards = sc.nextLine().split("\\s+");
      HashMap<Character, Integer> rankCount = new HashMap<>();
      HashMap<Character, Integer> suitCount = new HashMap<>();
      HashMap<Character, Integer> highestSuit = new HashMap<>();

      int score = 0;

      for (String card : cards) {
        char rank = card.charAt(0);
        char suit = card.charAt(1);
        score += rankScore.getOrDefault(rank, 0);
        rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        highestSuit.put(suit, Math.max(rankScore.getOrDefault(rank, 0)
                , highestSuit.getOrDefault(suit, 0)));
      }

      for (String card : cards) {
        char rank = card.charAt(0);
        char suit = card.charAt(1);
        int val = rankScore.getOrDefault(rank, 0);
        if (val > 0) {
          if (suitCount.get(suit) < 5 - val) {
            score--;
          }
        }
      }

      int stoppedScore = score;
      boolean allStopped = (suitCount.keySet().size() == 4);
      for (Character suit : suits) {
        int suitVal = suitCount.getOrDefault(suit, 0);
        if (suitVal == 2)
          score += 1;
        if (suitVal < 2)
          score += 2;

        int suitAmount = highestSuit.getOrDefault(suit, 0);
        if (suitAmount < 2)
          allStopped = false;
        if (suitAmount == 2) {
          allStopped = allStopped && (suitCount.get(suit) > 2);
        }
        if (suitAmount == 3) {
          allStopped = allStopped && (suitCount.get(suit) > 1);
        }
      }

      if (allStopped && stoppedScore > 15) {
        System.out.println("BID NO-TRUMP");
      } else if (score > 13) {
        char bidSuit = ' ';
        int bidSuitVal = 0;
        for (char suit : suits) {
          int suitVal = suitCount.getOrDefault(suit, 0);
          if (suitVal > bidSuitVal) {
            bidSuit = suit;
            bidSuitVal = suitVal;
          }
        }
        System.out.println("BID " + bidSuit);
      } else {
        System.out.println("PASS");
      }
    }
  }

}