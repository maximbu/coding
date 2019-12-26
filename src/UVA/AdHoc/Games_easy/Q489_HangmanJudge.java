package UVA.AdHoc.Games_easy;

import java.util.HashSet;
import java.util.Scanner;

class Q489_HangmanJudge {

  public static final boolean DEBUG = false;

  public static void main(String[] st) {
    Q489_HangmanJudge p = new Q489_HangmanJudge();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int round = sc.nextInt();
      if (round == -1) {
        return;
      }
      sc.nextLine();
      String word = sc.nextLine();
      String guesses = sc.nextLine();
      System.out.println("Round " + round);
      int ans = solve(word , guesses);
      if(DEBUG){
        System.out.println("word: " + word + " , guesses:" + guesses);
      }
      if(ans == 1){
        System.out.println("You win.");
      }
      if(ans == -1){
        System.out.println("You lose.");
      }
      if(ans == 0){
        System.out.println("You chickened out.");
      }
    }
  }

  private int solve(String wordStr, String guessesStr) {
    boolean[] correct = new boolean[wordStr.length()];
    char[] word = wordStr.toCharArray();
    char[] guesses = guessesStr.toCharArray();
    HashSet<Character> wrongGuesses = new HashSet<>();
    for (char guess : guesses) {
      boolean found = false;
      for (int j = 0; j < word.length; j++) {
        if (word[j] == guess) {
          correct[j] = true;
          found = true;
        }
      }
      if (!found) {
        wrongGuesses.add(guess);
      }
      if(wrongGuesses.size() > 6) return -1;
      if(isAllCorrect(correct)) return 1;
    }
    return 0;
  }

  private boolean isAllCorrect(boolean[] correct) {
    boolean allCorrect = true;
    for (boolean l : correct) {
      if (!l) {
        allCorrect = false;
        break;
      }
    }
    return allCorrect;
  }


}
