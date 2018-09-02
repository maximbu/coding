package CodingInterviews2018.P10;

import java.util.Arrays;
import java.util.BitSet;

public class q10_8 {

    private static void dups(int[] arr) {
        BitSet b = new BitSet();
        for(int x:arr){
            if(b.get(x)){
                System.out.println(x);
            }
            b.set(x);
        }
    }


    public static void main (String[] st){
        int[] a = new int[32020];
        Arrays.setAll(a, i -> (i + 1) % 32000);
        dups(a);
    }

}
