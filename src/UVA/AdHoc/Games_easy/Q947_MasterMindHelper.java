package UVA.AdHoc.Games_easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Q947_MasterMindHelper {

  public static void main(String[] st) {
    Q947_MasterMindHelper p = new Q947_MasterMindHelper();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    sc.nextLine();
    while (cases-- > 0) {
      String guess = sc.next();
      int strong = sc.nextInt();
      int weak = sc.nextInt();
      sc.nextLine();
      long ans = solve(guess, strong, weak);
      System.out.println(ans);
    }
  }

  // using VERY ugly solution here
  // Quick and *VERY* dirty
  private long solve(String guess, int strong, int weak) {
    long cnt = 0;
    int[] guessArr = new int[guess.length()];
    for (int i = 0; i < guess.length(); i++) {
      guessArr[i] = guess.charAt(i)-'0';
    }
    List<int[]> options = allOptions(guess.length());
    for (int[] option : options) {
      if (isMatch(option, guessArr, strong, weak)) {
        cnt++;
      }
    }
    return cnt;
  }

  private List<int[]> allOptions(int n) {
    ArrayList<int[]> ans = new ArrayList<>();
    if (n == 2) {
      int[] op = new int[2];
      for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
          op[0] = i;
          op[1] = j;
          ans.add(op.clone());
        }
      }
    }
    if (n == 3) {
      int[] op = new int[3];
      for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
          for (int k = 1; k < 10; k++) {
            op[0] = i;
            op[1] = j;
            op[2] = k;
            ans.add(op.clone());
          }
        }
      }
    }
    if (n == 4) {
      int[] op = new int[4];
      for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
          for (int k = 1; k < 10; k++) {
            for (int t = 1; t < 10; t++) {
              op[0] = i;
              op[1] = j;
              op[2] = k;
              op[3] = t;
              ans.add(op.clone());
            }
          }
        }
      }
    }
    if (n == 5) {
      int[] op = new int[5];
      for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
          for (int k = 1; k < 10; k++) {
            for (int t = 1; t < 10; t++) {
              for (int u = 1; u < 10; u++) {
                op[0] = i;
                op[1] = j;
                op[2] = k;
                op[3] = t;
                op[4] = u;
                ans.add(op.clone());
              }
            }
          }
        }
      }
    }
    return ans;
  }


  private boolean isMatch(int[] cypher, int[] guess ,int expectedStrong , int expectedWeak) {
    int strong = 0;
    Set<Integer> usedCypher = new HashSet<>();
    Set<Integer> usedLine = new HashSet<>();
    for (int i = 0; i < cypher.length; i++) {
      if (cypher[i] == guess[i]) {
        strong++;
        usedCypher.add(i);
        usedLine.add(i);
      }
    }

    int weak = 0;
    for (int i = 0; i < cypher.length; i++) {
      for (int j = 0; j < guess.length; j++) {
        if (cypher[i] == guess[j] && !usedCypher.contains(i) && !usedLine.contains(j)) {
          weak++;
          usedCypher.add(i);
          usedLine.add(j);
          break;
        }
      }
    }

    return weak == expectedWeak && strong == expectedStrong;
  }
}
