package ProjectAuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by max on 1/27/2017.
 */
public class p25 {
    /*
The Fibonacci sequence is defined by the recurrence relation:
Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:
F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.
What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
     */


    public int questionNaive(int n) {
        BigInteger nMinus2 = new BigInteger("1");
        BigInteger nMinus1 = new BigInteger("1");
        int ind = 2;
        while (true){
            BigInteger curr = nMinus1.add(nMinus2);
            if(curr.toString().length() >= n) return ind+1;
            nMinus2=nMinus1;
            nMinus1 = curr;
            ind++;
        }
    }





    public static void main(String[] st) {
        p25 q = new p25();

        System.out.println(q.questionNaive(1000));
    }
}
