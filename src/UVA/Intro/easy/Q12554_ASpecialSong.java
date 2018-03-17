package UVA.easy;

import java.util.Scanner;

class Q12554_ASpecialSong {

  public static void main(String[] st) {
    Q12554_ASpecialSong p = new Q12554_ASpecialSong();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int peopleCnt = sc.nextInt();
    sc.nextLine();
    String[] people = new String[peopleCnt];
    int ind = 0;
    while (ind < peopleCnt) {
      people[ind++] = sc.nextLine();
    }
    ind = 0;
    String song = "Happy birthday to you "
        + "Happy birthday to you "
        + "Happy birthday to Rujia "
        + "Happy birthday to you";
    String[] words = song.split("\\s+");
    for (int i = 0; i % words.length > 0 || i < peopleCnt; i++) {
      String word = words[i%words.length];
      System.out.println(people[ind] + ": " + word);
      ind = (ind + 1) % peopleCnt;
    }
  }
}
