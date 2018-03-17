package interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 *You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

 2 painters cannot share a board to paint. That is to say, a board
 cannot be painted partially by one painter, and partially by another.
 A painter will only paint contiguous boards. Which means a
 configuration where painter 1 paints board 1 and 3 but not 2 is
 invalid.
 Return the ans % 10000003
 */
public class PaintersPartitionProblem {
  public static void main(String[] st){
    PaintersPartitionProblem q = new PaintersPartitionProblem();

    int numOfPainters = 2;
    int timeTakenToPaintOneBoard = 5;
    ArrayList<Integer> L = new ArrayList<>();
    L.add(1);
    L.add(10);

    System.out.println(q.paint(numOfPainters,timeTakenToPaintOneBoard,L));

    numOfPainters = 1;
    timeTakenToPaintOneBoard = 1000000;
    L = new ArrayList<>();
    L.add(1000000);
    L.add(1000000);

    System.out.println(q.paint(numOfPainters,timeTakenToPaintOneBoard,L));
  }

  public int paint(int a, int b, ArrayList<Integer> c) {
    long min = c.stream().min(Integer::compareTo).get()*(long)b;
    long max = c.stream().mapToInt(m -> m).sum()*(long)b;
    long mid;
    while (max >=min){
      mid = min + (max - min)/2;
      if(canPaintIn(mid,a,b,c)){
        max = mid-1;
      }
      else{
        min=mid+1;
      }
    }
    return (int)(min % 10000003);
  }

  private boolean canPaintIn(long t, int a,int b, ArrayList<Integer> c) {
    int board = 0;
    for (int i = 0; i < a; i++) {
      long left = t;
      while((board < c.size()) && (c.get(board)*(long)b<=left)){
        left-=c.get(board)*(long)b;
        board++;
      }
      if(board == c.size()) return true;
    }
    return false;
  }
}
