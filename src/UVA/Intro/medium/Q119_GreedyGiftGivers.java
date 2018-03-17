package UVA.Intro.medium;

import java.util.HashMap;
import java.util.Scanner;

class Q119_GreedyGiftGivers {

  public static void main(String[] st) {
    Q119_GreedyGiftGivers p = new Q119_GreedyGiftGivers();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    boolean first = true;
    while (sc.hasNextLine()) {
      if(!first){
        System.out.println();
      }
      first = false;
      int people = sc.nextInt();
      sc.nextLine();
      String[] names = sc.nextLine().split("\\s+");
      HashMap<String, Integer> map = new HashMap<>();
      for (int i = 0; i < people; i++) {
        map.put(names[i], i);
      }
      int[] ownings = new int[people];
      for (int i = 0; i < people; i++) {
        String[] line = sc.nextLine().split("\\s+");
        String name = line[0];
        int amount = Integer.parseInt(line[1]);
        int paysTo = Integer.parseInt(line[2]);
        if(paysTo > 0) {
          ownings[map.get(name)] -= paysTo * (amount / paysTo);
          for (int j = 3; j < line.length; j++) {
            ownings[map.get(line[j])] += (amount / paysTo);
          }
        }
      }
      for (int i = 0; i < people; i++) {
        System.out.println(names[i] + " " + ownings[i]);
      }
    }
  }
}
