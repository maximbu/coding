package UVA.AdHoc.Chess;

import java.util.Scanner;
import java.util.stream.IntStream;

class Main {

  public static void main(String[] st) {
    Main p = new Main();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int caseNum = 1;
    while (true) {
      char board[] = new char[64];
      for (int rowIndex = 0; rowIndex < 8; rowIndex++) {
        char[] row = sc.next().toCharArray();
        System.arraycopy(row, 0, board, rowIndex * 8, 8);
      }
      if (isEmpty(board)) {
        return;
      }
      int ans = solve(board);
      String king = (ans == 0 ? "no" : ans > 0 ? "white" : "black");
      System.out.println("Game #" + (caseNum++) + ": " + king + " king is in check.");
    }
  }

  private int solve(char[] board) {
    if (isUnderCheck(board, true))
      return 1;
    if (isUnderCheck(board, false))
      return -1;
    return 0;
  }

  private boolean isUnderCheck(char[] board, boolean white) {
    int kingCell = IntStream.range(0, board.length).filter(i -> board[i] == (white ? 'K' : 'k'))
        .findFirst().getAsInt();
    for (int i = 0; i < board.length; i++) {
      if ((white && Character.isLowerCase(board[i])) || (!white && Character
          .isUpperCase(board[i]))) {
        if (isThreatens(i, kingCell, board))
          return true;
      }
    }
    return false;
  }

  private boolean isThreatens(int attackerCell, int attackedCell, char[] board) {
    switch (Character.toLowerCase(board[attackerCell])) {
      case 'p': {
        return pawnThreatens(attackerCell, attackedCell, board);
      }
      case 'n': {
        return knightThreatens(attackerCell, attackedCell);
      }
      case 'b': {
        return bishopThreatens(attackerCell, attackedCell, board);
      }
      case 'r': {
        return rookThreatens(attackerCell, attackedCell, board);
      }
      case 'q': {
        return queenThreatens(attackerCell, attackedCell, board);
      }
      default:
        return kingThreatens(attackerCell, attackedCell, board);
    }
  }

  private boolean kingThreatens(int attackerCell, int attackedCell, char[] board) {
    int rowDiff = Math.abs(attackedCell/8 - attackerCell/8);
    int colDiff = Math.abs(attackedCell%8 - attackerCell%8);
    return rowDiff <= 1 && colDiff <= 1;
  }

  private boolean pawnThreatens(int attackerCell, int attackedCell, char[] board) {
    int diff = attackerCell - attackedCell;
    if (Character.isUpperCase(board[attackerCell])) {
      diff = attackedCell - attackerCell;

    }
    return (diff == 9 || diff == 7);
  }

  private boolean knightThreatens(int attackerCell, int attackedCell) {
    int rowDiff = Math.abs(attackerCell/8-attackedCell/8);
    int colDiff = Math.abs(attackerCell%8-attackedCell%8);
    return (rowDiff+colDiff==3) && (rowDiff*colDiff==2);
  }

  private boolean queenThreatens(int attackerCell, int attackedCell, char[] board) {
    return rookThreatens(attackerCell, attackedCell, board) || bishopThreatens(attackerCell, attackedCell,
        board);
  }

  private boolean bishopThreatens(int attackerCell, int attackedCell, char[] board) {
    boolean sameLeftDiagonal = ((attackerCell / 8 - attackedCell / 8) == (attackerCell % 8
        - attackedCell % 8));
    boolean sameRightDiagonal = ((attackerCell / 8 - attackedCell / 8) == -1 * (attackerCell % 8
        - attackedCell % 8));
    if (sameLeftDiagonal) {
      return hasFreeAttackLine(attackerCell, attackedCell, board, 9);
    }
    return sameRightDiagonal && hasFreeAttackLine(attackerCell, attackedCell, board, 7);
  }

  private boolean hasFreeAttackLine(int attackerCell, int attackedCell, char[] board, int jump) {
    int from = Math.min(attackerCell, attackedCell) + jump;
    int to = Math.max(attackerCell, attackedCell);
    for (int i = from; i < to; i += jump) {
      if (board[i] != '.')
        return false;
    }
    return true;
  }

  private boolean rookThreatens(int attackerCell, int attackedCell, char[] board) {
    boolean sameCol = (attackerCell % 8 == attackedCell % 8);
    boolean sameRow = (attackerCell / 8 == attackedCell / 8);
    if (sameRow) {
      return hasFreeAttackLine(attackerCell, attackedCell, board, 1);
    }
    return sameCol && hasFreeAttackLine(attackerCell, attackedCell, board, 8);
  }

  private boolean isEmpty(char[] board) {
    for (char cell : board) {
      if (cell != '.') {
        return false;
      }
    }
    return true;
  }
}
