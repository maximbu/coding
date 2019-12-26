package UVA.AdHoc.Games_harder;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q10363_TicTacToe {

  private static boolean DEBUG = false;

  public static void main(String[] st) {
    Q10363_TicTacToe p = new Q10363_TicTacToe();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    while (n-- > 0) {
      char[][] board = new char[3][3];
      for (int i = 0; i < 3; i++) {
        board[i] = sc.nextLine().toCharArray();
      }

      if (DEBUG) {
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            out.print(board[i][j]);
          }
          out.println();
        }
        out.println();
      }
      if (n > 0) {
        sc.nextLine();
      }
      boolean result = solve(board);
      if (!DEBUG) {
        out.println(result ? "yes" : "no");
      }
    }
  }

  private boolean solve(char[][] board) {
    int xCnt = 0;
    int oCnt = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == 'X') {
          xCnt++;
        }
        if (board[i][j] == 'O') {
          oCnt++;
        }
      }
    }
    int xDiff = xCnt - oCnt;
    if ((xDiff != 0) && (xDiff != 1)) {
      return false;
    }
    char[] same = checkWins(board);

    char winner = 0;
    for (int i = 0; i < 8; i++) {
      if (same[i] != 0) {
        {
          if (winner != 0 && winner != same[i]) {
            return false;
          }
          winner = same[i];
        }
      }
    }
    if (same[0] != 0 && same[0] == same[1]) {
      return false;
    }
    if (same[0] != 0 && same[0] == same[2]) {
      return false;
    }
    if (same[1] != 0 && same[1] == same[2]) {
      return false;
    }
    if (same[3] != 0 && same[3] == same[4]) {
      return false;
    }
    if (same[3] != 0 && same[3] == same[5]) {
      return false;
    }
    if (same[4] != 0 && same[4] == same[5]) {
      return false;
    }

    return !(winner == 'O' && xDiff == 1 || winner == 'X' && xDiff == 0);
  }

  private char[] checkWins(char[][] board) {
    char[] same = new char[8];
    if (board[0][0] != '.' && board[0][0] == board[0][1] && board[0][1] == board[0][2])
      same[0] = board[0][0];
    if (board[1][0] != '.' && board[1][0] == board[1][1] && board[1][1] == board[1][2])
      same[1] = board[1][0];
    if (board[2][0] != '.' && board[2][0] == board[2][1] && board[2][1] == board[2][2])
      same[2] = board[2][0];
    if (board[0][0] != '.' && board[0][0] == board[1][0] && board[1][0] == board[2][0])
      same[3] = board[0][0];
    if (board[0][1] != '.' && board[0][1] == board[1][1] && board[1][1] == board[2][1])
      same[4] = board[0][1];
    if (board[0][2] != '.' && board[0][2] == board[1][2] && board[1][2] == board[2][2])
      same[5] = board[0][2];
    if (board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
      same[6] = board[0][0];
    if (board[0][2] != '.' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
      same[7] = board[0][2];
    return same;
  }


}
