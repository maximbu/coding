package interviewbit.strings;

import java.util.ArrayList;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 *
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 * Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 *
 * Example:
 *
 * Given the array as:
 *
 * [
 *
 *   "abcdefgh",
 *
 *   "aefghijk",
 *
 *   "abcefgh"
 * ]
 * The answer would be “a”.
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        if (A == null || A.size() ==0) return "";
        String longestCommon = A.get(0);
        for(int i=1;i<A.size();i++){
            longestCommon = findLongest(longestCommon,A.get(i));
        }
        return longestCommon;
    }

    private String findLongest(String a , String b){
        if(a == null || b==null || a.length() == 0 || b.length() == 0)
            return "";
        for(int i=0;i<Math.min(a.length(),b.length());i++){
            if(a.charAt(i) != b.charAt(i)){
                return a.substring(0,i);
            }
        }
        return a.length() < b.length() ? a : b;
    }
}
