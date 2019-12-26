package UVA.AdHoc.Palindrome;

import java.util.Scanner;

import static java.lang.System.in;

class Q11221_MagicSquarePalindromes {

  public static void main(String[] st) {
    Q11221_MagicSquarePalindromes p = new Q11221_MagicSquarePalindromes();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int cases = Integer.parseInt(sc.nextLine());
    int c = 0;
    while (c++ < cases) {
      String input = sc.nextLine().trim();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < input.length(); i++) {
        if (Character.isLetter(input.charAt(i))) {
          sb.append(Character.toLowerCase(input.charAt(i)));
        }
      }
      int ans = magicSquareSize(sb.toString());
      System.out.println("Case #" + c + ":");
      System.out.println(ans > -1 ? ans : "No magic :(");
    }
  }

  private int magicSquareSize(String s) {
    int len = s.length();
    int sqSize = (int) Math.sqrt(len);
    char[][] sq = new char[sqSize][sqSize];
    char[] chars = s.toCharArray();
    int ind = 0;
    for (int i = 0; i < sqSize; i++) {
      for (int j = 0; j < sqSize; j++) {
        sq[i][j] = chars[ind++];
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = sqSize - 1; i >= 0; i--) {
      for (int j = sqSize - 1; j >= 0; j--) {
        sb.append(sq[i][j]);
      }
    }
    if (!sb.toString().equals(s))
      return -1;
    sb = new StringBuilder();
    for (int i = sqSize - 1; i >= 0; i--) {
      for (int j = sqSize - 1; j >= 0; j--) {
        sb.append(sq[j][i]);
      }
    }
    if (!sb.toString().equals(s))
      return -1;
    sb = new StringBuilder();
    for (int i = 0; i < sqSize; i++) {
      for (int j = 0; j < sqSize; j++) {
        sb.append(sq[j][i]);
      }
    }
    if (!sb.toString().equals(s))
      return -1;
    return sqSize;
  }

}
