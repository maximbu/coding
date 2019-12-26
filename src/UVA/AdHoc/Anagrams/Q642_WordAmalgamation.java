package UVA.AdHoc.Anagrams;

import java.util.*;

import static java.lang.System.in;

class Q642_WordAmalgamation {

  public static void main(String[] st) {
    Q642_WordAmalgamation p = new Q642_WordAmalgamation();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    List<String> words = new ArrayList<>();
    String word = sc.nextLine();
    while (!word.equals("XXXXXX")) {
      words.add(word);
      word = sc.nextLine();
    }
    List<String> testWords = new ArrayList<>();
    word = sc.nextLine();
    while (!word.equals("XXXXXX")) {
      testWords.add(word);
      word = sc.nextLine();
    }
    Map<String, List<String>> ans = solve(words, testWords);
    for (String testWord : testWords) {
      List<String> vals = ans.get(testWord);
      if (vals == null) {
        System.out.println("NOT A VALID WORD");
      } else {
        Collections.sort(vals);
        for (String val : vals) {
          System.out.println(val);
        }
      }
      System.out.println("******");
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
