package UVA.AdHoc.Games_harder;

import java.util.Arrays;
import java.util.Scanner;

class Q10813_TraditionalBINGO {

  public static void main(String[] st) {
    Q10813_TraditionalBINGO p = new Q10813_TraditionalBINGO();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int gamesNum = sc.nextInt();
    while (gamesNum-- > 0) {
      int[][] board = readBoard(sc);
      boolean done = false;
      for (int i = 0; i < 75; i++) {
        int ball = sc.nextInt();
        if (!done && markBoard(board, ball) && won(board)) {
          System.out.println("BINGO after " + (i + 1) + " numbers announced");
          done = true;
        }
      }
    }
  }

  private int[][] readBoard(Scanner sc) {
    int[][] board = new int[5][5];
    for (int i = 0; i < 5; i++) {
      String line = sc.nextLine();
      if (line.trim().length() == 0) {
        i--;
        continue;
      }
      String[] input = line.split("\\s+");
      board[i] = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
    }
    int[] special = new int[5];
    for (int i = 0; i < 4; i++) {
      int out = i > 1 ? i + 1 : i;
      special[out] = board[2][i];
    }
    board[2] = special;
    return board;
  }

  private boolean won(int[][] board) {
    for (int[] row : board) {
      if (Arrays.stream(row).sum() == 0) {
        return true;
      }
    }
    for (int col = 0; col < board[0].length; col++) {
      int sum = 0;
      for (int[] row : board) {
        sum += row[col];
      }
      if (sum == 0)
        return true;
    }
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += board[i][i];
    }
    if (sum == 0) return true;
    sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += board[i][5 - i - 1];
    }
    if (sum == 0) return true;
    return false;
  }

  private boolean markBoard(int[][] board, int ball) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == ball) {
          board[i][j] = 0;
          return true;
        }
      }
    }
    return false;
  }


}
