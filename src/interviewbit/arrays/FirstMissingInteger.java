package interviewbit.arrays;

import java.util.ArrayList;
import java.util.BitSet;


/**
 * Created by max on 7/15/2017.
 * Given an unsorted integer array, find the first missing positive integer.
 */
public class FirstMissingInteger {

  public static void main(String[] st) {
    FirstMissingInteger q = new FirstMissingInteger();
    ArrayList<Integer> X = new ArrayList<>();
    X.add(1);
    X.add(2);
    X.add(0);
    System.out.println(q.firstMissingPositive(X));

    X = new ArrayList<>();
    X.add(3);
    X.add(4);
    X.add(-1);
    X.add(1);
    System.out.println(q.firstMissingPositive(X));

    X = new ArrayList<>();
    X.add(-8);
    X.add(-7);
    X.add(-6);
    System.out.println(q.firstMissingPositive(X));

    X = new ArrayList<>();
    X.add(33);
    X.add(-42);
    X.add(2);
    X.add(1);
    System.out.println(q.firstMissingPositive(X));

    X = new ArrayList<>();
    X.add(1);
    System.out.println(q.firstMissingPositive(X));
  }

  public int firstMissingPositive(ArrayList<Integer> a) {
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) < 0) {
        a.set(i, 0);
      }
    }
    for (int i = 0; i < a.size(); i++) {
      int newInd = Math.abs(a.get(i));
      if (newInd == 0 || newInd > a.size())
        continue;

      int valAtIndex = a.get(newInd - 1);
      if (valAtIndex > 0) {
        a.set(newInd - 1, -1 * valAtIndex);
      }
      if (valAtIndex == 0) {
        a.set(newInd - 1, Integer.MAX_VALUE*-1);
      }
    }

    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) >= 0) {
        return i + 1;
      }
    }

    return a.size()+1;
  }
}
