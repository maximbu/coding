package interviewbit.arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by max on 7/15/2017.
 * Given a collection of intervals, merge all overlapping intervals.
 * Make sure the returned intervals are sorted.
 */
public class MergeOverlappingIntervals {
  private static class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
      return String.format("[%d,%d]", start, end);
    }
  }

  public static void main(String[] st) {
    MergeOverlappingIntervals q = new MergeOverlappingIntervals();
    ArrayList<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(2,6));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(1,3));
    intervals.add(new Interval(15,18));

    System.out.println(q.merge(intervals));
  }

  boolean isOverlap(Interval i1,Interval i2){
    return !(i1.start > i2.end || i2.start > i1.end);
  }

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    ArrayList<Interval> ans = new ArrayList<>();
    intervals.sort(Comparator.comparingInt(o -> o.start));
    Interval prev = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
      Interval interval = intervals.get(i);
      if(isOverlap(prev,interval)){
        Interval overlap = new Interval();
        overlap.start = Math.min(prev.start,interval.start);
        overlap.end = Math.max(prev.end,interval.end);
        prev = overlap;
      }else{
        ans.add(prev);
        prev = interval;
      }
    }
    ans.add(prev);
    return ans;
  }
}
