package UVA.AdHoc.Card;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Q10205_StackEmUp {

  public static void main(String[] st) {
    Q10205_StackEmUp p = new Q10205_StackEmUp();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);

    Map<Character, String> rankMap = createRankMap();
    Map<Character, String> suitMap = createSuitMap();

    int cases = sc.nextInt();
    sc.nextLine();
    sc.nextLine();
    while (cases-- > 0) {
      int shuffleNum = sc.nextInt();
      sc.nextLine();

      int[][] shuffles = new int[shuffleNum][52];

      for (int i = 0; i < shuffleNum; i++) {
        for (int j = 0; j < 52; j++) {
          shuffles[i][j]=sc.nextInt();
        }
        sc.nextLine();
      }

      String[] cards = generateCards();

      String doShuffle = sc.nextLine();
      while (doShuffle.length() > 0)
      {
        int shuffleId = Integer.parseInt(doShuffle)-1;
        doShuffle(shuffles[shuffleId], cards);
        if(!sc.hasNextLine()) break;
        doShuffle = sc.nextLine();
      }

      for (String card : cards) {
        System.out.println(rankMap.get(card.charAt(1)) + " of " + suitMap.get(card.charAt(0)));
      }
      if(cases > 0)
        System.out.println();

    }
  }

  private void doShuffle(int[] shuffle, String[] cards) {

    String[] cardsTmp = new String[52];
    for (int i = 0; i < shuffle.length; i++) {
      cardsTmp[i]= cards[shuffle[i]-1];
    }
    System.arraycopy(cardsTmp, 0, cards, 0, cards.length);
  }

  private String[] generateCards() {
    char[] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    char[] suits = {'C', 'D', 'H','S'};
    String[] cards = new String[52];
    int k=0;
    for (char suit1 : suits) {
      for (char rank : ranks) {
        cards[k++] = "" + suit1 + rank;
      }
    }
    return cards;
  }

  private Map<Character, String> createSuitMap() {
    Map<Character,String> suitMap = new HashMap<>();
    suitMap.put('S',"Spades");
    suitMap.put('C',"Clubs");
    suitMap.put('D',"Diamonds");
    suitMap.put('H',"Hearts");
    return suitMap;
  }

  private Map<Character, String> createRankMap() {
    Map<Character,String> rankMap = new HashMap<>();
    for (int i = 2; i < 10; i++) {
      rankMap.put(Character.forDigit(i, 10),String.valueOf(i));
    }
    rankMap.put('T',"10");
    rankMap.put('J',"Jack");
    rankMap.put('Q',"Queen");
    rankMap.put('K',"King");
    rankMap.put('A',"Ace");
    return rankMap;
  }

}