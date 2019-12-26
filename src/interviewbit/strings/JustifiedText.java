package interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 *
 * Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Your program should return a list of strings, where each string represents a single line.
 *
 * Example:
 *
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 *
 * L: 16.
 *
 * Return the formatted lines as:
 *
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 */
public class JustifiedText {
    public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        ArrayList<String> ans = new ArrayList<>();
        int total = 0;
        ArrayList<String> words = new ArrayList<>();
        for (String aA : A) {
            if (total + aA.length() > B) {
                String just = justify(words, B);
                ans.add(just);
                words.clear();
                total = 0;
            }
            words.add(aA);
            total += aA.length() + 1;
        }
        if (total > 0) {
            ans.add(leftJustify(words, B));
        }
        return ans;
    }

    private String leftJustify(ArrayList<String> A, int B) {
        StringBuilder sb = new StringBuilder();
        for (String s : A) {
            sb.append(s);
            sb.append(' ');
        }
        addSpaces(B - (sb.length() - 1), sb);
        return sb.toString().substring(0, B);
    }

    private String justify(ArrayList<String> A, int B) {
        if (A.size() == 1) return leftJustify(A, B);
        int totalSize = 0;
        for (String s : A) {
            totalSize += s.length();
        }
        int totalMissingSpaces = B - totalSize;
        int spacesToAdd = totalMissingSpaces / (A.size() - 1);
        int extrasOnes = totalMissingSpaces - spacesToAdd * (A.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < A.size(); k++) {
            {
                sb.append(A.get(k));
                if (k != A.size() - 1) {
                    addSpaces(spacesToAdd, sb);
                    if (--extrasOnes >= 0) {
                        sb.append(' ');
                    }
                }
            }
        }
        return sb.toString();
    }

    private void addSpaces(int spacesToAdd, StringBuilder sb) {
        for (int i = 0; i < spacesToAdd; i++) {
            sb.append(' ');
        }
    }

    public static void main(String[] st) {
        JustifiedText q = new JustifiedText();
        System.out.println(q.fullJustify(new ArrayList<>(Arrays.asList("What", "must", "be", "shall", "be.")), 12));
        System.out.println(q.fullJustify(new ArrayList<>(Arrays.asList("glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m")), 144));
    }
}
