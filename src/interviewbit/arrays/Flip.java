package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 6/27/2017.
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN.
 * In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N
 * and flip the characters SL, SL+1, …, SR.
 * By flipping, we mean change character 0 to 1 and vice-versa.
 * Your aim is to perform ATMOST one operation such that in final string number
 * of 1s is maximised. If you don’t want to perform the operation,
 * return an empty array. Else, return an array consisting of two
 * elements denoting L and R.
 * If there are multiple solutions, return the lexicographically smallest pair of L and R.
 */
public class Flip {

  public static void main(String[] st) {
    Flip q = new Flip();

    String S = "010";
    String S2 = "111";
    String S3 = "1101";
    System.out.println(q.flip(S));
    System.out.println(q.flip(S2));
    System.out.println(q.flip(S3));
  }

  public ArrayList<Integer> flip(String A) {
    int[] arr = new int[A.length()];

    int initialCnt = 0;
    for (int i = 0; i < arr.length; i++) {
      char c = A.charAt(i);
      if (c == '1') {
        initialCnt++;
        arr[i] = -1;
      } else {
        arr[i] = 1;
      }
    }

    if (initialCnt == A.length()) // all 1s
      return new ArrayList<>();

    if (initialCnt == 0) { // all 0s
      ArrayList<Integer> ans = new ArrayList<>();
      ans.add(1);
      ans.add(A.length());
      return ans;
    }

    return Kadane(arr);
  }

  private ArrayList<Integer> Kadane(int[] arr) {
    ArrayList<Integer> ans = new ArrayList<>();
    int maxSoFar = Integer.MIN_VALUE;
    int maxEndingHere = 0;
    int tempI = 0;
    int bestI = arr.length;
    int bestJ = arr.length;

    for (int i = 0; i < arr.length; i++) {
      maxEndingHere += arr[i];

      if (maxEndingHere > maxSoFar) {
        maxSoFar = maxEndingHere;
        bestI = tempI;
        bestJ = i;
      }

      if (maxEndingHere < 0) {
        maxEndingHere = 0;
        tempI = i + 1;
      }
    }

    ans.add(bestI + 1);
    ans.add(bestJ + 1);
    return ans;
  }

  private ArrayList<Integer> naiveSolution(String A) {
    char[] arr = A.toCharArray();
    ArrayList<Integer> ans = new ArrayList<>();
    int initialCnt = 0;
    for (char c : arr) {
      if (c == '1') {
        initialCnt++;
      }
    }
    int max = 0;
    int bestI = arr.length;
    int bestJ = arr.length;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '1') continue;
      int numOfOnes = initialCnt;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] == '1') {
          numOfOnes--;
        } else {
          numOfOnes++;
          if (numOfOnes > max) {
            max = numOfOnes;
            bestI = i;
            bestJ = j;
          } else if (numOfOnes == max && (i < bestI || (i == bestI && j < bestJ))) {
            bestI = i;
            bestJ = j;
          }
        }
      }
    }
    if (max > initialCnt) {
      ans.add(bestI + 1);
      ans.add(bestJ + 1);
    }
    return ans;
  }

}
