package UVA.AdHoc.RealLife_easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

class Q187_TransactionProcessing {

  public static void main(String[] st) {
    Q187_TransactionProcessing p = new Q187_TransactionProcessing();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    Map<String, String> names = new HashMap<>();
    String line = sc.nextLine();
    String id = line.substring(0, 3);
    while (!id.equals("000")) {
      names.put(id, line.substring(3));
      line = sc.nextLine();
      id = line.substring(0, 3);
    }
    LinkedHashMap<String, LinkedHashMap<String, Integer>> transactions = new LinkedHashMap<>();
    line = sc.nextLine();
    String seq = line.substring(0, 3);
    while (!seq.equals("000")) {
      transactions.putIfAbsent(seq, new LinkedHashMap<>());
      transactions.get(seq).put(line.substring(3, 6), Integer.parseInt(line.substring(6).trim()));
      line = sc.nextLine();
      seq = line.substring(0, 3);
    }
    for (String t : transactions.keySet()) {
      Map<String, Integer> tran = transactions.get(t);
      int sum = tran.values().stream().mapToInt(Integer::intValue).sum();
      if (sum != 0) {
        System.out.printf("*** Transaction %03d is out of balance ***%n", Integer.parseInt(t));
        for (String action : tran.keySet()) {
          System.out.printf("%03d %-30s %10.2f%n", Integer.parseInt(action), names.get(action), tran.get(action) / 100.0);
        }
        System.out.printf("999 Out of Balance                 %10.2f%n%n", sum / -100.0);
      }
    }
  }

}
