package UVA.AdHoc.Chess;

import java.util.Scanner;
import java.util.stream.IntStream;

class Q10196_CheckTheCheck {

  public static void main(String[] st) {
    Q10196_CheckTheCheck p = new Q10196_CheckTheCheck();
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

  private boolean isThreatens(int attackerCell, int kingCell, char[] board) {
    switch (Character.toLowerCase(board[attackerCell])) {
      case 'p': {
        return pawnThreatens(attackerCell, kingCell, board);
      }
      case 'n': {
        return knightThreatens(attackerCell, kingCell);
      }
      case 'b': {
        return bishopThreatens(attackerCell, kingCell, board);
      }
      case 'r': {
        return rookThreatens(attackerCell, kingCell, board);
      }
      case 'q': {
        return queenThreatens(attackerCell, kingCell, board);
      }
      default:
        return false;
    }
  }

  private boolean pawnThreatens(int attackerCell, int kingCell, char[] board) {
    if (Character.isLowerCase(board[kingCell])) { // black king
      int diff = attackerCell - kingCell;
      return (diff == 9 || diff == 7);
    }
    int diff = kingCell - attackerCell;
    return (diff == 9 || diff == 7);
  }

  private boolean knightThreatens(int attackerCell, int kingCell) {
    boolean op1 = (Math.abs(attackerCell - kingCell) == 10);
    boolean op2 = (Math.abs(attackerCell - kingCell) == 6);
    boolean op3 = (Math.abs(attackerCell - kingCell) == 17);
    boolean op4 = (Math.abs(attackerCell - kingCell) == 15);
    return op1 || op2 || op3 || op4;
  }

  private boolean queenThreatens(int attackerCell, int kingCell, char[] board) {
    return rookThreatens(attackerCell, kingCell, board) || bishopThreatens(attackerCell, kingCell,
        board);
  }

  private boolean bishopThreatens(int attackerCell, int kingCell, char[] board) {
    boolean sameLeftDiagonal = ((Math.abs(attackerCell - kingCell) % 7) == 0);
    boolean sameRightDiagonal = ((Math.abs(attackerCell - kingCell) % 9) == 0);
    if (sameRightDiagonal) {
      return hasFreeAttackLine(attackerCell, kingCell, board, 9);
    }
    if (sameLeftDiagonal) {
      return hasFreeAttackLine(attackerCell, kingCell, board, 7);
    }
    return false;
  }

  private boolean hasFreeAttackLine(int attackerCell, int kingCell, char[] board, int jump) {
    int from = Math.min(attackerCell, kingCell) + jump;
    int to = Math.max(attackerCell, kingCell);
    for (int i = from; i < to; i += jump) {
      if (board[i] != '.')
        return false;
    }
    return true;
  }

  private boolean rookThreatens(int attackerCell, int kingCell, char[] board) {
    boolean sameCol = (attackerCell % 8 == kingCell % 8);
    boolean sameRow = (attackerCell / 8 == kingCell / 8);
    if (sameRow) {
      int from = Math.min(attackerCell, kingCell) + 1;
      int to = Math.max(attackerCell, kingCell);
      for (int i = from; i < to; i++) {
        if (board[i] != '.')
          return false;
      }
      return true;
    }
    if (sameCol) {
      return hasFreeAttackLine(attackerCell, kingCell, board, 8);
    }
    return false;
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
