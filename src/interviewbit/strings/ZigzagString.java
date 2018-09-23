package interviewbit.strings;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P.......A........H.......N
 * ..A..P....L....S....I...I....G
 * ....Y.........I........R
 * And then read line by line: PAHNAPLSIIGYIR
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * **Example 2 : **
 * ABCD, 2 can be written as
 *
 * A....C
 * ...B....D
 * and hence the answer would be ACBD.
 */
public class ZigzagString {
    public String convert(String A, int B) {
        if (B == 1)
            return A;
        ArrayList<ArrayList<Character>> letters = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            letters.add(new ArrayList<>());
        }
        int waveSize = 2 * B - 2;
        int lowest = waveSize / 2;
        int row = 0;
        boolean down = false;
        for (int i = 0; i < A.length(); i++) {
            letters.get(row).add(A.charAt(i));
            if (i % lowest == 0) {
                down = !down;
            }
            row += down ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Character> l : letters) {
            for (Character c : l) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] st) {
        ZigzagString q = new ZigzagString();
        System.out.println(q.convert("ABCDEFGHIJKLMNOPQRS",6));
        System.out.println(q.convert("PAYPALISHIRING",3));

        System.out.println(q.convert("ABCD",2));
    }
}
