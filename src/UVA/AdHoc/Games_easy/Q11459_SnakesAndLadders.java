package UVA.AdHoc.Games_easy;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q11459_SnakesAndLadders {

  public static void main(String[] st) {
    Q11459_SnakesAndLadders p = new Q11459_SnakesAndLadders();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    sc.nextLine();
    while (cases-- > 0) {
      int playersNum = sc.nextInt();
      int laddersNum = sc.nextInt();
      int dieRollsNum = sc.nextInt();
      HashMap<Integer, Integer> ladders = new HashMap<>();
      while (laddersNum-- > 0) {
        int from = sc.nextInt();
        int to = sc.nextInt();
        ladders.put(from, to);
        sc.nextLine();
      }
      int[] dieRolls = new int[dieRollsNum];
      int curr = 0;
      while (curr < dieRollsNum) {
        int die = sc.nextInt();
        dieRolls[curr++] = die;
        sc.nextLine();
      }
      int[] ans = solve(playersNum, ladders, dieRolls);
      for (int i = 0; i < ans.length; i++) {
        System.out.println("Position of player " + (i + 1) + " is " + ans[i] + ".");
      }
    }
  }

  private int[] solve(int playersNum, HashMap<Integer, Integer> ladders, int[] dieRolls) {
    int[] players = IntStream.range(0, playersNum).map(i -> 1).toArray();
    int currPlayer = 0;
    if (playersNum < 1) return players;
    for (int dieRoll : dieRolls) {
      players[currPlayer] += dieRoll;
      if (ladders.containsKey(players[currPlayer])) {
        players[currPlayer] = ladders.get(players[currPlayer]);
      }
      if (players[currPlayer] >= 100) {
        players[currPlayer] = 100;
        return players;
      }
      currPlayer = (currPlayer + 1) % playersNum;
    }
    return players;
  }

}
