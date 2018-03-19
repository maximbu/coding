package UVA.AdHoc.Card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Q11678_CardsExchange {

  public static void main(String[] st) {
    Q11678_CardsExchange p = new Q11678_CardsExchange();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);

    while (!sc.nextLine().equals("0 0")) {
      String[] input = sc.nextLine().split("\\s+");
      Set<Integer> setA = Arrays.stream(input).map(Integer::parseInt)
          .collect(Collectors.toSet());
      input = sc.nextLine().split("\\s+");
      Set<Integer> setB = Arrays.stream(input).map(Integer::parseInt)
          .collect(Collectors.toSet());

      System.out.println(Math.min(getUniqueCount(setB, setA), getUniqueCount(setA, setB)));
    }
  }

  private int getUniqueCount(Set<Integer> from, Set<Integer> setA) {
    HashSet<Integer> tmp = new HashSet<>(setA);
    int cnt = 0;
    for (Integer i : from) {
      if (tmp.add(i)) {
        cnt++;
      }
    }
    return cnt;
  }
}