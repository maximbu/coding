package UVA.AdHoc.RealLife_easy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q12195_JingleComposing {

  public static void main(String[] st) {
    Q12195_JingleComposing p = new Q12195_JingleComposing();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    HashMap<Character,Integer> map = new HashMap<>();
    map.put('W',64);
    map.put('H',32);
    map.put('Q',16);
    map.put('E',8);
    map.put('S',4);
    map.put('T',2);
    map.put('X',1);
    while (true) {
      String s = sc.nextLine();
      if(s.equals("*")) return;
      String[] input = s.split("/");
      int cnt = (int) Arrays.stream(input).map(String::toCharArray)
          .mapToInt(chars -> IntStream.range(0, chars.length).map(j -> map.get(chars[j])).sum())
          .filter(sum -> sum == 64).count();
      out.println(cnt);
    }
  }

}
