package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
* Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'
 * You may assume that there will be only one unique solution.
 *
 *
 *
 * A sudoku puzzle,
 *
 *
 *
 * and its solution numbers marked in red.
 *
 * Example :
 *
 * For the above given diagrams, the corresponding input to your program will be
 *
 * [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 * and we would expect your program to modify the above array of array of characters to
 *
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 *
 * */
public class Sudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solveSudokuInternal(a);
    }

    private boolean solveSudokuInternal(ArrayList<ArrayList<Character>> a) {
        for (int ind = 0; ind < a.size() * a.size(); ind++) {
            if (getInd(a, ind) != '.')
                continue;

            for (int i = 1; i < 10; i++) {
                putChar(a, ind, (char) (i + '0'));
                if (valid(a ,ind) && solveSudokuInternal(a)) {
                    return true;
                }
                putChar(a, ind, '.');
            }
            return false;
        }
        return true;
    }



    private char getInd(ArrayList<ArrayList<Character>> a,int ind){
        return a.get(ind / a.size()).get(ind % a.get(0).size());
    }

    private void putChar(ArrayList<ArrayList<Character>> a,int ind , char c){
        a.get(ind / a.size()).set(ind % a.get(0).size() , c);
    }

    private boolean valid(ArrayList<ArrayList<Character>> a, int ind) {
        return validRows(a, ind) && validCols(a, ind)
                && validSquares(a, ind);
    }

    private boolean validRows(ArrayList<ArrayList<Character>> a, int ind){
        return checkValid(a.get(ind / a.size()));
    }

    private boolean validCols(ArrayList<ArrayList<Character>> a, int ind) {
        ArrayList<Character> tmp = new ArrayList<>();
        for (int j = 0; j < a.size(); j++) {
            tmp.add(a.get(j).get(ind % a.size()));
        }
        return checkValid(tmp);
    }

    private boolean validSquares(ArrayList<ArrayList<Character>> a, int ind){
        int row = 3*((ind / a.size()) /3);
        int col = 3*((ind % a.size()) /3);
        ArrayList<Character> tmp = new ArrayList<>();
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                tmp.add(a.get(i).get(j));
            }
        }
        return checkValid(tmp);
    }

    private boolean checkValid(ArrayList<Character> a){
        HashSet<Character> set = new HashSet<>();
        return a.stream().noneMatch(c -> c != '.' && !set.add(c));
    }

    public static void main(String[] st) {
        Sudoku q = new Sudoku();

        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        A.add(toArr("53..7...."));
        A.add(toArr("6..195..."));
        A.add(toArr(".98....6."));
        A.add(toArr("8...6...3"));
        A.add(toArr("4..8.3..1"));
        A.add(toArr("7...2...6"));
        A.add(toArr(".6....28."));
        A.add(toArr("...419..5"));
        A.add(toArr("....8..79"));
        System.out.println(A);
        q.solveSudoku(A);
        System.out.println(A);
    }

    private static ArrayList<Character> toArr(String s){
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }

    private boolean startsWith(ArrayList<ArrayList<Character>> a, String s) {
        return IntStream.range(0, s.length())
                .noneMatch(i -> getInd(a, i) != s.charAt(i));
    }
}
