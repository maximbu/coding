package UVA.AdHoc.Games_harder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q379_HiQ {

  public static void main(String[] st) {
    Q379_HiQ p = new Q379_HiQ();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int gamesNum = sc.nextInt();
    System.out.println("HI Q OUTPUT");
    List<Integer> game = new ArrayList<>();
    while (gamesNum > 0) {
      int x = sc.nextInt();
      if (x != 0) {
        game.add(x);
      } else {
        int ans = simulate(game);
        System.out.println(ans);
        game = new ArrayList<>();
        gamesNum--;
      }
    }
    System.out.println("END OF OUTPUT");

  }

  private int simulate(List<Integer> game) {
    boolean[][] board = new boolean[7][7];
    for (Integer pin : game) {
      Cell c = pinToCell(pin);
      board[c.row][c.col] = true;
    }
    while (true) {
      Cell c = getSourceCell(board);
      if (c == null) break;
      Cell target = canMoveTo(board, c.row, c.col);
      if (target == null) break;
      board[(c.row + target.row) / 2][(c.col + target.col) / 2] = false;
      board[c.row][c.col] = false;
      board[target.row][target.col] = true;
    }
    int sum = 0;
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (board[i][j]) {
          sum += cellToPin(i, j);
        }
      }
    }
    return sum;

  }

  private Cell getSourceCell(boolean[][] board) {
    Cell bestSource = null;
    Cell bestTarget = null;
    for (int row = 6; row >= 0; row--) {
      for (int col = 6; col >= 0; col--) {
        Cell move = canMoveTo(board, row, col);
        if (move != null) {
          if (bestTarget == null || cellToPin(bestTarget.row, bestTarget.col) < cellToPin(move.row, move.col)) {
            bestSource = new Cell(row, col);
            bestTarget = move;
          }
        }
      }
    }
    return bestSource;

  }

  private boolean isValid(int row, int col) {
    if (row < 0 || col < 0 || row > 6 || col > 6) return false;
    if ((row == 0 || row == 1 || row == 5 || row == 6)
            && (col == 0 || col == 1 || col == 5 || col == 6)) return false;
    return true;
  }

  private Cell canMoveTo(boolean[][] board, int row, int col) {
    if (!isValid(row, col) || !board[row][col]) return null;
    if (isValid(row + 2, col) && !board[row + 2][col] && board[row + 1][col]) return new Cell(row + 2, col);
    if (isValid(row, col + 2) && !board[row][col + 2] && board[row][col + 1]) return new Cell(row, col + 2);
    if (isValid(row, col - 2) && !board[row][col - 2] && board[row][col - 1]) return new Cell(row, col - 2);
    if (isValid(row - 2, col) && !board[row - 2][col] && board[row - 1][col]) return new Cell(row - 2, col);
    return null;
  }

  private Cell pinToCell(int pin) {
    pin--;
    for (int r = 0; r < 7; r++) {
      for (int c = 0; c < 7; c++) {
        if (!isValid(r, c)) continue;
        if (pin == 0) {
          return new Cell(r, c);
        }
        pin--;
      }
    }
    return null;
  }

  private int cellToPin(int row, int col) {
    int pin = 0;
    for (int r = 0; r <= 7; r++) {
      for (int c = 0; c <= 7; c++) {
        if (!isValid(r, c))
          continue;
        pin++;
        if (r == row && c == col)
          return pin;
      }
    }
    return pin;
  }


  private class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public String toString() {
      return "" + cellToPin(row, col);
    }
  }


}
