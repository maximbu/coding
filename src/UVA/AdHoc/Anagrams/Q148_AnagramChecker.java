package UVA.AdHoc.Anagrams;

import static java.lang.System.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q148_AnagramChecker {

  public static void main(String[] st) {
    Q148_AnagramChecker p = new Q148_AnagramChecker();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    List<String> words = new ArrayList<>();
    String word = sc.nextLine();
    while (!word.equals("#")) {
      words.add(word);
      word = sc.nextLine();
    }
    List<String> phrases = new ArrayList<>();
    String phrase = sc.nextLine();
    while (!phrase.equals("#")) {
      phrases.add(phrase);
      phrase = sc.nextLine();
    }
    solve(phrases, words);
  }

  private void solve(List<String> phrases, List<String> words) {
    for (String phrase : phrases) {
      List<List<String>> ans = findAnagrams(phrase, words);

      for (List<String> an : ans) {
        StringBuilder sb = new StringBuilder();
        sb.append(phrase);
        sb.append(" =");
        for (String word : an) {
          sb.append(" ");
          sb.append(word);
        }
        System.out.println(sb.toString());
      }
    }
  }

  private List<List<String>> findAnagrams(String s, List<String> words) {
    String withoutSpaces = s.replaceAll("\\s", "");
    return allOptionsOfSize(words, withoutSpaces, s);
  }

  private boolean isAnagram(String s, List<String> option) {
    int[] chars = fillDiffs(s, option);

    return IntStream.range(0, chars.length).allMatch(i -> chars[i] == 0);
  }

  private int[] fillDiffs(String s, List<String> option) {
    int[] chars = new int['Z' - 'A' + 1];
    for (int i = 0; i < s.length(); i++) {
      chars[s.charAt(i) - 'A']++;
    }
    for (String anOption : option) {
      for (int j = 0; j < anOption.length(); j++) {
        chars[anOption.charAt(j) - 'A']--;
      }
    }
    return chars;
  }

  private List<List<String>> allOptionsOfSize(List<String> words, String st, String full) {
    List<List<String>> ops = new ArrayList<>();
    allOptionsOfSize(words, 0, st, full, new ArrayList<>(), ops);
    return ops;
  }

  private void allOptionsOfSize(List<String> words, int i, String st, String full,
      List<String> currOp, List<List<String>> ops) {
    int len = currOp.stream().mapToInt(String::length).sum();
    if (len == st.length() && isAnagram(st, currOp)) {
      ops.add(currOp);
      return;
    }
    if (len > st.length() || i == words.size())
      return;

    if (goodWord(words.get(i), st, full, currOp, len)) {
      List<String> withIWord = new ArrayList<>(currOp);
      withIWord.add(words.get(i));
      allOptionsOfSize(words, i + 1, st, full, withIWord, ops);
    }

    IntStream.range(i + 1, words.size()).filter(j -> goodWord(words.get(j), st, full, currOp, len))
        .findFirst().ifPresent(j -> allOptionsOfSize(words, j, st, full, currOp, ops));

  }

  private boolean goodWord(String word, String st, String full, List<String> currOp,
      int len) {
    return notWordInSt(full, word) && st.length() >= (len + word.length()) && canBeAnagram(st,
        currOp, word);
  }

  private boolean canBeAnagram(String s, List<String> currOp, String newWord) {
    int[] chars = fillDiffs(s, currOp);

    for (int j = 0; j < newWord.length(); j++) {
      chars[newWord.charAt(j) - 'A']--;
    }

    return IntStream.range(0, chars.length).allMatch(i -> chars[i] >= 0);
  }


  private boolean notWordInSt(String s, String word) {
    return !s.contains(" " + word + " ") && !s.startsWith(word + " ") && !s.equals(word) && !s
        .endsWith(" " + word);
  }


}
