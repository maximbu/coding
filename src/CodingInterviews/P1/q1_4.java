package CodingInterviews.P1;

import java.util.BitSet;

/**
 * Created by max on 12/16/2016.
 */
public class q1_4 {
    public static boolean palindromePermutation(String st) {
        BitSet occurrences = new BitSet(128);
        for (int i=0;i<st.length();i++){
            char letter = st.charAt(i);
            if(Character.isLetter(letter)) occurrences.flip(Character.toLowerCase(letter));
        }
        return occurrences.cardinality() < 2;
    }



    public static void main(String[] args) {
        System.out.println("palindromePermutation(Tact Coa)"+"->"+palindromePermutation("Tact Coa"));
        System.out.println("palindromePermutation(Tact Coa)"+"->"+palindromePermutation("Tact Cot"));
        System.out.println("palindromePermutation(ABCca)"+"->"+palindromePermutation("ABCca"));
        System.out.println("palindromePermutation(ABCcad)"+"->"+palindromePermutation("ABCcad"));
    }
}
