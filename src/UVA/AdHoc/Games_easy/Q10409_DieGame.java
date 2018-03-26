package UVA.AdHoc.Games_easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q10409_DieGame {

  public static void main(String[] st) {
    Q10409_DieGame p = new Q10409_DieGame();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int cases = sc.nextInt();
      if(cases == 0) return;
      sc.nextLine();
      List<String> directions = new ArrayList<>();
      while (cases-- > 0){
        String direction = sc.nextLine();
        directions.add(direction);
      }
      int ans = solve(directions);
      System.out.println(ans);
    }
  }

  private int solve(List<String> directions) {
    int[] die = {1,2,3,5,4,6};
    for (String dir:directions) {
      die = rotate(die,dir);
    }
    return die[0];
  }

  private int[] rotate(int[] die, String dir) {
    int[] tmp = new int[6];
    System.arraycopy(die, 0, tmp, 0, 6);
    switch (dir){
      case "north":{
        tmp[0]=die[3];
        tmp[3]=die[5];
        tmp[5]=die[1];
        tmp[1]=die[0];
        return tmp;
      }
      case "west":{
        tmp[0]=die[4];
        tmp[4]=die[5];
        tmp[5]=die[2];
        tmp[2]=die[0];
        return tmp;
      }
      case "south":{
        tmp[0]=die[1];
        tmp[1]=die[5];
        tmp[5]=die[3];
        tmp[3]=die[0];
        return tmp;
      }
      case "east":{
        tmp[0]=die[2];
        tmp[2]=die[5];
        tmp[5]=die[4];
        tmp[4]=die[0];
        return tmp;
      }
      default:return die;
    }
  }

  private String solve(int[] line) {
    int day = 0;
    int height = line[0];
    int distancePerDay = line[1];
    int slidePerNight = line[2];
    int fatigue = line[3];
    double currPos = 0;
    double totalFatigue = 0;
    while (true) {
      day++;

      currPos += Math.max(0, distancePerDay - totalFatigue);

      if (currPos > height)
        return "success on day " + day;

      currPos -= slidePerNight;

      if (currPos < 0)
        return "failure on day " + day;

      totalFatigue += distancePerDay * fatigue / 100.0;
    }
  }
}
