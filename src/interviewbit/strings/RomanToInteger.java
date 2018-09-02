package interviewbit.strings;

/**
 *
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Read more details about roman numerals at Roman Numeric System
 *
 * Example :
 *
 * Input : "XIV"
 * Return : 14
 * Input : "XX"
 * Output : 20
 *
 */
public class RomanToInteger {

    private char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private int[] val = {1, 5, 10, 50, 100, 500, 1000};

    public int romanToInt(String A) {
        char[] in = A.toCharArray();
        int sum = 0;
        int interSum = getVal(in[0]);
        for (int i = 1; i < in.length; i++) {
            int currVal = getVal(in[i]);
            if (in[i] != in[i - 1]) {
                if (currVal > getVal(in[i - 1])) {
                    sum = sum + currVal - interSum;
                    interSum = 0;
                } else {
                    sum += interSum;
                    interSum = currVal;
                }
            } else {
                interSum += currVal;
            }
        }
        sum += interSum;
        return sum;
    }

    private int getVal(char ch) {
        for (int i = 0; i < roman.length; i++) {
            if (roman[i] == ch)
                return val[i];
        }
        return 0;
    }
}
