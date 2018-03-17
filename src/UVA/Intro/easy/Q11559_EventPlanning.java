package UVA.easy;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

class Q11559_EventPlanning {

  public static void main(String[] st) {
    Q11559_EventPlanning p = new Q11559_EventPlanning();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      int participants = sc.nextInt();
      int budget = sc.nextInt();
      int hotels = sc.nextInt();
      int weeks = sc.nextInt();
      sc.nextLine();
      int[] hotelPrices = new int[hotels];
      int[][] hotelNumOfBedsPerWeek = new int[hotels][weeks];
      for (int i = 0; i < hotels; i++) {
        hotelPrices[i] = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split("\\s+");
        int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(line, 0, hotelNumOfBedsPerWeek[i], 0, weeks);
      }
      Optional<Integer> ans = solve(participants, budget, hotelPrices, hotelNumOfBedsPerWeek);
      System.out.println(ans.isPresent() ? ans.get() : "stay home");
    }
  }

  private Optional<Integer> solve(int participants, int budget, int[] hotelPrices,
      int[][] hotelNumOfBedsPerWeek) {
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < hotelNumOfBedsPerWeek.length; i++) {
      for (int j = 0; j < hotelNumOfBedsPerWeek[0].length; j++) {
        if (hotelNumOfBedsPerWeek[i][j] >= participants) {
          minPrice = Math.min(minPrice, hotelPrices[i] * participants);
          break;
        }
      }
    }
    if (minPrice > budget)
      return Optional.empty();
    return Optional.of(minPrice);
  }

}
