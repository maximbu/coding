package UVA.AdHoc.Chess;

import java.util.Arrays;
import java.util.Scanner;

class Q255_CorrectMove {


  public static void main(String[] st) {
    Q255_CorrectMove p = new Q255_CorrectMove();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      String ans = solve(line);
      System.out.println(ans);
    }
  }

  private String solve(int[] line) {
    int king = line[0];
    int queen = line[1];
    int newQueen = line[2];
    if (king == queen)
      return "Illegal state";
    if (king == newQueen || queen == newQueen)
      return "Illegal move";
    int queenCurrRow = queen % 8;
    int queenCurrCol = queen / 8;
    int queenNewRow = newQueen % 8;
    int queenNewCol = newQueen / 8;
    int kingRow = king % 8;
    int kingCol = king / 8;

    boolean rowMove = (queenCurrRow == queenNewRow);
    boolean colMove = (queenCurrCol == queenNewCol);
    if (!rowMove && !colMove)
      return "Illegal move";
    if (rowMove && kingRow == queenCurrRow) {
      boolean kingInBetween = ((queenNewCol > kingCol && kingCol > queenCurrCol)
              || (queenNewCol < kingCol && kingCol < queenCurrCol));
      if (kingInBetween)
        return "Illegal move";
      if (Math.abs(queenNewCol - kingCol) == 1)
        return "Move not allowed";
    }
    if (colMove && kingCol == queenCurrCol) {
      boolean kingInBetween = ((queenNewRow > kingRow && kingRow > queenCurrRow)
              || (queenNewRow < kingRow && kingRow < queenCurrRow));
      if (kingInBetween)
        return "Illegal move";
      if (Math.abs(queenNewRow - kingRow) == 1)
        return "Move not allowed";
    }

    boolean sameRow = (queenNewRow == kingRow);
    boolean sameCol = (queenNewCol == kingCol);
    if (sameRow) {
      if (Math.abs(queenNewCol - kingCol) == 1)
        return "Move not allowed";
    }
    if (sameCol) {
      if (Math.abs(queenNewRow - kingRow) == 1)
        return "Move not allowed";
    }
    if (kingCol + 1 < 8 && (kingCol + 1 != queenNewCol))
      return "Continue";
    if (kingCol - 1 >= 0 && (kingCol - 1 != queenNewCol))
      return "Continue";
    if (kingRow + 1 < 8 && (kingRow + 1 != queenNewRow))
      return "Continue";
    if (kingRow - 1 >= 0 && (kingRow - 1 != queenNewRow))
      return "Continue";
    return "Stop";
  }


}
