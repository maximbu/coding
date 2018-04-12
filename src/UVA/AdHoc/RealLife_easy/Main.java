package UVA.AdHoc.RealLife_easy;

import static java.lang.System.in;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {

  public static void main(String[] st) {
    Main p = new Main();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    Map<String,String> names = new HashMap<>();
    String line = sc.nextLine();
    String id = line.substring(0,3);
    while (!id.equals("000")){
      names.put(id,line.substring(3));
      line = sc.nextLine();
      id = line.substring(0,3);
    }
    Map<String,Map<String,Integer>> transactions = new HashMap<>();
    line = sc.nextLine();
    String seq = line.substring(0,3);
    while (!seq.equals("000")){
      transactions.putIfAbsent(seq,new HashMap<>());
      transactions.get(seq).put(line.substring(3,6),Integer.parseInt(line.substring(6).trim()));
    }
    for (String t : transactions.keySet()) {
      Map<String, Integer> tran = transactions.get(t);
      int sum = tran.values().stream().mapToInt(Integer::intValue).sum();
      if(sum != 0){
        System.out.println("*** Transaction "+t+" is out of balance ***");
        for (String action:tran.keySet()) {
          System.out.printf("%s%30s %s%n", action, names.get(action), tran.get(action) / 100.0);
        }
        System.out.printf("%30s%d%n","999 Out of Balance ", sum);
      }
    }
  }

  private String solve(List<Integer> lights) {
    int min = Integer.MAX_VALUE;
    for (Integer light : lights) {
      min = Math.min(min, light);
    }
    int i = min * 2;
    while (i <= 5 * 60 * 60) {
      boolean allGreen = true;
      for (Integer light : lights) {
        if ((i / light) % 2 == 1 || (i % light) + 5 >= light) {
          allGreen = false;
          break;
        }
      }
      if (allGreen) {
        int sec = i % 60;
        int h = i / (60 * 60);
        int m = (i / 60) - h * 60;
        return String.format("%02d:%02d:%02d", h, m, sec);
      }
      i++;
    }
    return "Signals fail to synchronise in 5 hours";
  }
}
