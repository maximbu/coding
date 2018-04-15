package UVA.AdHoc.RealLife_easy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q10191_LongestNap {

  public static void main(String[] st) {
    Q10191_LongestNap p = new Q10191_LongestNap();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int day = 0;
    while (sc.hasNextLine()) {
      int size = sc.nextInt();
      sc.nextLine();
      day++;
      List<CalEntry> tasks = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        String[] input = sc.nextLine().split("\\s+");
        CalEntry t = new CalEntry(input[0], input[1]);
        tasks.add(t);
      }
      CalEntry sleep = solve(tasks);

      out.printf("Day #%d: the longest nap starts at %s and will last for %s%n", day,
          sleep.getStartTime(), sleep.getLenAsString());
    }
  }

  private CalEntry solve(List<CalEntry> tasks) {
    if(tasks.size() == 0){
      return new CalEntry("10:00","18:00");
    }
    tasks.sort((t1,t2)->{
      if(t1.startH != t2.startH){
        return (t1.startH - t2.startH);
      }
      return t1.startM - t2.startM;
    });
    CalEntry ans = new CalEntry("10:00",tasks.get(0).getStartTime());
    int diff = ans.len;
    for (int i = 1; i < tasks.size(); i++) {
      String end = tasks.get(i).getStartTime();
      String start = tasks.get(i - 1).getEndTime();
      CalEntry a = new CalEntry(start,end);
      if(a.len > diff){
        diff = a.len;
        ans = a;
      }
    }
    CalEntry end = new CalEntry(tasks.get(tasks.size() - 1).getEndTime(), "18:00");
    if(end.len > diff){
      ans = end;
    }
    return ans;
  }


  private class CalEntry {

    private String from;
    private String to;
    int startH;
    int startM;
    int endH;
    int endM;
    int len;

    public CalEntry(String from, String to) {
      this.from = from;
      this.to = to;
      startH = Integer.valueOf(from.substring(0, 2));
      startM = Integer.valueOf(from.substring(3));
      endH = Integer.valueOf(to.substring(0, 2));
      endM = Integer.valueOf(to.substring(3));
      len = (endH - startH) * 60 + endM - startM;
    }

    public String getStartTime() {
      return from;
    }

    public String getLenAsString() {
      return len < 60 ? String.format("%d minutes.", len) : String
          .format("%d hours and %d minutes.", len / 60, len % 60);
    }

    public String getEndTime() {
      return to;
    }
  }
}
