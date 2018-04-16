package CodingInterviews.P1;

import sun.security.util.BitArray;

import java.util.HashSet;

/**
 * Created by max on 12/16/2016.
 */
public class q1_1 {
    public static boolean uniqueChars(String s){
        HashSet<Character> hash = new HashSet<>();
        for (char c : s.toCharArray())
            if (!hash.add(c)) return false;
        return true;
    }

    public static boolean uniqueCharsNoSet(String s){
        BitArray b = new BitArray(128);
        for (char c : s.toCharArray()) {
            if (b.get(c)) return false;
            b.set(c,true);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("abcdefg"+"->"+uniqueChars("abcdefg"));
        System.out.println("abcdefc"+"->"+uniqueChars("abcdefc"));

        System.out.println("abcdefg"+"->"+uniqueCharsNoSet("abcdefg"));
        System.out.println("abcdefc"+"->"+uniqueCharsNoSet("abcdefc"));
    }
}
