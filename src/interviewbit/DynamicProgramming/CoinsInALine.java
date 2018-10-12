package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * There are N coins (Assume N is even) in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins. Assume that you go first.
 *
 * Write a program which computes the maximum amount of money you can win.
 *
 * Example:
 *
 * suppose that there are 4 coins which have value
 * 1 2 3 4
 * now you are first so you pick 4
 * then in next term
 * next person picks 3 then
 * you pick 2 and
 * then next person picks 1
 * so total of your money is 4 + 2 = 6
 * next/opposite person will get 1 + 3 = 4
 * so maximum amount of value you can get is 6
 */
public class CoinsInALine {

    public int maxcoin(ArrayList<Integer> A) {
        int[][] p1 = new int[A.size()][A.size()];
        int[][] p2 = new int[A.size()][A.size()];
        for (int i = A.size() - 1; i >= 0; i--) {
            for (int j = i; j < A.size(); j++) {
                if (i == j) {
                    p1[i][j] = A.get(i);
                } else {
                    p1[i][j] = Math.max(A.get(i) + p2[i + 1][j],
                            A.get(j) + p2[i][j - 1]);
                    p2[i][j] = Math.min(p1[i + 1][j], p1[i][j - 1]);
                }
            }
        }
        return p1[0][A.size() - 1];
    }


    public static void main(String[] st) {
        CoinsInALine q = new CoinsInALine();
        System.out.println(q.maxcoin(new ArrayList<>(Arrays.asList(1, 2, 3))));
        System.out.println(q.maxcoin(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
    }
}
