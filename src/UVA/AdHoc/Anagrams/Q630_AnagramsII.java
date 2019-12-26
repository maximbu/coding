package UVA.AdHoc.Anagrams;

import java.util.*;

import static java.lang.System.in;

class Q630_AnagramsII {

  public static void main(String[] st) {
    Q630_AnagramsII p = new Q630_AnagramsII();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);

    int cases = sc.nextInt();
    sc.nextLine();
    sc.nextLine();
    while (cases-- > 0) {
      int wordsCnt = sc.nextInt();
      sc.nextLine();
      List<String> words = new ArrayList<>();
      while (wordsCnt-- > 0) {
        words.add(sc.nextLine());
      }
      List<String> testWords = new ArrayList<>();
      String word = sc.nextLine();
      while (!word.equals("END")) {
        testWords.add(word);
        word = sc.nextLine();
      }
      Map<String, List<String>> ans = solve(words, testWords);
      for (String testWord : testWords) {
        List<String> vals = ans.get(testWord);
        System.out.println("Anagrams for: " + testWord);
        if (vals == null) {
          System.out.println("No anagrams for: " + testWord);
        } else {
          for (int i = 1; i <= vals.size(); i++) {
            System.out.printf("  %d) %s%n", i, vals.get(i - 1));
          }
        }

      }
      if (cases > 0) {
        System.out.println();
      }

    }
  }

  private Map<String, List<String>> solve(List<String> words,
                                          List<String> testWords) {
    Map<String, List<String>> ans = new HashMap<>();
    List<String> sorted = new ArrayList<>();
    for (String word1 : words) {
      char[] ch = word1.toCharArray();
      Arrays.sort(ch);
      sorted.add(new String(ch).trim());
    }
    List<String> sortedTest = new ArrayList<>();
    for (String word1 : testWords) {
      char[] ch = word1.toCharArray();
      Arrays.sort(ch);
      sortedTest.add(new String(ch).trim());
    }
    for (int i = 0; i < testWords.size(); i++) {
      for (int j = 0; j < words.size(); j++) {
        if (sortedTest.get(i).equals(sorted.get(j))) {
          ans.putIfAbsent(testWords.get(i), new ArrayList<>());
          ans.get(testWords.get(i)).add(words.get(j));
        }
      }
    }
    return ans;
  }


}
