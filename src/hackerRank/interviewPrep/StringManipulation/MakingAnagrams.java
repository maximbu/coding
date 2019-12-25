package hackerRank.interviewPrep.StringManipulation;

import java.util.Arrays;

public class MakingAnagrams {
    static int makeAnagram(String a, String b) {
        int[] letters = new int['z' - 'a' + 1];
        for (char c : a.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            letters[c - 'a']--;
        }
        return Arrays.stream(letters).map(Math::abs).sum();
    }
}
