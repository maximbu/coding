package interviewbit.Backtracking;

import java.util.ArrayList;

/**
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * There might be multiple gray code sequences possible for a given n.
 * Return any such sequence.
 *
 */
public class GrayCode {

    public ArrayList<Integer> grayCode(int a) {
        if (a == 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(1);
            return ans;
        }
        ArrayList<Integer> prev = grayCode(a - 1);
        ArrayList<Integer> ans = new ArrayList<>(prev);
        for (int i = prev.size() - 1; i >= 0; i--) {
            ans.add((int) Math.pow(2, a - 1) + prev.get(i));
        }
        return ans;
    }


    public static void main(String[] st) {
        GrayCode q = new GrayCode();
        System.out.println(q.grayCode(2));
    }
}
