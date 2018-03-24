package UVA.AdHoc.Chess;

import java.util.Scanner;
import java.util.stream.IntStream;

class Q10284_ChessboardInFEN {

  public static final boolean DEBUG = false;

  public static void main(String[] st) {
    Q10284_ChessboardInFEN p = new Q10284_ChessboardInFEN();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      char board[] = new char[64];
      int ind = 0;
      char[] rep = sc.nextLine().toCharArray();
      for (char cell : rep) {
        if(cell=='/') continue;
        if (Character.isDigit(cell)) {
          for (int j = 0; j < cell - '0'; j++) {
            board[ind++] = '.';
          }
        } else {
          board[ind++] = cell;
        }
      }
      int ans = solve(board);
      System.out.println(ans);
    }
  }

  private int solve(char[] board) {
    return (int)IntStream.range(0, board.length)
        .filter(i -> board[i] == '.' && !isUnderAttack(i, board)).count();
  }

  private boolean isUnderAttack(int cell, char[] board) {
    return IntStream.range(0, board.length).
        anyMatch(i ->  isThreatens(i, cell, board));
  }

  private boolean isThreatens(int attackerCell, int attackedCell, char[] board) {
    switch (Character.toLowerCase(board[attackerCell])) {
      case 'p': {
        boolean a=  pawnThreatens(attackerCell, attackedCell, board);
        if(DEBUG && a){
          System.out.println(board[attackerCell]+" on: "+attackerCell+" attackedCell: "+attackedCell);
        }
        return a;
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
        boolean a = queenThreatens(attackerCell, attackedCell, board);
        if(DEBUG && a){
          System.out.println(board[attackerCell]+" on: "+attackerCell+" attackedCell: "+attackedCell);
        }
        return a;
      }
      case 'k': {
        return kingThreatens(attackerCell, attackedCell);
      }
      default:
        return false;
    }
  }

  private boolean kingThreatens(int attackerCell, int attackedCell) {
    int rowDiff = Math.abs(attackedCell / 8 - attackerCell / 8);
    int colDiff = Math.abs(attackedCell % 8 - attackerCell % 8);
    return rowDiff <= 1 && colDiff <= 1;
  }

  private boolean pawnThreatens(int attackerCell, int attackedCell, char[] board) {
    int diff = attackedCell-attackerCell;
    if (Character.isUpperCase(board[attackerCell])) {
      diff *= -1;
    }
    int rowDiff = Math.abs(attackedCell/8-attackerCell/8);
    return (rowDiff==1)&&(diff == 9 || diff == 7);
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

}
