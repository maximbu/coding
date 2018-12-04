package hackerRank.interviewPrep.DictsAndMaps;

import java.util.HashSet;

public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        HashSet<Character> letters = new HashSet<>();
        for(char c:s1.toCharArray()){
            letters.add(c);
        }
        for(char c:s2.toCharArray()){
            if(letters.contains(c)){
                return "YES";
            }
        }
        return "NO";
    }
}
