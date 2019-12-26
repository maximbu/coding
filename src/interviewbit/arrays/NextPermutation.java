package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 7/15/2017.
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

 If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

 The replacement must be in-place, do not allocate extra memory.
 Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 Warning : DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 */
public class NextPermutation {
  public static void main(String[] st) {
    NextPermutation q = new NextPermutation();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(1);
    X.add(2);
    X.add(3);

    System.out.print(X + " -> ");
    q.nextPermutation(X);
    System.out.println(X);

    X = new ArrayList<>();
    X.add(3);
    X.add(2);
    X.add(1);

    System.out.print(X + " -> ");
    q.nextPermutation(X);
    System.out.println(X);

    X = new ArrayList<>();
    X.add(1);
    X.add(1);
    X.add(5);

    System.out.print(X + " -> ");
    q.nextPermutation(X);
    System.out.println(X);

    X = new ArrayList<>();
    X.add(20);
    X.add(50);
    X.add(113);

    System.out.print(X + " -> ");
    q.nextPermutation(X);
    System.out.println(X);
  }

  public void swap(int i, int j, ArrayList<Integer> a) {
    int tmp = a.get(i);
    a.set(i, a.get(j));
    a.set(j, tmp);
  }

  public void nextPermutation(ArrayList<Integer> a) {
    int startInd = -1;
    int endInd = a.size() - 1;
    for (int i = a.size() - 2; i >= 0; i--) {
      if (a.get(i) < a.get(i + 1)) {
        startInd = i;
        for (int j = a.size() - 1; j >= 0; j--) {
          if (a.get(j) > a.get(startInd)) {
            swap(startInd, j, a);
            break;
          }
        }
        break;
      }
    }

    startInd++;
    while (startInd < endInd) {
      swap(startInd++, endInd--, a);
    }
  }
}
