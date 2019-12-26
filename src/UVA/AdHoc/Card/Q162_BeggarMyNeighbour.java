package UVA.AdHoc.Card;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class Q162_BeggarMyNeighbour {

  public static void main(String[] st) {
    Q162_BeggarMyNeighbour p = new Q162_BeggarMyNeighbour();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    HashMap<Character, Integer> rank = new HashMap<>();
    rank.put('A', 4);
    rank.put('K', 3);
    rank.put('Q', 2);
    rank.put('J', 1);

    while (true) {
      Stack<String> p2 = new Stack<>();
      Stack<String> dealer = new Stack<>();
      for (int i = 0; i < 26; i++) {
        String card = sc.next();
        if (card.equals("#"))
          return;
        p2.push(card);
        dealer.push(sc.next());
      }
      Stack<String> currState = new Stack<>();
      Stack<String> currTurn = p2;
      Stack<String> otherPlayer = dealer;
      while (!currTurn.isEmpty()) {
        String c = currTurn.pop();
        currState.push(c);
        int val = rank.getOrDefault(c.charAt(1), 0);
        while (val > 0) {
          if (otherPlayer.isEmpty())
            break;
          String c2 = otherPlayer.pop();
          currState.push(c2);
          int val2 = rank.getOrDefault(c2.charAt(1), 0);

          if (val2 > 0) {
            val = val2;
            Stack<String> tmp = currTurn;
            currTurn = otherPlayer;
            otherPlayer = tmp;
            continue;
          }
          if (--val == 0) {
            while (!currState.isEmpty()) {
              currTurn.add(0, currState.remove(0));
            }
            Stack<String> tmp = currTurn;
            currTurn = otherPlayer;
            otherPlayer = tmp;
          }
        }
        Stack<String> tmp = currTurn;
        currTurn = otherPlayer;
        otherPlayer = tmp;

      }

      String ans = p2.isEmpty() ? "1 " + String.format("%2d", dealer.size()) : "2 " + String.format("%2d", p2.size());
      System.out.println(ans);
    }
  }
}