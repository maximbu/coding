package UVA.AdHoc.Games_harder;

import java.util.Scanner;
import java.util.stream.IntStream;

class Q10443_RockScissorsPaper {

  public static void main(String[] st) {
    Q10443_RockScissorsPaper p = new Q10443_RockScissorsPaper();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int gamesNum = sc.nextInt();
    while (gamesNum-- > 0) {
      int rows = sc.nextInt();
      int cols = sc.nextInt();
      int iterations = sc.nextInt();
      sc.nextLine();
      char[][] board = new char[rows][cols];
      for (int i = 0; i < rows; i++) {
        board[i] = sc.nextLine().toCharArray();
      }
      solve(board, iterations);
      printBoard(board);
      if (gamesNum > 0) {
        System.out.println();
      }
    }

  }

  private void printBoard(char[][] board) {
    for (char[] row : board) {
      for (char cell : row) {
        System.out.print(cell);
      }
      System.out.println();
    }
  }

  private void solve(char[][] board, int iterations) {
    int rows = board.length;
    int cols = board[0].length;
    for (int iter = 0; iter < iterations; iter++) {
      char[][] newBoard = new char[rows][cols];

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          newBoard[i][j] = handleCell(board, i, j);
        }
      }

      for (int i = 0; i < rows; i++) {
        System.arraycopy(newBoard[i], 0, board[i], 0, cols);
      }
    }
  }

  private char handleCell(char[][] board, int i, int j) {
    char[] options = {'P', 'S', 'R'};
    int ind = IntStream.range(0, 3).filter(k -> options[k] == board[i][j]).findFirst().getAsInt();
    return findNeighbours(board, i, j, options[ind], options[(ind + 1) % 3]);
  }

  private char findNeighbours(char[][] board, int i, int j, char option, char strongerVal) {
    for (int k = -1; k < 2; k++) {
      for (int l = -1; l < 2; l++) {
        if (k == 0 || l == 0) {
          if (k + i < 0 || k + i >= board.length || j + l < 0 || j + l >= board[0].length)
            continue;
          if (board[k + i][j + l] == strongerVal)
            return strongerVal;
        }
      }
    }
    return option;
  }


}
