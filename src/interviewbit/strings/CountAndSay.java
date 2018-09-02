package interviewbit.strings;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as one 1 or 11.
 * 11 is read off as two 1s or 21.
 *
 * 21 is read off as one 2, then one 1 or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * Example:
 *
 * if n = 2,
 * the sequence is 11.
 */
public class CountAndSay {

    public String countAndSay(int A) {
        String n = "1";
        int i = 1;
        while (i < A) {
            n = generateNext(n);
            i++;
        }
        return n;
    }

    private String generateNext(String n) {
        StringBuilder sb = new StringBuilder();
        char[] ch = n.toCharArray();
        int ind = 1;
        int cnt = 1;
        int diggit = ch[0] - '0';
        while (ind < ch.length) {
            if (ch[ind] == ch[ind - 1]) {
                cnt++;
                ind++;
            } else {
                sb.append(cnt);
                sb.append(diggit);
                cnt = 1;
                diggit = ch[ind] - '0';
                ind++;
            }

        }
        sb.append(cnt);
        sb.append(diggit);
        return sb.toString();
    }

    public static void main(String[] st) {
        CountAndSay q = new CountAndSay();
        System.out.println(q.countAndSay(6));
    }
}
