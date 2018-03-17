package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by max on 6/26/2017.
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 */
public class MaximumAbsoluteDifference {

  private int dist(ArrayList<Integer> A , int i,int j){
    return Math.abs(A.get(i)-A.get(j))+j-i;
  }

  public int maxArr(ArrayList<Integer> A) {
    int maxAiPlusI = Integer.MIN_VALUE, maxAiMinusI = Integer.MIN_VALUE;
    int minAiPlusI = Integer.MAX_VALUE, minAiMinusI = Integer.MAX_VALUE;
    for (int i = 0; i < A.size(); ++i) {
      int val = A.get(i) + i;
      maxAiPlusI = Math.max(val, maxAiPlusI);
      minAiPlusI = Math.min(val, minAiPlusI);

      val = val - 2 * i;
      maxAiMinusI = Math.max(val, maxAiMinusI);
      minAiMinusI = Math.min(val, minAiMinusI);
    }

    return Math.max(maxAiPlusI - minAiPlusI, maxAiMinusI - minAiMinusI);
  }

  private int lessNaiveStillBad(ArrayList<Integer> A) {
    int maxVal =  Integer.MIN_VALUE;
    int maxInd = 0;
    int minVal = Integer.MAX_VALUE;
    int minInd = 0;
    for (int i = 0; i < A.size(); i++) {
      int val =A.get(i);
     if(val >= maxVal) {
       maxInd = i;
       maxVal = val;
     }
     if(val<minVal){
       minInd = i;
       minVal = val;
     }
    }
    int max =  Math.abs(maxVal-minVal)+Math.abs(maxInd-minInd);
    int excludeFrom = Math.min(minInd,maxInd);
    int excludeTo = Math.max(minInd,maxInd);
    for (int i = 0; i <= excludeFrom; i++) {
      for (int j = excludeTo; j < A.size(); j++) {
        max = Math.max(max,dist(A,i,j));
      }
    }
    return max;
  }

  private int naiveSolution(ArrayList<Integer> A) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < A.size(); i++) {
      for (int j = i+1; j < A.size(); j++) {
        max = Math.max(max,dist(A,i,j));
      }
    }
    return max;
  }

  public static void main(String[] st){
    MaximumAbsoluteDifference q = new MaximumAbsoluteDifference();

    ArrayList<Integer> X = new ArrayList<>();
    X.add(10);
    X.add(55);
    X.add(-8);
    X.add(43);
    X.add(52);
    X.add(8);
    X.add(59);
    X.add(-91);
    X.add(-79);
    X.add(-18);
    X.add(-94);
    System.out.println(q.maxArr(X));
  }
}
