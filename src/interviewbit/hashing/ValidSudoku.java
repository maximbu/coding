package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
 *
 *
 *
 * The input corresponding to the above configuration :
 *
 * ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 * A partially filled sudoku which is valid.
 *
 *  Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidSudoku {

    public int isValidSudoku(final List<String> A) {
        ArrayList<HashSet<Integer>> rows = new ArrayList<>();
        ArrayList<HashSet<Integer>> cols = new ArrayList<>();
        ArrayList<HashSet<Integer>> squares = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            squares.add(new HashSet<>());
        }
        for (int i = 0; i < A.size(); i++) {
            String row = A.get(i);
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '.') {
                    continue;
                }
                int d = row.charAt(j) - '0';
                if (d < 1 || d > 9
                        || !rows.get(i).add(d)
                        || !cols.get(j).add(d)
                        || !squares.get(3 * (i / 3) + (j / 3)).add(d)) {
                    return 0;
                }
            }
        }
        return 1;
    }


    public static void main(String[] st) {
        ValidSudoku q = new ValidSudoku();
        List<String> A = Arrays.asList("..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6..");
        System.out.println(q.isValidSudoku(A));
    }
}
