package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class CaptureRegionsOnBoard {
    public void solve(ArrayList<ArrayList<Character>> a) {
        HashMap<Integer, Boolean> hasPath = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (a.get(i).get(j) == 'O' && hasPathToEdge(a, i, j, hasPath, new HashSet<>(), true)) {
                    continue;
                }
                a.get(i).set(j, 'X');
            }
        }
    }

    private boolean hasPathToEdge(ArrayList<ArrayList<Character>> a, int i, int j, HashMap<Integer, Boolean> hasPath, HashSet<Integer> seen, boolean orig) {
        int index = i * a.get(0).size() + j;
        if (hasPath.containsKey(index)) {
            return hasPath.get(index);
        }

        if (a.get(i).get(j) != 'O') {
            hasPath.put(index, false);
            return false;
        }
        if (i == 0 || i == a.size() - 1 || j == 0 || j == a.get(0).size() - 1) {
            hasPath.put(index, true);
            return true;
        }
        if (seen.contains(index)) {
            return false;
        }
        seen.add(index);

        boolean ans = hasPathToEdge(a, i - 1, j, hasPath, seen, false) || hasPathToEdge(a, i + 1, j, hasPath, seen, false)
                || hasPathToEdge(a, i, j - 1, hasPath, seen, false) || hasPathToEdge(a, i, j + 1, hasPath, seen, false);

        if (ans || orig) {
            hasPath.put(index, ans);
        }
        return ans;
    }

    public static void main(String[] st) {
        CaptureRegionsOnBoard q = new CaptureRegionsOnBoard();
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList('X', 'X', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'O', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'X', 'X')));
        System.out.println(A);
        q.solve(A);
        System.out.println(A);

        ArrayList<ArrayList<Character>> B = new ArrayList<>();
        B.add(convertStringToArraylist("XOXXXXOOXX"));
        B.add(convertStringToArraylist("XOOOOXOOXX"));
        B.add(convertStringToArraylist("OXXOOXXXOO"));
        B.add(convertStringToArraylist("OXOXOOOXXO"));
        B.add(convertStringToArraylist("OXOOXXOOXX"));
        B.add(convertStringToArraylist("OXXXOXXOXO"));
        B.add(convertStringToArraylist("OOXXXXOXOO"));

        System.out.println(B);
        q.solve(B);
        System.out.println(B);
    }

    private static ArrayList<Character> convertStringToArraylist(String str) {
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            charList.add(str.charAt(i));
        }
        return charList;
    }
}
