package interviewbit.Backtracking;

import java.math.BigInteger;
import java.util.ArrayList;

public class kthPermutationSequence {

  public String getPermutation(int A, int B) {
    ArrayList<Integer> nums = new ArrayList<>();
    for (int i = 1; i <= A; i++) {
      nums.add(i);
    }
    ArrayList<Integer> ans = new ArrayList<>();
    getPermutation(nums, B - 1, ans);
    StringBuilder sb = new StringBuilder();
    for (int x : ans) {
      sb.append(x);
    }
    return sb.toString();
  }

  private void getPermutation(ArrayList<Integer> nums, int B, ArrayList<Integer> ans) {
    int n = nums.size();
    if (n == 1) {
      ans.add(nums.get(0));
      return;
    }
    /*
    BigInteger fact = factorial(n - 1);
    int ind = new BigInteger(String.valueOf(B)).divide(fact).intValue();
    */
    int fact = factorial2(n - 1);
    int ind = B / fact;
    ans.add(nums.get(ind));
    nums.remove(ind);
    //getPermutation(nums, new BigInteger(String.valueOf(B)).mod(fact).intValue(), ans);
    getPermutation(nums, B % fact, ans);
  }

  private BigInteger factorial(int n) {
    BigInteger ans = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
      ans = ans.multiply(new BigInteger(String.valueOf(i)));
    }
    return ans;
  }

  private int factorial2(int n) {
    if (n > 12) {
      return Integer.MAX_VALUE;
    }
    int fact = 1;
    for (int i = 2; i <= n; i++)
      fact *= i;
    return fact;
  }

  public static void main(String[] st) {
    kthPermutationSequence q = new kthPermutationSequence();
    System.out.println(q.getPermutation(4, 7));
    System.out.println(q.getPermutation(3, 5));
    System.out.println(q.getPermutation(8, 3));
    System.out.println(q.getPermutation(20, 20));
  }

}
