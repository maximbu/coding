package interviewbit.strings;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 *  Note: The numbers can be arbitrarily large and are non-negative.
 * Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
 * For example,
 * given strings "12", "10", your answer should be “120”.
 *
 * NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
 * We will retroactively disqualify such submissions and the submissions will incur penalties.
 */
public class MultiplyStrings {
    public String multiply(String A, String B) {
        String ans = "";
        for (int i = A.length() - 1; i >= 0; i--) {
            String tmp = multiply(A.charAt(i) - '0', B, A.length() - 1 - i);
            ans = sum(ans, tmp);
        }
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0') {
                return ans.substring(i);
            }
        }
        return "0";
    }

    private String sum(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int aLen = A.length() - 1;
        int bLen = B.length() - 1;
        int carry = 0;
        while (aLen >= 0 || bLen >= 0 || carry > 0) {
            int sum = (aLen < 0 ? 0 : A.charAt(aLen--) - '0')
                    + (bLen < 0 ? 0 : B.charAt(bLen--) - '0')
                    + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }

    private String multiply(int d, String st, int endZeros) {
        StringBuilder sb = new StringBuilder();
        while (endZeros-- > 0) {
            sb.append(0);
        }
        int len = st.length() - 1;
        int carry = 0;
        while (len >= 0) {
            int val = d * (st.charAt(len--) - '0') + carry;
            sb.append(val % 10);
            carry = val / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
