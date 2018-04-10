package UVA.AdHoc.Anagrams;

import static java.lang.System.in;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Q156_Ananagrams {

  public static void main(String[] st) {
    Q156_Ananagrams p = new Q156_Ananagrams();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    List<String> words = new ArrayList<>();
    String word = sc.next();
    while (!word.equals("#")) {
      words.add(word);
      word = sc.next();
    }

    List<String> ans = solve(words);
    for (String an : ans) {
      System.out.println(an);
    }
  }

  private List<String> solve(List<String> words) {
    List<String> ans = new ArrayList<>();
    List<String> wordsSorted = words.stream().map(this::sort).collect(Collectors.toList());
    for (int i = 0; i < wordsSorted.size(); i++) {
      boolean isAnAnagram = true;
      for (int j = 0; j < wordsSorted.size(); j++) {
        if (i == j)
          continue;
        if (wordsSorted.get(i).equals(wordsSorted.get(j))) {
          isAnAnagram = false;
          break;
        }
      }
      if (isAnAnagram) {
        ans.add(words.get(i));
      }
    }
    Collections.sort(ans);
    return ans;
  }

  private String sort(String s) {
    char[] chars = s.toLowerCase().toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }


}
