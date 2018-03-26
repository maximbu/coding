package UVA.AdHoc.Games_easy;

import java.util.Scanner;

class Q10189_Minesweeper {

  public static void main(String[] st) {
    Q10189_Minesweeper p = new Q10189_Minesweeper();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int game = 1;
    while (sc.hasNextLine()) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      if (N == 0 & M == 0)
        return;
      sc.nextLine();
      char[][] board = new char[N][M];
      for (int i = 0; i < N; i++) {
        String line = sc.nextLine();
        board[i] = line.toCharArray();
      }
      char[][] ans = solve(board);
      if (game > 1)
        System.out.println();
      System.out.println("Field #" + (game++) + ":");
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          System.out.print(ans[i][j]);
        }
        System.out.println();
      }
    }
  }

  private char[][] solve(char[][] board) {
    char[][] tmp = new char[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '*') {
          tmp[i][j] = '*';
        } else {
          tmp[i][j] = Character.forDigit(countMines(i, j, board), 10);
        }
      }
    }
    return tmp;
  }

  private int countMines(int i, int j, char[][] board) {
    int cnt = 0;
    for (int k = -1; k < 2; k++) {
      for (int l = -1; l < 2; l++) {
        if (i + k >= 0 && i + k < board.length && l + j >= 0 && l + j < board[0].length) {
          if (board[i + k][l + j] == '*') {
            cnt++;
          }
        }
      }
    }
    return cnt;
  }
}
