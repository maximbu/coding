package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by max on 7/1/2017.
 * Given an array of integers, sort the array into a wave like array and return it,
 In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 */
public class WaveArray {
  public static void main(String[] st) {
    WaveArray q = new WaveArray();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(3);
    X.add(30);
    X.add(34);
    X.add(5);
    X.add(9);

    System.out.println(q.wave(X));

    X = new ArrayList<>();
    X.add(1);
    X.add(2);
    X.add(3);
    X.add(4);

    System.out.println(q.wave(X));
  }

  public ArrayList<Integer> wave(ArrayList<Integer> a) {
    Collections.sort(a);
    for (int i = 0; i < a.size() - 1; i += 2) {
      int tmp = a.get(i);
      a.set(i, a.get(i + 1));
      a.set(i + 1, tmp);
    }
    return a;
  }

}
