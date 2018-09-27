package interviewbit.strings;

import java.util.regex.Pattern;

/**
 * Compare two version numbers version1 and version2.
 *
 * If version1 > version2 return 1,
 * If version1 < version2 return -1,
 * otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class CompareVersionNumbers {
    public int compareVersion(String A, String B) {
        String[] aVer = A.split(Pattern.quote("."));
        String[] bVer = B.split(Pattern.quote("."));

        int i = 0;
        for (; i < Math.min(4, Math.min(aVer.length, bVer.length)); i++) {
            int x = compare(skipZeroes(aVer[i]),skipZeroes(bVer[i]));
            if (x != 0) return x;
        }

        return Integer.compare(Integer.compare(nonZeroIndFromI(aVer, i), nonZeroIndFromI(bVer, i)), 0);
    }

    private int compare(String a , String b) {
        int len = Integer.compare(a.length(), b.length());
        if (len != 0) return len;
        return Integer.compare(a.compareTo(b), 0);
    }

    private int nonZeroIndFromI(String[] aVer, int i) {
        int zeroes = 0;
        while (i < aVer.length) {
            if (!skipZeroes(aVer[i]).equals("0")) {
                return i-zeroes;
            }
            i++;
            zeroes++;
        }
        return i-1-zeroes;
    }

    private String skipZeroes(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='0'){
                return s.substring(i);
            }
        }
        return "0";
    }

    public static void main(String[] st) {
        CompareVersionNumbers q = new CompareVersionNumbers();
        System.out.println(q.compareVersion("4444371174137455","5.168"));
        System.out.println(q.compareVersion("2","4"));
        System.out.println(q.compareVersion("1.0","1"));
        System.out.println(q.compareVersion("444444444444444444444444","4444444444444444444444444"));
        System.out.println(q.compareVersion("13.0","13.0.8"));
        System.out.println(q.compareVersion("01","1"));
    }
}
