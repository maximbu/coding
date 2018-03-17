package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 7/15/2017.
 * Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.

 D means the next number is smaller, while I means the next number is greater.

 Notes
 - Length of given string s will always equal to n - 1
 - Your solution should run in linear time and space.
 */
public class FindPermutation {

  public static void main(String[] st) {
    FindPermutation q = new FindPermutation();
    int n = 3;
    String s = "ID";

    System.out.println(q.findPerm(s, n));

    n = 5;
    s = "DDDD";

    System.out.println(q.findPerm(s, n));

    n = 5;
    s = "DIDD";

    System.out.println(q.findPerm(s, n));
  }


  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> findPerm(final String A, int B) {
    ArrayList<Integer> ans = new ArrayList<>();
    int highestRem  = B;
    int smallestRem = 1;

    for (char ch : A.toCharArray()) {
      ans.add(ch == 'I' ? smallestRem++ : highestRem--);
    }

    ans.add(highestRem);
    return ans;
  }
}

