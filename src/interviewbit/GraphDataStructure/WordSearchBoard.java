package interviewbit.GraphDataStructure;

import java.util.ArrayList;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.
 * The same letter cell may be used more than once.
 *
 * Example :
 *
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns 1,
 * word = "SEE", -> returns 1,
 * word = "ABCB", -> returns 1,
 * word = "ABFSAB" -> returns 1
 * word = "ABCD" -> returns 0
 * Note that 1 corresponds to true, and 0 corresponds to false.
 */
public class WordSearchBoard {

    public int exist(ArrayList<String> A, String B) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).length(); j++) {
                if (A.get(i).charAt(j) == B.charAt(0) && exist(A, i, j, B, 1)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private boolean exist(ArrayList<String> A, int i, int j, String B, int ind) {
        if (ind >= B.length())
            return true;
        if (i > 0 && A.get(i - 1).charAt(j) == B.charAt(ind) && exist(A, i - 1, j, B, ind + 1))
            return true;
        if (i < A.size() - 1 && A.get(i + 1).charAt(j) == B.charAt(ind) && exist(A, i + 1, j, B, ind + 1))
            return true;
        if (j > 0 && A.get(i).charAt(j - 1) == B.charAt(ind) && exist(A, i, j - 1, B, ind + 1))
            return true;
        if (j < A.get(i).length() - 1 && A.get(i).charAt(j + 1) == B.charAt(ind) && exist(A, i, j + 1, B, ind + 1))
            return true;
        return false;
    }
}
