package UVA.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q10300_EcologicalPremium {

  public static void main(String[] st) {
    Q10300_EcologicalPremium p = new Q10300_EcologicalPremium();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int numOfTests = line[0];
      while (numOfTests-- > 0) {
        input = sc.nextLine().split("\\s+");
        line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int cases = line[0];
        long sum = 0;
        while (cases-- > 0) {
          input = sc.nextLine().split("\\s+");
          line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
          int size = line[0];
          //int numOfAnimals = line[1];
          int score = line[2];
          long payment = (long) size * score;
          sum += payment;
        }
        System.out.println(sum);
      }
    }
  }
}
