package ProjectAuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;


/**
 * Created by max on 1/27/2017.
 */
public class p24 {
    /*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
012   021   102   120   201   210
What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
     */


    public int[] questionNaive(int n) {
        int[] digits = new int[10];
        List<Integer> list = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        for (int j = 0; j < digits.length; j++) {
            long maxAvalibleNum = permutationsForDigitInIndexI(j+1);
            int digit = (int)(n/maxAvalibleNum);
            digits[j] = list.get(digit);
            list.remove(digit);
            n -= digit * maxAvalibleNum;
        }

       return digits;
    }


    private long permutationsForDigitInIndexI(int i){
        int ans = 1;
        for (int j = 10-i; j >1 ; j--) {
            ans*=j;
        }
        return ans;
    }


    public static void main(String[] st) {
        p24 q = new p24();

        System.out.println(Arrays.toString(q.questionNaive(1000000-1)));
    }
}
