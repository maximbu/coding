package UVA.AdHoc.Card;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Q10646_WhatIsTheCard {

  public static void main(String[] st) {
    Q10646_WhatIsTheCard p = new Q10646_WhatIsTheCard();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);

    Map<Character, Integer> rankMap = createRankMap();

    int cases = sc.nextInt();
    sc.nextLine();
    int currCase = 0;
    while (currCase++ < cases) {
      String[] cardsInput = sc.nextLine().split("\\s+");
      List<String> cards = Arrays.stream(cardsInput).collect(Collectors.toList());
      Collections.reverse(cards);
      List<String> hand = cards.stream().limit(25).collect(Collectors.toList());
      cards = cards.stream().skip(25).collect(Collectors.toList());
      int Y = 0;
      for (int i = 0; i < 3; i++) {
        String card = cards.get(0);
        int X = rankMap.getOrDefault(card.charAt(0), 10);
        Y += X;
        cards = cards.stream().skip(1 + 10 - X).collect(Collectors.toList());
      }
      for (int i = 24; i >= 0; i--) {
        cards.add(0, hand.get(i));
      }
      String guess = cards.get(cards.size() - Y);
      System.out.println("Case " + currCase + ": " + guess);
    }
  }

  private Map<Character, Integer> createRankMap() {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 2; i < 10; i++) {
      Integer integer = i;
      map.put(Character.forDigit(integer, 10), integer);
    }
    return map;
  }

}