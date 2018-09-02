package CodingInterviews.P1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by max on 12/16/2016.
 */
public class q1_2 {
    public static boolean isPermutation(String s1,String s2){
        if(s1.length() != s2.length()) return false;

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        return IntStream.range(0, s1Chars.length).noneMatch(i -> s1Chars[i] != s2Chars[i]);

    }



    public static void main(String[] args) {
        System.out.println("isPermutation(abcdefg,gfedcab)"+"->"+isPermutation("abcdefg","gfedcab"));
        System.out.println("isPermutation(abcdefg,gfedcaa)"+"->"+isPermutation("abcdefg","gfedcaa"));


    }
}
