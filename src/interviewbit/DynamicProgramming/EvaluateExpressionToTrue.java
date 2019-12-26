package interviewbit.DynamicProgramming;

import java.util.HashMap;

/**
 * Given expression with operands and operators (OR , AND , XOR) , in how many ways can you evaluate the expression to true, by grouping in different ways? Operands are only true and false.
 * Input:
 *
 * string :  T|F&T^T
 * here '|' will represent or operator
 *      '&' will represent and operator
 *      '^' will represent xor operator
 *      'T' will represent true operand
 *      'F' will false
 * Output:
 *
 * different ways % MOD
 * where MOD = 1003
 * Example:
 *
 * string : T|F
 * only 1 way (T|F) => T
 * so output will be 1 % MOD = 1
 */
public class EvaluateExpressionToTrue {

  public int cnttrue(String A) {
    return cntval(A, true, new HashMap<>(), new HashMap<>());
  }

  private int cntval(String A, boolean t, HashMap<String, Integer> trueMap, HashMap<String, Integer> falseMap) {
    if (A.length() < 2) {
      return A.equals("T") ^ t ? 0 : 1;
    }
    HashMap<String, Integer> map = t ? trueMap : falseMap;
    if (map.containsKey(A)) {
      return map.get(A);
    }
    int ways = 0;
    for (int i = 1; i < A.length(); i += 2) {
      int leftTrue = cntval(A.substring(0, i), true, trueMap, falseMap);
      int leftFalse = cntval(A.substring(0, i), false, trueMap, falseMap);
      int rightTrue = cntval(A.substring(i + 1), true, trueMap, falseMap);
      int rightFalse = cntval(A.substring(i + 1), false, trueMap, falseMap);
      int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
      int val = 0;
      switch (A.charAt(i)) {
        case '|':
          val = total - (leftFalse * rightFalse);
          break;
        case '^':
          val = (leftTrue * rightFalse) + (leftFalse * rightTrue);
          break;
        case '&':
          val = leftTrue * rightTrue;
          break;

      }
      if (!t) {
        val = total - val;
      }
      ways = (val + ways) % 1003;
    }
    map.put(A, ways);
    return ways;
  }

  public static void main(String[] st) {
    EvaluateExpressionToTrue q = new EvaluateExpressionToTrue();
    System.out.println(q.cnttrue("T^T^T^F|F&F^F|T^F^T"));
    System.out.println(q.cnttrue("F|T^T&F"));
    System.out.println(q.cnttrue("T^T^F|F"));
    System.out.println(q.cnttrue("T^T^T^F|F"));

  }
}
