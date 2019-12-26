package UVA.AdHoc.Games_harder;

import java.util.Scanner;

class Q232_CrosswordAnswers {

  public static void main(String[] st) {
    Q232_CrosswordAnswers p = new Q232_CrosswordAnswers();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int puzzleNum = 1;
    while (true) {
      int rows = sc.nextInt();
      if (rows == 0) return;
      int cols = sc.nextInt();
      sc.nextLine();
      char[][] board = new char[rows][cols];
      for (int i = 0; i < rows; i++) {
        board[i] = sc.nextLine().toCharArray();
      }
      if (puzzleNum > 1) {
        System.out.println();
      }
      System.out.printf("puzzle #%d:%n", puzzleNum++);
      printBoard(board);
    }

  }

  private void printBoard(char[][] board) {
    int[][] numbers = new int[board.length][board[0].length];
    int currNum = 1;
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (board[r][c] != '*' && (r == 0 || c == 0 || board[r - 1][c] == '*' || board[r][c - 1] == '*')) {
          numbers[r][c] = currNum++;
        }
      }
    }
    System.out.println("Across");
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (numbers[r][c] != 0) {
          System.out.printf(" %2d.", numbers[r][c]);
          while (c < board[r].length && board[r][c] != '*') {
            System.out.print(board[r][c]);
            c++;
          }
          System.out.println();
        }
      }
    }
    System.out.println("Down");
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (numbers[r][c] != 0) {
          System.out.printf(" %2d.", numbers[r][c]);
          int t = r;
          while (t < board.length && board[t][c] != '*') {
            System.out.print(board[t][c]);
            numbers[t][c] = 0;
            t++;
          }
          System.out.println();
        }
      }
    }
  }


}
