package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 7/15/2017.
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.
 Make sure the returned intervals are also sorted.
 */
public class MergeIntervals {

  private static class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }

    @Override
    public String toString() {
      return String.format("[%d,%d]", start, end);
    }
  }

  public static void main(String[] st) {
    MergeIntervals q = new MergeIntervals();
    ArrayList<Interval> intervals = new ArrayList<>();
    Interval merge = new Interval();

    intervals.add(new Interval(1, 3));
    intervals.add(new Interval(6, 9));
    merge.start = 2;
    merge.end = 5;
    System.out.println(q.insert(intervals, merge));

    intervals = new ArrayList<>();
    intervals.add(new Interval(1, 2));
    intervals.add(new Interval(3, 5));
    intervals.add(new Interval(6, 7));
    intervals.add(new Interval(8, 10));
    intervals.add(new Interval(12, 16));
    merge.start = 4;
    merge.end = 9;
    System.out.println(q.insert(intervals, merge));

    intervals = new ArrayList<>();
    intervals.add(new Interval(3, 5));
    intervals.add(new Interval(8, 10));
    merge.start = 1;
    merge.end = 12;
    System.out.println(q.insert(intervals, merge));

    intervals = new ArrayList<>();
    intervals.add(new Interval(1, 2));
    intervals.add(new Interval(8, 10));
    merge.start = 3;
    merge.end = 6;
    System.out.println(q.insert(intervals, merge));

    intervals = new ArrayList<>();
    intervals.add(new Interval(1, 2));
    intervals.add(new Interval(3, 6));
    merge.start = 8;
    merge.end = 10;
    System.out.println(q.insert(intervals, merge));
  }

  boolean isOverlap(Interval i1, Interval i2) {
    return !(i1.start > i2.end || i2.start > i1.end);
  }

  // TODO : very ugly , need to refactor
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> ans = new ArrayList<>();
    if (intervals == null || intervals.size() == 0) {
      ans.add(newInterval);
      return ans;
    }
    boolean isOverlap = false;
    for (int i = 0; i < intervals.size(); i++) {
      Interval interval = intervals.get(i);
      if (!isOverlap(interval, newInterval)) {
        ans.add(interval);
      } else {
        isOverlap = true;
        int start = Math.min(interval.start, newInterval.start);
        int end = Math.max(interval.end, newInterval.end);
        while (i < intervals.size() && isOverlap(interval, newInterval)) {
          end = Math.max(interval.end, newInterval.end);
          if (i < intervals.size() - 1) {
            interval = intervals.get(++i);
          } else {
            break;
          }
        }
        ans.add(new Interval(start, end));
        if (!isOverlap(interval, newInterval)) {
          i--;
        }
      }
    }
    if (!isOverlap) {
      for (int i = intervals.size() - 1; i >= 0; i--) {
        if (newInterval.start > intervals.get(i).end) {
          ans.add(i + 1, newInterval);
          return ans;
        }
      }
      ans.add(0, newInterval);
    }
    return ans;
  }

}
