package ProjectAuler;

import java.util.HashMap;

/**
 * Created by max on 1/27/2017.
 */
public class p15 {
    /*
 Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
How many such routes are there through a 20×20 grid?
     */


    public static long questionNaive(int size) {
        double ans = 1;
        for (int i = size+1; i <= 2*size; i++) {
            ans*=i;
            ans/=(i-size);
        }
        return (long)ans;
    }


    public static void main(String[] st) {
        p15 q = new p15();

        System.out.println(questionNaive(20));
    }
}
