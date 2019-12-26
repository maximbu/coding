package UVA.AdHoc.RealLife_harder;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Main {

  public static void main(String[] st) {
    Main p = new Main();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    char[][] grid = createGrid();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String[] args = line.split("\\s+");
      switch (args[0]) {
        case ".C":
          center(grid, args[1].equals("C1"), Integer.parseInt(args[2]), args[3]);
          break;
        case ".R":
          rightJustify(grid, args[1].equals("C1"), Integer.parseInt(args[2]), args[3]);
          break;
        case ".L":
          leftJustify(grid, args[1].equals("C1"), Integer.parseInt(args[2]), args[3]);
          break;
        case ".P":
          place(grid, args[1].equals("C1"), Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4]);
          break;
        case ".EOP":
          printGrid(grid);
          grid = createGrid();
          break;
      }
    }
  }

  private char[][] createGrid() {
    char[][] grid = new char[60][60];
    for (int i = 0; i < 60; i++) {
      for (int j = 0; j < 60; j++) {
        grid[i][j] = '.';
      }
    }
    return grid;
  }

  private void printGrid(char[][] grid) {
    for (int i = 0; i < 60; i++) {
      for (int j = 0; j < 60; j++) {
        out.print(grid[i][j]);
      }
      out.println();
    }
  }

  private void place(char[][] grid, boolean c1, int row, int col, String string) {
    if (c1) {
      for (int i = 0; i < string.length(); i++) {
        if (col + i - 1 >= 0 && col + i - 1 < 60 && string.charAt(i) != ' ')
          grid[row][col + i - 1] = string.charAt(i);
      }


    }
  }

  private void rightJustify(char[][] grid, boolean c1, int row, String string) {
  }

  private void leftJustify(char[][] grid, boolean c1, int row, String string) {
  }

  private void center(char[][] grid, boolean c1, int row, String string) {

  }

  private char[][] getC5(char c) {
    switch (c) {
      case ' ':
        return createArray(new String[]{"......", "......", "......", "......", "......"});
      case 'A':
        return createArray(new String[]{".***..", "*...*.", "*****.", "*...*.", "*...*."});
      case 'B':
        return createArray(new String[]{"****..", "*...*.", "****..", "*...*.", "****.."});
      case 'C':
        return createArray(new String[]{".****.", "*...*.", "*.....", "*.....", ".****."});
      case 'D':
        return createArray(new String[]{"****..", "*...*.", "*...*.", "*...*.", "****.."});
      case 'E':
        return createArray(new String[]{"*****.", "*.....", "***...", "*.....", "*****."});
      case 'F':
        return createArray(new String[]{"*****.", "*.....", "***...", "*.....", "*....."});
      case 'G':
        return createArray(new String[]{".****.", "*.....", "*..**.", "*...*.", ".***.."});
      case 'H':
        return createArray(new String[]{"*...*.", "*...*.", "*****.", "*...*.", "*...*."});
      case 'I':
        return createArray(new String[]{"*****.", "..*...", "..*...", "..*...", "*****."});
      case 'J':
        return createArray(new String[]{"..***.", "...*..", "...*..", "*..*..", ".**..."});
      case 'K':
        return createArray(new String[]{"*...*.", "*..*..", "***...", "*..*..", "*...*."});
      case 'L':
        return createArray(new String[]{"*.....", "*.....", "*.....", "*.....", "*****."});
      case 'M':
        return createArray(new String[]{"*...*.", "**.**.", "*.*.*.", "*...*.", "*...*."});
      case 'N':
        return createArray(new String[]{"*...*.", "**..*.", "*.*.*.", "*..**.", "*...*."});
      case 'O':
        return createArray(new String[]{".***..", "*...*.", "*...*.", "*...*.", ".***.."});
      case 'P':
        return createArray(new String[]{"****..", "*...*.", "****..", "*.....", "*....."});
      case 'Q':
        return createArray(new String[]{".***..", "*...*.", "*...*.", "*..**.", ".****."});
      case 'R':
        return createArray(new String[]{"****..", "*...*.", "****..", "*..*..", "*...*."});
      case 'S':
        return createArray(new String[]{".****.", "*.....", ".***..", "....*.", "****.."});
      case 'T':
        return createArray(new String[]{"*****.", "*.*.*.", "..*...", "..*...", ".***.."});
      case 'U':
        return createArray(new String[]{"*...*.", "*...*.", "*...*.", "*...*.", ".***.."});
      case 'V':
        return createArray(new String[]{"*...*.", "*...*.", ".*.*..", ".*.*..", "..*..."});
      case 'W':
        return createArray(new String[]{"*...*.", "*...*.", "*.*.*.", "**.**.", "*...*."});
      case 'X':
        return createArray(new String[]{"*...*.", ".*.*..", "..*...", ".*.*..", "*...*."});
      case 'Y':
        return createArray(new String[]{"*...*.", ".*.*..", "..*...", "..*...", "..*..."});
      case 'Z':
        return createArray(new String[]{"*****.", "...*..", "..*...", ".*....", "*****."});
    }
    throw new RuntimeException();
  }

  char[][] createArray(String[] s) {
    char[][] tmp = new char[5][5];
    for (int i = 0; i < 5; i++) {
      tmp[i] = s[i].toCharArray();
    }
    return tmp;
  }


}
