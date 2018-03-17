package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.Scanner;

class Q12577_HajjEAkbar {
  public static void main(String[] st) {
    Q12577_HajjEAkbar p = new Q12577_HajjEAkbar();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int i = 1;
    HashMap<String,String> map = new HashMap<>();
    map.put("Hajj","Hajj-e-Akbar");
    map.put("Umrah","Hajj-e-Asghar");
    while(true){
      String input = sc.nextLine();
      if(input.equals("*")) return;
      out.println("Case " + i++ + ": " + map.getOrDefault(input,"UNKNOWN"));
    }
  }
}
