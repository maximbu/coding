package CodingInterviews2018.P8;

import java.util.HashMap;

public class q8_14 {

    private static int booleanEval(String exp, boolean ans) {
        if (exp == null || exp.length() == 0)
            return 0;
        var trueMap = new HashMap<String, Integer>();
        var falseMap = new HashMap<String, Integer>();
        return booleanEval(exp, ans, trueMap, falseMap);
    }

    private static int booleanEval(String input, boolean expVal, HashMap<String, Integer> trueMap, HashMap<String, Integer> falseMap) {
        if (input.length() == 1) {
            return expVal == (input.charAt(0) == '1') ? 1 : 0;
        }
        int ans = 0;
        var map = expVal ? trueMap : falseMap;
        if (map.containsKey(input)) {
            return map.get(input);
        }
        for (int i = 0; i < input.length(); i++) {
            char op = input.charAt(i);
            if (op == '&' || op == '|' || op == '^') {
                ans += calculateOps(op, input.substring(0, i), input.substring(i + 1), trueMap, falseMap, expVal);
            }
        }
        map.put(input, ans);
        return ans;
    }

    private static int calculateOps(char op, String left, String right, HashMap<String, Integer> trueMap, HashMap<String, Integer> falseMap, boolean expVal) {
        int leftTrue = booleanEval(left, true, trueMap, falseMap);
        int leftFalse = booleanEval(left, false, trueMap, falseMap);
        int rightTrue = booleanEval(right, true, trueMap, falseMap);
        int rightFalse = booleanEval(right, false, trueMap, falseMap);
        int allCombinations = (leftTrue + leftFalse) * (rightTrue + rightFalse);

        switch (op) {
            case '&': {
                int trueComb = leftTrue * rightTrue;
                if (expVal) {
                    return trueComb;
                }
                return allCombinations - trueComb;
            }
            case '|': {
                int falseComb = leftFalse * rightFalse;
                if (!expVal) {
                    return falseComb;
                }
                return allCombinations - falseComb;
            }

            case '^': {
                int falseComb = (leftFalse * rightFalse) + (leftTrue * rightTrue);
                if (!expVal) {
                    return falseComb;
                }
                return allCombinations - falseComb;
            }

        }
        return 0;
    }

    public static void main(String[] st) {
        int e1 = booleanEval("1^0", true);
        int e2 = booleanEval("1^0|0|1", false);
        int e10 = booleanEval("0&0&0&1^1|0", true);

    }
}
