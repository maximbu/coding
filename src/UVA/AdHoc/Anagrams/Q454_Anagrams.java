package UVA.AdHoc.Anagrams;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

class Q454_Anagrams {

  public static void main(String[] st) {
    Q454_Anagrams p = new Q454_Anagrams();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);

    int cases = sc.nextInt();
    sc.nextLine();
    sc.nextLine();
    while (cases-- > 0) {
      List<String> words = new ArrayList<>();
      String word = sc.nextLine();
      while (word.length() > 0) {
        words.add(word);
        if (!sc.hasNextLine()) break;
        word = sc.nextLine();
      }
      Map<String, List<String>> ans = solve(words);
      List<String> keys = ans.keySet().stream().sorted().collect(Collectors.toList());
      for (String key : keys) {
        List<String> vals = ans.get(key);
        Collections.sort(vals);
        for (String val : vals) {
          System.out.println(key + " = " + val);
        }

      }
      if (cases > 0) {
        System.out.println();
      }

    }
  }

  private Map<String, List<String>> solve(List<String> words) {
    Map<String, List<String>> ans = new HashMap<>();
    Collections.sort(words);
    List<String> sorted = new ArrayList<>();
    for (String word1 : words) {
      char[] ch = word1.toCharArray();
      Arrays.sort(ch);
      sorted.add(new String(ch).trim());
    }
    for (int i = 0; i < words.size(); i++) {
      for (int j = i + 1; j < words.size(); j++) {
        if (sorted.get(i).equals(sorted.get(j))) {
          ans.putIfAbsent(words.get(i), new ArrayList<>());
          ans.get(words.get(i)).add(words.get(j));
        }
      }
    }
    return ans;
  }


}
