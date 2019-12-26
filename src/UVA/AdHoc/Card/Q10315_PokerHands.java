package UVA.AdHoc.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Q10315_PokerHands {

  public static void main(String[] st) {
    Q10315_PokerHands p = new Q10315_PokerHands();
    p.solve();
  }

  public enum HandRank {
    HIGH_CARD(1),
    ONE_PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_A_KIND(8),
    STRAIGHT_FLUSH(9);

    private final int value;

    HandRank(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  private char[] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
  private String BLACK_WINS = "Black wins.";
  private String WHITE_WINS = "White wins.";
  private String TIE = "Tie.";

  private void solve() {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextLine()) {
      String[] cards = sc.nextLine().split("\\s+");

      List<String> black = new ArrayList<>(Arrays.asList(cards).subList(0, 5));
      black.sort(Comparator.comparing(this::valueOfCard).reversed());
      List<String> white = new ArrayList<>(Arrays.asList(cards).subList(5, 10));
      white.sort(Comparator.comparing(this::valueOfCard).reversed());

      HandRank blackRank = analyzeRank(black);
      HandRank whiteRank = analyzeRank(white);

      if (blackRank.getValue() > whiteRank.getValue()) {
        System.out.println(BLACK_WINS);
      }
      if (blackRank.getValue() < whiteRank.getValue()) {
        System.out.println(WHITE_WINS);
      }
      if (blackRank.getValue() == whiteRank.getValue()) {
        System.out.println(handleSameRanks(black, white, blackRank));
      }
    }
  }

  private String handleSameRanks(List<String> black, List<String> white, HandRank rank) {
    switch (rank) {
      case HIGH_CARD:
        return handleHighCard(black, white);
      case ONE_PAIR:
        return handleXOfAKind(black, white, 2);
      case TWO_PAIRS:
        return handleTwoPairs(black, white);
      case THREE_OF_A_KIND:
        return handleXOfAKind(black, white, 3);
      case STRAIGHT:
        return handleHighCard(black, white);
      case FLUSH:
        return handleHighCard(black, white);
      case FULL_HOUSE:
        return handleFullHouse(black, white);
      case FOUR_OF_A_KIND:
        return handleXOfAKind(black, white, 4);
      case STRAIGHT_FLUSH:
        return handleHighCard(black, white);
    }
    return "";
  }

  private String handleTwoPairs(List<String> black, List<String> white) {
    int blackPairRank = findXOfAKindRank(black, 2);
    int whitePairRank = findXOfAKindRank(white, 2);
    if (blackPairRank > whitePairRank)
      return BLACK_WINS;
    if (blackPairRank < whitePairRank)
      return WHITE_WINS;

    List<String> blackLeft = getHandWithoutRank(black, blackPairRank);

    List<String> whiteLeft = getHandWithoutRank(white, whitePairRank);

    return handleXOfAKind(blackLeft, whiteLeft, 2);
  }

  private List<String> getHandWithoutRank(List<String> hand, int rank) {
    return IntStream.range(0, hand.size())
            .filter(i -> valueOfCard(hand.get(i)) != rank).mapToObj(hand::get)
            .collect(Collectors.toList());
  }

  private String handleFullHouse(List<String> black, List<String> white) {
    int blackPairRank = findXOfAKindRank(black, 3);
    int whitePairRank = findXOfAKindRank(white, 3);
    if (blackPairRank > whitePairRank) return BLACK_WINS;
    if (blackPairRank < whitePairRank) return WHITE_WINS;

    blackPairRank = findXOfAKindRank(black, 2);
    whitePairRank = findXOfAKindRank(white, 2);
    if (blackPairRank > whitePairRank) return BLACK_WINS;
    if (blackPairRank < whitePairRank) return WHITE_WINS;

    return TIE;
  }

  private String handleXOfAKind(List<String> black, List<String> white, int x) {
    int blackPairRank = findXOfAKindRank(black, x);
    int whitePairRank = findXOfAKindRank(white, x);
    if (blackPairRank > whitePairRank) return BLACK_WINS;
    if (blackPairRank < whitePairRank) return WHITE_WINS;
    return handleHighCard(black, white);
  }

  private int findXOfAKindRank(List<String> cards, int x) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (String card : cards) {
      int val = valueOfCard(card);
      map.put(val, map.getOrDefault(val, 0) + 1);
    }
    return cards.stream().mapToInt(this::valueOfCard).
            filter(rankVal -> map.get(rankVal) == x)
            .findFirst().orElse(-1);
  }

  private String handleHighCard(List<String> black, List<String> white) {
    for (int i = 0; i < black.size(); i++) {
      if (valueOfCard(black.get(i)) > valueOfCard(white.get(i))) return BLACK_WINS;
      if (valueOfCard(black.get(i)) < valueOfCard(white.get(i))) return WHITE_WINS;
    }
    return TIE;
  }

  private HandRank analyzeRank(List<String> hand) {
    boolean flush = IntStream.range(1, hand.size())
            .noneMatch(i -> hand.get(i).charAt(1) != hand.get(i - 1).charAt(1));
    boolean straight = IntStream.range(1, hand.size())
            .noneMatch(i -> valueOfCard(hand.get(i)) != valueOfCard(hand.get(i - 1)) - 1);

    if (flush && straight)
      return HandRank.STRAIGHT_FLUSH;
    if (findXOfAKindRank(hand, 4) >= 0)
      return HandRank.FOUR_OF_A_KIND;
    if (findXOfAKindRank(hand, 3) >= 0 && findXOfAKindRank(hand, 2) >= 0)
      return HandRank.FULL_HOUSE;
    if (flush)
      return HandRank.FLUSH;
    if (straight)
      return HandRank.STRAIGHT;
    if (findXOfAKindRank(hand, 3) >= 0)
      return HandRank.THREE_OF_A_KIND;
    int twoRank = findXOfAKindRank(hand, 2);
    if (twoRank >= 0 && findXOfAKindRank(getHandWithoutRank(hand, twoRank), 2) >= 0)
      return HandRank.TWO_PAIRS;
    if (twoRank >= 0)
      return HandRank.ONE_PAIR;
    return HandRank.HIGH_CARD;
  }

  private int valueOfCard(String card) {
    return IntStream.range(0, ranks.length).filter(i -> ranks[i] == card.charAt(0)).findFirst().orElse(-1);
  }

}