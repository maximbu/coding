package UVA.Intro.medium;

import java.util.Scanner;

class Q11956_Brainfuck {

  public static void main(String[] st) {
    Q11956_Brainfuck p = new Q11956_Brainfuck();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    int currCase = 1;
    sc.nextLine();
    while (cases-- > 0) {
      String input = sc.nextLine();
      String res = solve(input);
      System.out.println("Case " + (currCase++) + ": " + res);
    }
  }

  private String solve(String input) {
    int[] mem = new int[100];
    char[] commands = input.toCharArray();
    int currPnt = 0;
    for (char command : commands) {
      switch (command) {
        case '>':
          currPnt = (currPnt + 1) % 100;
          break;
        case '<':
          currPnt = (currPnt + 99) % 100;
          break;
        case '+':
          mem[currPnt] = (mem[currPnt] + 1) % 256;
          break;
        case '-':
          mem[currPnt] = (mem[currPnt] + 255) % 256;
          break;
        default:
          break;
      }
    }

    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < mem.length; i++) {
      String hex = Integer.toHexString(mem[i]).toUpperCase();
      if (hex.length() < 2) {
        hex = "0" + hex;
      }
      ans.append(hex);
      if (i < mem.length - 1) {
        ans.append(" ");
      }
    }
    return ans.toString();
  }
}
