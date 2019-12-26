package UVA.AdHoc.RealLife_easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;
import static java.lang.System.out;

class Q11530_SMSTyping {

  public static void main(String[] st) {
    Q11530_SMSTyping p = new Q11530_SMSTyping();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    Map<Character, Integer> map = createMap();
    int cases = sc.nextInt();
    sc.nextLine();
    int i = 1;
    while (cases-- > 0) {
      char[] s = sc.nextLine().toCharArray();
      int sum = IntStream.range(0, s.length).map(j -> map.get(s[j])).sum();
      out.printf("Case #%d: %d%n", i++, sum);
    }
  }

  private Map<Character, Integer> createMap() {
    Map<Character, Integer> map = new HashMap<>();
    map.put('a', 1);
    map.put('b', 2);
    map.put('c', 3);
    map.put('d', 1);
    map.put('e', 2);
    map.put('f', 3);
    map.put('g', 1);
    map.put('h', 2);
    map.put('i', 3);
    map.put('j', 1);
    map.put('k', 2);
    map.put('l', 3);
    map.put('m', 1);
    map.put('n', 2);
    map.put('o', 3);
    map.put('p', 1);
    map.put('q', 2);
    map.put('r', 3);
    map.put('s', 4);
    map.put('t', 1);
    map.put('u', 2);
    map.put('v', 3);
    map.put('w', 1);
    map.put('x', 2);
    map.put('y', 3);
    map.put('z', 4);
    map.put(' ', 1);
    return map;
  }


}
