package CodingInterviews2018.P16;

import java.util.ListIterator;
import java.util.Stack;

public class q16_26 {

    private static double calc(String calcExp) {
        Stack<Double> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        double num = 0;
        for (char c : calcExp.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10.0 + c - '0';
            } else {
                nums.push(num);
                while (!ops.empty() && (ops.peek() == '*' || ops.peek() == '/') && nums.size() > 1) {
                    calculateExpression(nums, ops);
                }
                ops.push(c);
                num = 0;
            }
        }
        nums.push(num);
        ListIterator<Double> numList = nums.listIterator();
        ListIterator<Character> opList = ops.listIterator();
        double ans = numList.next();
        while (opList.hasNext()) {
            char op = opList.next();
            double n = numList.next();
            ans=calcOp(op, ans, n);
        }
        return ans;
    }

    private static void calculateExpression(Stack<Double> nums, Stack<Character> ops) {
        char op = ops.pop();
        double n1 = nums.pop();
        double n2 = nums.pop();
        nums.push(calcOp(op, n2, n1));
    }

    private static Double calcOp(char op, double n1, double n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            default:
                throw new IllegalStateException();
        }
    }

    public static void main(String[] args) {
        String calcExp = "2*3+5/6*3+15";
        double ans = calc(calcExp);
        System.out.println(calcExp + "=" + ans);
        calcExp = "6/5*3+4*5/2-12/6*3/3+3+3";  //3.6+10-2+3+3
        ans = calc(calcExp);
        System.out.println(calcExp + "=" + ans);
    }


}
