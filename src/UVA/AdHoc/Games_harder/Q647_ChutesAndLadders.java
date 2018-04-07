package UVA.AdHoc.Games_harder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Q647_ChutesAndLadders {

  public static void main(String[] st) {
    Q647_ChutesAndLadders p = new Q647_ChutesAndLadders();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    List<Integer> rolls = new ArrayList<>();
    while (true) {
      int r = sc.nextInt();
      if (r == 0)
        break;
      rolls.add(r);
    }
    sc.nextLine();
    while (true) {
      int playersNum = Integer.valueOf(sc.nextLine());
      if (playersNum == 0)
        return;
      HashMap<Integer, Integer> ladders = new HashMap<>();
      while (true) {
        int from = sc.nextInt();
        int to = sc.nextInt();
        sc.nextLine();
        if (from == 0 && to == 0)
          break;
        ladders.put(from, to);
      }

      HashSet<Integer> extraTurns = new HashSet<>();
      HashSet<Integer> skipTurns = new HashSet<>();
      while (true) {
        int cell = Integer.valueOf(sc.nextLine());
        if (cell == 0)
          break;
        if (cell > 0) {
          extraTurns.add(cell);
        } else {
          skipTurns.add(-1 * cell);
        }
      }
      int ans = solve(rolls, playersNum, ladders, extraTurns, skipTurns);
      System.out.println(ans);
    }
  }

  private int solve(List<Integer> rolls, int playersNum, HashMap<Integer, Integer> ladders,
      HashSet<Integer> extraTurns, HashSet<Integer> skipTurns) {
    int[] players = new int[playersNum];
    boolean[] skipTurn = new boolean[playersNum];
    int currPlayer = 0;
    for (int dieRoll : rolls) {
      if (skipTurn[currPlayer]) {
        skipTurn[currPlayer] = false;
      } else {
        players[currPlayer] += dieRoll;
        if (ladders.containsKey(players[currPlayer])) {
          players[currPlayer] = ladders.get(players[currPlayer]);
        }

        if (players[currPlayer] == 100)
          return currPlayer + 1;

        if (players[currPlayer] > 100) {
          players[currPlayer] -= dieRoll;
        }

        if (skipTurns.contains(players[currPlayer])) {
          skipTurn[currPlayer] = true;

        }
      }
      if (!extraTurns.contains(players[currPlayer])) {
        currPlayer = (currPlayer + 1) % playersNum;
      }
    }
    return -1;
  }

}
