package interviewbit.strings;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * Example:
 *
 * a = "100"
 *
 * b = "11"
 * Return a + b = “111”.
 */
public class AddBinaryStrings {

    public String addBinary(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int aLen = A.length() - 1;
        int bLen = B.length() - 1;
        int carry = 0;
        while (aLen >= 0 || bLen >= 0 || carry > 0) {
            int sum = (aLen < 0 ? 0 : A.charAt(aLen--) - '0')
                    + (bLen < 0 ? 0 : B.charAt(bLen--) - '0')
                    + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] st) {
        AddBinaryStrings q = new AddBinaryStrings();
        String a1 = "100";
        String a2 = "11";
        System.out.println(a1 + " + " + a2 + " = " + q.addBinary(a1, a2));

        a1 = "1010110111001101101000";
        a2 = "1000011011000000111100110";
        System.out.println(a1 + " + " + a2 + " = " + q.addBinary(a1, a2));
    }
}
