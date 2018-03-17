package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 6/25/2017.
 */
public class AddOneToNum {

  public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
    int carry = 1;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = a.size() - 1; i >= 0; i--) {
      int val = a.get(i) + carry;
      ans.add(0, val % 10);
      carry = val / 10;
    }
    if (carry > 0) {
      ans.add(0, carry);
    }

    for (int i = 0; i < ans.size() && (ans.get(i) == 0);) {
      ans.remove(i);
    }

    return ans;
  }

  public static void main(String[] st){
    AddOneToNum q = new AddOneToNum();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(0);
    X.add(0);
    X.add(9);
    X.add(9);
    X.add(9);

    System.out.println(q.plusOne(X));
  }
}
