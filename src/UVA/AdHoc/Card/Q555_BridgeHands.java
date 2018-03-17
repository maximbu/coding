package UVA.AdHoc.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q555_BridgeHands {

  public static void main(String[] st) {
    Q555_BridgeHands p = new Q555_BridgeHands();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    char[] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    char[] suits = {'C', 'D', 'S', 'H'};
    char[] dir = {'S', 'W', 'N', 'E'};
    List<String>[] cards = (List<String>[]) new List[4];

    while (sc.hasNextLine()) {
      String dealer = sc.nextLine();
      if (dealer.equals("#"))
        return;
      int currPlayer = (indexOf(dir, dealer.charAt(0)) + 1) % 4;

      for (int i = 0; i < 4; i++) {
        cards[i] = new ArrayList<>();
      }

      for (int i = 0; i < 2; i++) {
        String input = sc.nextLine();
        List<String> inputCards = splitEqually(input);
        for (String card : inputCards) {
          cards[currPlayer].add(card);
          currPlayer = (currPlayer + 1) % 4;
        }
      }

      for (int i = 0; i < 4; i++) {
        cards[i].sort(Comparator.comparing(t -> indexOf(suits, t.toString().charAt(0)))
            .thenComparing(t -> indexOf(ranks, t.toString().charAt(1))));
        System.out.print(dir[i] + ":");
        for (String card : cards[i]) {
          System.out.print(" " + card);
        }
        System.out.println();
      }
    }
  }

  private static int indexOf(char[] arr, char val) {
    return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
  }

  private List<String> splitEqually(String text) {
    List<String> ret = new ArrayList<>();
    for (int start = 0; start < text.length(); start += 2) {
      ret.add(text.substring(start, Math.min(text.length(), start + 2)));
    }
    return ret;
  }
}