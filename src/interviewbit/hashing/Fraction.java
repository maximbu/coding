package interviewbit.hashing;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example :
 *
 * Given numerator = 1, denominator = 2, return "0.5"
 * Given numerator = 2, denominator = 1, return "2"
 * Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class Fraction {
    public String fractionToDecimal(int A, int B) {
        if (A == 0) return "0";
        StringBuilder ans = new StringBuilder();
        if ((A > 0 && B < 0) || (A < 0 && B > 0)) {
            ans.append("-");
        }
        long a = Math.abs((long) A);
        long b = Math.abs((long) B);
        long val = a / b;
        a = a - b * val;
        ans.append(val);
        if (a == 0) {
            return ans.toString();
        }
        ans.append('.');
        StringBuilder dot = new StringBuilder();
        HashMap<Long, Integer> set = new HashMap<>();
        while (a != 0) {
            a = a * 10;
            val = a / b;
            if (set.containsKey(a)) {
                return ans.append(dot.toString(), 0, set.get(a)).
                        append("(").append(dot.toString(), set.get(a), dot.length()).
                        append(")").toString();
            } else {
                set.put(a, dot.length());
            }
            a = a - b * val;
            dot.append(val);
        }
        return ans.append(dot.toString()).toString();
    }

    public static void main(String[] st) {
        Fraction q = new Fraction();
        System.out.println(q.fractionToDecimal(1, 3));
        System.out.println(q.fractionToDecimal(87, 22));
        System.out.println(q.fractionToDecimal(-2147483648, -1));
        System.out.println(q.fractionToDecimal(0, -1));
    }
}
