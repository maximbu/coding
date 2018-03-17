package ProjectAuler;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by max on 1/27/2017.
 */
public class p52 {
    /*
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
*/


    public int questionNaive() {
        for (int i = 10; i <= 12346789; i++) {
            String digits = getSortedDigits(i);
            for (int j = 2; j < 7; j++) {
                if(!digits.equals(getSortedDigits(i*j))){
                    break;
                }
                if(j==6) return i;
            }
        }
        return 0;
    }

    private String getSortedDigits(int i) {
        char[] digits = String.valueOf(i).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }


    public static void main(String[] st) {
        p52 q = new p52();
        System.out.println(q.questionNaive());
}
}
