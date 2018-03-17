package UVA.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q12503_RobotInstructions {

  public static void main(String[] st) {
    Q12503_RobotInstructions p = new Q12503_RobotInstructions();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int numOfTests = sc.nextInt();
    sc.nextLine();
    while (numOfTests-- > 0) {
      int numOfCommands = sc.nextInt();
      sc.nextLine();
      int i = 1;
      int[] moves = new int[numOfCommands + 1];
      for (int j = 0; j < numOfCommands; j++) {
        String[] input = sc.nextLine().split("\\s+");
        switch (input[0]) {
          case "LEFT":
            moves[i] = -1;
            break;
          case "RIGHT":
            moves[i] = 1;
            break;
          default:
            moves[i] = moves[Integer.parseInt(input[2])];
            break;
        }
        i++;
      }
      System.out.println(Arrays.stream(moves).sum());
    }
  }
}
