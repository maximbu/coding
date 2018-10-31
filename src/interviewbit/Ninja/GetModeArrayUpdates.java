package interviewbit.Ninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * You are given an array of N positive integers, A1, A2 ,…, AN.
 * Also, given a Q updates of form:
 *
 * i j: Update Ai = j. 1 ≤ i ≤ N.
 * Perform all updates and after each such update report mode of the array. Therefore, return an array of Q elements, where ith element is mode of the array after ith update has been executed.
 *
 * Notes
 *
 * Mode is the most frequently occuring element on the array.
 * If multiple modes are possible, return the smallest one.
 * Update array input is via a Q*2 array, where each row represents a update.
 * For example,
 *
 * A=[2, 2, 2, 3, 3]
 *
 * Updates=    [ [1, 3] ]
 *             [ [5, 4] ]
 *             [ [2, 4] ]
 *
 * A = [3, 2, 2, 3, 3] after 1st update.
 * 3 is mode.
 *
 * A = [3, 2, 2, 3, 4] after 2nd update.
 * 2 and 3 both are mode. Return smaller i.e. 2.
 *
 * A = [3, 4, 2, 3, 4] after 3rd update.
 * 3 and 4 both are mode. Return smaller i.e. 3.
 *
 * Return array [3, 2, 3].
 * Constraints
 * 1 ≤ N, Q ≤ 105
 * 1 ≤ j, Ai ≤ 109
 */
public class GetModeArrayUpdates {
  class Data{
    int num;
    int cnt;

    public Data(int n,int c){
      num = n;
      cnt = c;
    }

    @Override
    public String toString() {
      return "Data{" +
              "num=" + num +
              ", cnt=" + cnt +
              '}';
    }
  }

  public ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
    PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> {
      int cnt = Integer.compare(o2.cnt, o1.cnt);
      if (cnt != 0)
        return cnt;
      return Integer.compare(o1.num, o2.num);
    });
    HashMap<Integer, Data> map = new HashMap<>();
    ArrayList<Integer> ans = new ArrayList<>();
    for (int x : A) {
      if (map.containsKey(x)) {
        Data d = map.get(x);
        d.cnt++;
      } else {
        Data d = new Data(x, 1);
        map.put(x, d);
      }
    }
    pq.addAll(map.values());
    for (ArrayList<Integer> change : B) {
      int oldX = A.get(change.get(0) - 1);
      int newX = change.get(1);
      A.set(change.get(0) - 1, newX);

      updateVal(pq, map, oldX,-1);
      updateVal(pq, map, newX,1);

      ans.add(pq.peek().num);
    }
    return ans;
  }

  private void updateVal(PriorityQueue<Data> pq, HashMap<Integer, Data> map, int val,int change) {
    if (map.containsKey(val)) {
      Data d = map.get(val);
      d.cnt+=change;
      pq.remove(d);
      pq.add(d);
    }
    else {
      Data d = new Data(val, change);
      map.put(val, d);
      pq.add(d);
    }
  }

  public static void main(String[] st){
    GetModeArrayUpdates q = new GetModeArrayUpdates();
    ArrayList<ArrayList<Integer>> updates = new ArrayList<>();
    updates.add(new ArrayList<>(Arrays.asList(1,3)));
    updates.add(new ArrayList<>(Arrays.asList(5,4)));
    updates.add(new ArrayList<>(Arrays.asList(2,4)));
    System.out.println(q.getMode(new ArrayList<>(Arrays.asList(2, 2, 2, 3, 3)),updates));
  }
}


