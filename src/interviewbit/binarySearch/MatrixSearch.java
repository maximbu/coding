package interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.

 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than or equal to the last integer of the previous row.
 Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 */
public class MatrixSearch {
  public static void main(String[] st) {
    MatrixSearch q = new MatrixSearch();

    ArrayList<Integer> row0 = new ArrayList<>();
    row0.add(1);
    row0.add(3);
    row0.add(5);
    row0.add(7);
    ArrayList<Integer> row1 = new ArrayList<>();
    row1.add(10);
    row1.add(11);
    row1.add(16);
    row1.add(20);
    ArrayList<Integer> row2 = new ArrayList<>();
    row2.add(23);
    row2.add(30);
    row2.add(34);
    row2.add(50);
    ArrayList<ArrayList<Integer>> X = new ArrayList<>();
    X.add(row0);
    X.add(row1);
    X.add(row2);

    int target = 3;
    System.out.println(q.searchMatrix(X,target));

    target = 16;
    System.out.println(q.searchMatrix(X,target));

    target = 7;
    System.out.println(q.searchMatrix(X,target));

    target = 4;
    System.out.println(q.searchMatrix(X,target));

    X = new ArrayList<>();
    X.add(new ArrayList<>(Collections.singletonList(3)));
    X.add(new ArrayList<>(Collections.singletonList(29)));
    X.add(new ArrayList<>(Collections.singletonList(36)));
    X.add(new ArrayList<>(Collections.singletonList(63)));
    target = 41;

    X = new ArrayList<>();
    X.add(new ArrayList<>(Arrays.asList(2, 3, 4, 4, 5, 5, 6)));
    X.add(new ArrayList<>(Arrays.asList(10, 11, 12, 13, 13, 14, 15)));
    X.add(new ArrayList<>(Arrays.asList(16, 25, 25, 26, 28, 28, 30)));
    X.add(new ArrayList<>(Arrays.asList(30, 32, 33, 39, 39, 40, 41)));
    X.add(new ArrayList<>(Arrays.asList(44, 44, 47, 49, 51, 55, 57)));
    X.add(new ArrayList<>(Arrays.asList(57, 60, 60, 61, 61, 62, 63)));
    target = 1;
    System.out.println(q.searchMatrix(X,target));

    target = 63;
    System.out.println(q.searchMatrix(X,target));
  }

  public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
    int min = 0;
    int max = a.size()-1;
    int mid ;
    while (max >= min){
      mid = (max + min)/2;
      if(a.get(mid).get(0) == b) return 1;
      if(a.get(mid).get(0) < b && a.get(mid).get(a.get(mid).size()-1) >= b)
        return searchInRow(a.get(mid),b);
      if(a.get(mid).get(0)<b){
        min = mid + 1;
      }
      else{
        max = mid-1;
      }
    }
    return 0;
  }

  private int searchInRow(ArrayList<Integer> integers, int b) {
    int min = 0;
    int max = integers.size()-1;
    int mid;
    while (max >= min){
      mid = (max + min)/2;
      if(integers.get(mid) == b) return 1;
      if(integers.get(mid)<b){
        min = mid+1;
      }
      else{
        max = mid - 1;
      }
    }
    return 0;
  }
}
