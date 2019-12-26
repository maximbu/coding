package UVA.Intro.medium;

import java.util.Scanner;

class Q10324_ZerosAndOnes {

  public static void main(String[] st) {
    Q10324_ZerosAndOnes p = new Q10324_ZerosAndOnes();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int caseNum = 1;
    while (sc.hasNextLine()) {
      String input = sc.nextLine();
      if (input.length() == 0)
        return;
      char[] chars = input.toCharArray();
      int[] changes = new int[chars.length];
      int c = 0;
      for (int i = 1; i < chars.length; i++) {
        if (chars[i] != chars[i - 1]) {
          c++;
        }
        changes[i] = c;
      }
      int cases = sc.nextInt();
      sc.nextLine();
      System.out.println("Case " + (caseNum++) + ":");
      for (int i = 0; i < cases; i++) {
        int ind1 = sc.nextInt();
        int ind2 = sc.nextInt();
        sc.nextLine();
        if (changes[Math.min(ind1, ind2)] == changes[Math.max(ind1, ind2)]) {
          System.out.println("Yes");
        } else {
          System.out.println("No");
        }
      }
    }
  }

}
