package UVA.AdHoc.Games_harder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q141_TheSpotGame {

  public static void main(String[] st) {
    Q141_TheSpotGame p = new Q141_TheSpotGame();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int N = sc.nextInt();
      if (N == 0) return;
      sc.nextLine();
      int movesNum = 2 * N;
      List<Move> moves = new ArrayList<>();
      while (movesNum-- > 0) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        boolean add = sc.nextLine().trim().equals("+");
        Move m = new Move(x, y, add);
        moves.add(m);
      }
      String ret = solve(N, moves);
      System.out.println(ret);
    }

  }

  private String solve(int N, List<Move> moves) {
    int currPlayer = 1;

    List<Board> seenMoves = new ArrayList<>();
    Board board = new Board(N);

    for (int i = 0; i < moves.size(); i++) {
      Move currMove = moves.get(i);
      board.move(currMove);
      currPlayer = 3 - currPlayer;
      if (seenMoves.contains(board)) {
        return "Player " + currPlayer + " wins on move " + (i + 1);
      }
      seenMoves.add(board.copy());

    }
    return "Draw";
  }

  private class Board {

    private final int n;
    boolean[][] board;

    public Board(int N) {
      n = N;
      board = new boolean[N][N];
    }

    public Board copy() {
      Board nb = new Board(n);
      IntStream.range(0, n)
              .forEach(i -> System.arraycopy(board[i], 0, nb.board[i], 0, n));
      return nb;
    }


    @Override
    public String toString() {
      StringBuilder s = new StringBuilder();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          s.append(board[i][j] ? '*' : '.');
        }
        s.append('|');
      }
      return s.toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Board board1 = (Board) o;
      return same(board, board1.board) ||
              same(board, rotate(board1.board, 1)) ||
              same(board, rotate(board1.board, 2)) ||
              same(board, rotate(board1.board, 3));

    }

    private boolean same(boolean[][] b1, boolean[][] b2) {
      for (int i = 0; i < b1.length; i++) {
        for (int j = 0; j < b1.length; j++) {
          if (b1[i][j] != b2[i][j]) return false;
        }
      }
      return true;
    }

    private boolean[][] rotate(boolean[][] board, int numOf90Rotations) {
      int N = board.length;
      boolean[][] ans = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          boolean val = false;
          switch (numOf90Rotations) {
            case 1: {
              val = board[j][N - i - 1];
              break;
            }
            case 2: {
              val = board[N - i - 1][N - j - 1];
              break;
            }
            case 3: {
              val = board[N - j - 1][i];
              break;
            }
          }
          ans[i][j] = val;
        }
      }
      return ans;
    }


    public void move(Move currMove) {
      board[currMove.x - 1][currMove.y - 1] = currMove.add;
    }
  }

  private class Move {

    private int x;
    private int y;
    private boolean add;

    public Move(int x, int y, boolean add) {
      this.x = x;
      this.y = y;
      this.add = add;
    }

    @Override
    public String toString() {
      return "Move{" +
              "x=" + x +
              ", y=" + y +
              ", add=" + add +
              '}';
    }
  }
}
