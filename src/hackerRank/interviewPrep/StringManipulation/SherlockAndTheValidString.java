package hackerRank.interviewPrep.StringManipulation;

import java.util.Arrays;

public class SherlockAndTheValidString {
    static String isValid(String s) {
        int[] cnt = new int['z'-'a'+1];
        for(char c:s.toCharArray()){
            cnt[c-'a']++;
        }
        Arrays.sort(cnt);

        if (checkSpecialCase(cnt) || checkPlusOne(cnt)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean checkSpecialCase(int[] cnt) {
        boolean seenPlusOne = false;
        int min = 0;
        for (int x : cnt) {
            if (x != 0) {
                if (x == 1) {
                    if (seenPlusOne) {
                        return false;
                    }
                    seenPlusOne = true;
                    continue;
                }
                if (min == 0) {
                    min = x;
                }
                if (x != min) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkPlusOne(int[] cnt) {
        boolean seenPlusOne = false;
        int min = 0;
        for (int x : cnt) {
            if (x != 0) {
                if (min == 0) {
                    min = x;
                }
                if (x != min) {
                    if ((x != min + 1 && x != 1) || seenPlusOne) {
                        return false;
                    }
                    seenPlusOne = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] st){
        isValid("aabbc");
    }
}
