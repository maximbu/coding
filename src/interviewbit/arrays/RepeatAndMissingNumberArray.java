package interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by max on 6/26/2017.
 * You are given a read only array of n integers from 1 to n.

 Each integer appears exactly once except A which appears twice and B which is missing.

 Return A and B.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Note that in your output A should precede B.
 */
public class RepeatAndMissingNumberArray {


  public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
    long repeated = -1;
    long missing = -1;

    long sum = 0;
    long sumSq = 0;
    long expectedSumSq = 0;
    long expectedSum = 0;
    for (int i = 0; i < a.size(); i++) {
      Integer anA = a.get(i);
      sum += anA;
      sumSq += anA * anA;
      expectedSum += i + 1;
      expectedSumSq += (i + 1) * (i + 1);
    }
    // repeated - missing = sum - expectedSum
    // repeated = sum - expectedSum + missing
    // repeated^2 - missing^2 = sumSq - expectedSumSq
    // (sum - expectedSum + missing)^2  - missing^2 = sumSq - expectedSumSq
    // (X + missing)^2  - missing^2 = sumSq - expectedSumSq
    // X^2 + 2*X*missing = sumSq - expectedSumSq
    // missing = (sumSq - expectedSumSq) - (sum - expectedSum)^2)/(2*(sum - expectedSum))

    long x = sum - expectedSum;
    missing = ((sumSq - expectedSumSq) - (x * x)) / (2 * x);
    repeated = sum - expectedSum + missing;
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add((int) repeated);
    ans.add((int) missing);
    return ans;
  }

  private ArrayList<Integer> naiveSolution(List<Integer> a) {
    HashSet<Integer> nums = new HashSet<>(a.size());
    int repeated = -1;
    int missing = -1;
    for (Integer anA : a) {
      if (!nums.add(anA)) {
        repeated = anA;
      }
    }
    for (int i = 1; i <= a.size(); i++) {
      if (!nums.contains(i)) {
        missing = i;
        break;
      }
    }
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(repeated);
    ans.add(missing);
    return ans;
  }


  public static void main(String[] st) {
    RepeatAndMissingNumberArray q = new RepeatAndMissingNumberArray();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(3);
    X.add(1);
    X.add(2);
    X.add(5);
    X.add(3);
    System.out.println(q.repeatedNumber(X));

    ArrayList<Integer> Y = new ArrayList<>();
    Y.add(2);
    Y.add(2);
    System.out.println(q.repeatedNumber(Y));
  }
}
