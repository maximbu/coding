package UVA.AdHoc.Games_harder;

import java.util.Scanner;

class Q220_Othello {

  private char currPlayer;

  public static void main(String[] st) {
    Q220_Othello p = new Q220_Othello();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int gamesNum = sc.nextInt();
    sc.nextLine();
    while (gamesNum-- > 0) {
      char[][] board = new char[8][8];

      for (int i = 0; i < 8; i++) {
        String s = sc.nextLine();
        char[] row = s.toCharArray();
        board[i] = row;
      }
      currPlayer = sc.nextLine().charAt(0);
      boolean stopped = false;
      while (!stopped) {
        String command = sc.nextLine();
        switch (command.charAt(0)) {
          case 'L': {
            //printBoard(board);
            listMoves(board);
            break;
          }
          case 'M': {
            makeMove((command.charAt(1) - '0')-1, (command.charAt(2) - '0')-1,board);
            System.out.printf("Black - %2d White - %2d%n", count(board, 'B'), count(board, 'W'));
            currPlayer = otherPlayer();
            break;
          }
          case 'Q': {
            printBoard(board);
            stopped = true;
            break;
          }
        }
      }
      if (gamesNum > 0) {
        System.out.println();
      }
    }

  }

  private int count(char[][] board, char player) {
    int tot = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == player) {
          tot++;
        }
      }
    }
    return tot;
  }

  private void printBoard(char[][] board) {
    for (char[] row : board) {
      for (char cell : row) {
        System.out.print(cell);
      }
      System.out.println();
    }
  }


  private void listMoves(char[][] board) {
    boolean anyFound = false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        boolean isValid = isValidMove(i, j, board);
        if (isValid) {
          if (anyFound) {
            System.out.print(" ");
          }
          anyFound = true;
          System.out.print("(" + (i+1) + "," + (j+1) + ")");
        }
      }
    }
    if (!anyFound) {
      System.out.println("No legal move.");
    } else {
      System.out.println();
    }
  }

  private char otherPlayer(){
    return currPlayer == 'W'?'B':'W';
  }

  private boolean isValidMove(int i, int j, char[][] board) {
    if (board[i][j] != '-')
      return false;
    for (int k = -1; k < 2; k++) {
      for (int l = -1; l < 2; l++) {
        if(i+k >= 0 && j+l >=0 && i+k < board.length && j+l< board.length){
          if(board[i+k][j+l] == otherPlayer()){
            if(isBracketed(i,j,k,l,board)){
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  private boolean isBracketed(int i, int j, int xDir, int yDir, char[][] board) {
    for (int k = 2; k < board.length; k++) {
      if (i + (xDir * k) < 0 || i + (xDir * k) >= board.length || j + (yDir * k) < 0
          || j + (yDir * k) >= board.length || (board[i + (xDir * k)][j + (yDir * k)] == '-')) {
        return false;
      }
      if (board[i + (xDir * k)][j + (yDir * k)] == currPlayer)
        return true;
    }
    return false;
  }

  private void makeMove(int i, int j, char[][] board) {
    if(!isValidMove(i,j,board)){
      currPlayer = otherPlayer();
    }
    board[i][j] = currPlayer;
    for (int k = -1; k < 2; k++) {
      for (int l = -1; l < 2; l++) {
        if (i + k >= 0 && j + l >= 0 && i + k < board.length && j + l < board.length) {
          if (board[i + k][j + l] == otherPlayer()) {
            if(isBracketed(i, j, k, l, board)) {
              captureBracketed(i, j, k, l, board);
            }
          }
        }
      }
    }
  }

  private void captureBracketed(int i, int j, int xDir, int yDir, char[][] board) {
    for (int k = 1; k < board.length; k++) {
      if (i + (xDir * k) < 0 || i + (xDir * k) >= board.length || j + (yDir * k) < 0
          || j + (yDir * k) >= board.length) {
        return;
      }
      if (board[i + (xDir * k)][j + (yDir * k)] == currPlayer)
        return;
      board[i + (xDir * k)][j + (yDir * k)] = currPlayer;
    }
  }

}
