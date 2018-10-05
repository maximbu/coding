package interviewbit.GraphDataStructure;

import java.util.ArrayList;

/**
 * Given N and M find all stepping numbers in range N to M
 *
 * The stepping number:
 *
 * A number is called as a stepping number if the adjacent digits have a difference of 1.
 * e.g 123 is stepping number, but 358 is not a stepping number
 *
 * Example:
 *
 * N = 10, M = 20
 * all stepping numbers are 10 , 12
 * Return the numbers in sorted order.
 */
public class SteppingNumbers {

    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = A; i <= B; i++) {
            if (stepNum(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean stepNum(int x) {
        int prevD = x % 10;
        while (x > 9) {
            x = x / 10;
            int d = x % 10;
            if (Math.abs(prevD - d) != 1) {
                return false;
            }
            prevD = d;
        }
        return true;
    }
}
