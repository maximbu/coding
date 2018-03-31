package UVA.AdHoc.Games_harder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q339_SameGameSimulation {

  public static final int EMPTY = -1;

  public static void main(String[] st) {
    Q339_SameGameSimulation p = new Q339_SameGameSimulation();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int gamesNum = 1;
    while (true) {
      int M = sc.nextInt();
      int N = sc.nextInt();
      if (M == 0 || N == 0) {
        return;
      }
      sc.nextLine();
      int[][] board = new int[M][N];
      for (int i = M - 1; i >= 0; i--) {
        String[] input = sc.nextLine().split("\\s+");
        int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        board[i] = line;
      }

      List<Move> moves = new ArrayList<>();
      while (true) {
        int x = M - sc.nextInt();
        int y = sc.nextInt() - 1;
        if (x == M && y == -1) {
          break;
        }
        if (x >= M || y >= N || x < 0 || y < 0)
          continue;
        Move m = new Move(x, y);
        moves.add(m);
      }
      sc.nextLine();
      boolean valid = makeMoves(board, moves);
      if (gamesNum > 1) {
        System.out.println();
      }
      System.out.println("Grid " + (gamesNum++) + ".");
      if (!valid) {
        printBoard(board);
      } else {
        System.out.println("    Game Won");
      }
    }

  }

  private boolean makeMoves(int[][] board, List<Move> moves) {
    for (Move move : moves) {
      makeMove(move, board);
      if (isEmpty(board)) {
        return true;
      }
    }
    return false;
  }

  private void makeMove(Move move, int[][] board) {
    int val = board[move.x][move.y];
    if (val == EMPTY) return;
    if (hasNeighbours(move.x,move.y,board)){
      remove(board,move.x,move.y,val);
      shrink(board);
    }
  }

  private boolean hasNeighbours(int x, int y, int[][] board) {
    int val = board[x][y];
    if(x+1 < board.length && board[x+1][y] == val) return true;
    if(y+1 < board[0].length && board[x][y+1] == val) return true;
    if(y-1 >= 0 && board[x][y-1] == val) return true;
    if(x-1 >= 0 && board[x-1][y] == val) return true;
    return false;
  }

  private void shrink(int[][] board) {
    for (int col = 0; col < board[0].length; col++) {
      for (int row = 1; row <= board.length - 1; row++) {
        int currRow = row;
        while (board[currRow][col] == EMPTY && currRow>0) {
          board[currRow][col] = board[currRow - 1][col];
          board[currRow - 1][col] = EMPTY;
          currRow--;
        }
      }
    }

    for (int col = board[0].length - 2; col > -1; col--) {
      int currCol = col;
      while(emptyCol(board,currCol) && currCol < board[0].length-1){
        moveCol(board,currCol+1);
        currCol++;
      }
    }

  }

  private void moveCol(int[][] board, int col) {
    for (int i = 0; i < board.length; i++) {
      board[i][col - 1] = board[i][col];
      board[i][col] = EMPTY;
    }
  }

  private boolean emptyCol(int[][] board, int col) {
    return IntStream.range(0, board.length).noneMatch(i -> board[i][col] != EMPTY);
  }

  private void remove(int[][] board, int x, int y, int val) {
    if (x < 0 || y < 0 || x > board.length-1 || y > board[0].length-1)
      return;
    if (board[x][y] != val)
      return;
    board[x][y] = EMPTY;
    remove(board, x + 1, y, val);
    remove(board, x - 1, y, val);
    remove(board, x, y + 1, val);
    remove(board, x, y - 1, val);
  }

  private boolean isEmpty(int[][] board) {
    for (int[] row : board) {
      for (int cell : row) {
        if (cell != EMPTY) {
          return false;
        }
      }
    }
    return true;
  }

  private void printBoard(int[][] board) {
    for (int[] row : board) {
      System.out.print("    ");
      for (int i = 0; i < row.length; i++) {
        if(i>0) System.out.print(" ");
        if (row[i] == EMPTY) {
          System.out.print(" ");
        }
        else {
          System.out.print(row[i]);
        }
      }
      System.out.println();
    }
  }


  private class Move {
    private int x;
    private int y;

    public Move(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Move{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
