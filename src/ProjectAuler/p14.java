package ProjectAuler;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by max on 1/27/2017.
 */
public class p14 {
    /*
 The following iterative sequence is defined for the set of positive integers:
    n → n/2 (n is even)
    n → 3n + 1 (n is odd)
    Using the rule above and starting with 13, we generate the following sequence:
    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
    Which starting number, under one million, produces the longest chain?
     */

    static HashMap<Integer,Integer> lens = new HashMap<>();

    public static int questionNaive(int nums) {
       int longestI  = 1;
        int longestVal  = 1;
        for (int i = 2; i <nums ; i++) {
            int len = chainLen(i);
            if(len > longestVal){
                longestI = i;
                longestVal = len;
            }
        }
        return longestI;
    }

    private static int chainLen(int i) {
        int orig = i;
        int len = 1;
        long curr = i;
        while (curr != 1){
            if(lens.containsKey(curr)) {
                int ans =  len+lens.get(curr);
                lens.put(orig,ans);
                return ans;
            }
            len++;
            if(curr%2 == 0) {
                curr = curr/2;
            }
            else{
                curr = curr*3+1;
            }

        }
        lens.put(orig,len);
        return len;
    }


    public static void main(String[] st) {
        p14 q = new p14();

        System.out.println(questionNaive(1000000));
    }
}
