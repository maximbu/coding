package UVA.AdHoc.Anagrams;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

class Q10098_GeneratingFast {

  public static void main(String[] st) {
    Q10098_GeneratingFast p = new Q10098_GeneratingFast();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    List<String> words = new ArrayList<>();
    int cases = sc.nextInt();
    sc.nextLine();
    while (cases-- > 0) {
      words.add(sc.nextLine());
    }

    List<String> ans = solve(words);
    for (String an : ans) {
      System.out.println(an);
    }
  }

  private List<String> solve(List<String> words) {
    List<String> ans = new ArrayList<>();
    for (String word : words) {
      ans.addAll(combinations(word));
      ans.add("");
    }
    return ans;
  }

  private List<String> combinations(String s) {
    Set<String> comb = new HashSet<>();
    char[] ch = s.toCharArray();
    Arrays.sort(ch);
    while (comb.add(new String(ch))) {
      nextPermutation(ch);
    }

    return comb.stream().sorted().collect(Collectors.toList());
  }

  private void nextPermutation(char[] a) {
    int startInd = -1;
    int endInd = a.length - 1;
    for (int i = a.length - 2; i >= 0; i--) {
      if (a[i] < a[i + 1]) {
        startInd = i;
        for (int j = a.length - 1; j >= 0; j--) {
          if (a[j] > a[startInd]) {
            swap(a, startInd, j);
            break;
          }
        }
        break;
      }
    }

    startInd++;
    while (startInd < endInd) {
      swap(a, startInd++, endInd--);
    }
  }

  private void swap(char[] a, int startInd, int j) {
    char tmp = a[startInd];
    a[startInd] = a[j];
    a[j] = tmp;
  }


}
