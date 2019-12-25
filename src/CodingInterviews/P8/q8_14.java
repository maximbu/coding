package CodingInterviews.P8;

/**
 * Created by max on 12/28/2016.
 */
public class q8_14 {
    public static int boolEval(String exp, boolean res) {
        if (exp.length() == 0) return 0;
        if (exp.length() == 1) {
            return res ^ exp.equals("0") ? 1 : 0;
        }
        int ways = 0;
        for (int i = 1; i < exp.length(); i += 2) {
            char c = exp.charAt(i);
            String left = exp.substring(0, i);
            String right = exp.substring(i + 1);

            int leftTrue = boolEval(left, true);
            int leftFalse = boolEval(left, false);
            int rightTrue = boolEval(right, true);
            int rightFalse = boolEval(right, false);
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalCorrect = 0;
            if (c == '^') {
                totalCorrect = leftTrue * rightFalse + leftFalse * rightTrue;
            }
            if (c == '&') {
                totalCorrect = leftTrue * rightTrue;
            }
            if (c == '|') {
                totalCorrect = total - leftFalse * rightFalse;
            }
            ways += (res ? totalCorrect : total - totalCorrect);
        }
        return ways;
    }

    public static void main(String[] st) {
        int e10 = boolEval("0&0&0&1^l|0", true);
        int e2 = boolEval("l^0|0|1", false);
    }
}

