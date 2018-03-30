package UVA.AdHoc.Games_harder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q227_Puzzle {

  public static void main(String[] st) {
    Q227_Puzzle p = new Q227_Puzzle();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int gamesNum = 1;
    while (true) {
      char[][] board = new char[5][5];
      for (int i = 0; i < 5; i++) {
        String s = sc.nextLine();
        if(s.equals("Z")){
          return;
        }
        if(s.length() < 5) {
          s = s + ' ';
        }
        char[] row = s.toCharArray();
        board[i] = row;
      }

      boolean finished = false;
      List<Character> moves = new ArrayList<>();
      while (!finished) {
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
          moves.add(input.charAt(i));
        }
        if(input.endsWith("0")){
          finished = true;
        }
      }
      boolean valid = makeMoves(board,moves);
      if (gamesNum > 1) {
        System.out.println();
      }
      System.out.printf("Puzzle #%d:%n", gamesNum++);
      if(valid) {
        printBoard(board);
      }
      else{
        System.out.println("This puzzle has no final configuration.");
      }
    }

  }

  private boolean makeMoves(char[][] board, List<Character> moves) {
    for (Character move : moves) {
      switch (move) {
        case 'A': {
          if (!moveIndex(board, -1, 0)) {
            return false;
          }
          break;
        }
        case 'B': {
          if (!moveIndex(board, 1, 0)) {
            return false;
          }
          break;
        }
        case 'R': {
          if (!moveIndex(board, 0, 1)) {
            return false;
          }
          break;
        }
        case 'L': {
          if (!moveIndex(board, 0, -1)) {
            return false;
          }
          break;
        }
        case '0': {
          break;
        }
        default: {
          return false;
        }

      }
    }
    return true;
  }

  private boolean moveIndex(char[][] board, int indX ,int indY) {
    int emptyX = 0;
    int emptyY = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if(board[i][j]==' '){
          emptyX = i;
          emptyY = j;
          break;
        }
      }
    }
    if(emptyX+indX<0 || emptyX+indX >= board.length || emptyY+indY <0 || emptyY+indY >= board.length){
      return false;
    }
    char moved = board[emptyX+indX][emptyY+indY];
    board[emptyX+indX][emptyY+indY] = ' ';
    board[emptyX][emptyY] = moved;
    return true;
  }

  private void printBoard(char[][] board) {
    for (char[] row : board) {
      for (int i = 0; i < row.length; i++) {
        if (i > 0) {
          System.out.print(" ");
        }
        System.out.print(row[i]);
      }
      System.out.println();
    }
  }


}
