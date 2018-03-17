package UVA.Intro.medium;

import java.util.Scanner;

class Q11507_BenderBRodríguezProblem {

  public static void main(String[] st) {
    Q11507_BenderBRodríguezProblem p = new Q11507_BenderBRodríguezProblem();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int len = sc.nextInt();
      if (len == 0)
        return;
      sc.nextLine();
      String[] input = sc.nextLine().split("\\s+");
      String ans = solve(input);
      System.out.println(ans);
    }
  }

  private String solve(String[] input) {
    String currDir = "+x";
    for (String anInput : input) {
      currDir = handle(currDir, anInput);
    }
    return currDir;
  }

  private String handle(String currDir , String bend) {
    String[] yRotation = {"+x", "+y", "-x", "-y"};
    String[] zRotation = {"+x", "+z", "-x", "-z"};
    switch (bend) {
      case "+y":
        return newDir(yRotation, currDir, 1);
      case "+z":
        return newDir(zRotation, currDir, 1);
      case "-y":
        return newDir(yRotation, currDir, -1);
      case "-z":
        return newDir(zRotation, currDir, -1);
      default:
        return currDir;
    }
  }

  private String newDir(String[] arr, String currDir, int inc) {
    for (int i = 0; i < arr.length; i++) {
      if(arr[i].equals(currDir)){
        return arr[(i+inc+arr.length) % arr.length];
      }
    }
    return currDir;
  }

}
