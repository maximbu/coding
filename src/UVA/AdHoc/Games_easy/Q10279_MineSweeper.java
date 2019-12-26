package UVA.AdHoc.Games_easy;

import java.util.Scanner;

class Q10279_MineSweeper {

  public static void main(String[] st) {
    Q10279_MineSweeper p = new Q10279_MineSweeper();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int games = sc.nextInt();
    sc.nextLine();
    int ind = 0;
    while (games-- > 0) {
      sc.nextLine();
      int N = sc.nextInt();
      sc.nextLine();
      char[][] board = new char[N][N];
      for (int i = 0; i < N; i++) {
        String line = sc.nextLine();
        board[i] = line.toCharArray();
      }
      boolean[][] touched = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        String line = sc.nextLine();
        char[] input = line.toCharArray();
        for (int j = 0; j < input.length; j++) {
          touched[i][j] = (input[j] == 'x');
        }
      }
      char[][] ans = solve(board, touched);
      if (ind++ > 0)
        System.out.println();
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          System.out.print(ans[i][j]);
        }
        System.out.println();
      }
    }
  }

  private char[][] solve(char[][] board, boolean[][] touched) {
    char[][] full = fullBoard(board);
    boolean exposeAllBombs = false;
    for (int i = 0; i < touched.length; i++) {
      for (int j = 0; j < touched[i].length; j++) {
        if (touched[i][j]) {
          if (full[i][j] == '*') {
            exposeAllBombs = true;
          }
          if (full[i][j] == '.') {
            full[i][j] = '0';
          }
        } else {
          full[i][j] = '.';
        }
      }
    }
    if (exposeAllBombs) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == '*') {
            full[i][j] = '*';
          }
        }
      }
    }
    return full;
  }

  private char[][] fullBoard(char[][] board) {
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
