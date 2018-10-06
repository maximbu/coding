package interviewbit.DynamicProgramming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * Example :
 *
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 */
public class WaysToDecode {

    public int numDecodings(String A) {
        int[] w = new int[A.length()];
        if (A.charAt(0) == '0')
            return 0;
        w[0] = 1;
        for (int i = 1; i < A.length(); i++) {
            w[i] = w[i - 1];
            if (A.charAt(i) != '0') {
                if (A.charAt(i - 1) == '1' || (A.charAt(i - 1) == '2' && A.charAt(i) - '0' < 7)) {
                    if (i > 1 && w[i - 1] > w[i - 2]) {
                        w[i] = w[i - 2] * 3;
                    } else {
                        w[i] *= 2;
                    }
                }
            } else {
                if (A.charAt(i - 1) - '0' > 2) {
                    return 0;
                } else {
                    w[i] = Math.max(1, w[i] / 2);
                }
            }
        }
        return w[A.length() - 1];
    }

    public static void main(String[] st) {
        WaysToDecode q = new WaysToDecode();
        System.out.println(q.numDecodings("875361268549483279131"));
        System.out.println(q.numDecodings("20"));
        System.out.println(q.numDecodings("2611055971756562"));
        String A = "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190";
        System.out.println(q.numDecodings(A));
    }
}
