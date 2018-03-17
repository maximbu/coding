package interviewbit.math;

import java.util.ArrayList;

/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 * Lets say N = size of the array. Then, following holds true :
 * All elements in the array are in the range [0, N-1]
 * N * N does not overflow for a signed integer 
 */
public class RearrangeArray {

  public static void main(String[] st) {
    RearrangeArray q = new RearrangeArray();

    ArrayList<Integer> a = new ArrayList<>();
    a.add(0);
    a.add(1);
    System.out.print(a);
    System.out.print("->");
    q.arrange(a);
    System.out.println(a);

    a = new ArrayList<>();
    a.add(3);
    a.add(2);
    a.add(0);
    a.add(1);
    System.out.print(a);
    System.out.print("->");
    q.arrange(a);
    System.out.println(a);
  }

  public void arrange(ArrayList<Integer> a) {
    int n = a.size();
    for (int i = 0; i < n; i++) {
      int val = a.get(i);
      a.set(i, val + (a.get(val) % n) * n);
    }
    for (int i = 0; i < n; i++) {
      a.set(i, a.get(i) / n);
    }
  }
}
