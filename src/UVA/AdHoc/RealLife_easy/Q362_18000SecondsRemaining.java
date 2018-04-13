package UVA.AdHoc.RealLife_easy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q362_18000SecondsRemaining {

  public static void main(String[] st) {
    Q362_18000SecondsRemaining p = new Q362_18000SecondsRemaining();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int i = 0;
    while (true) {
      int fileSize = sc.nextInt();
      i++;
      if (fileSize == 0)
        return;
      List<Double> rates = new ArrayList<>();
      int ind=0;
      int sum = 0;
      int currSum = 0;
      while (sum < fileSize) {
        ind++;
        int t = sc.nextInt();
        currSum+= t;
        sum += t;
        if(ind % 5 == 0){
          int left = fileSize - sum;
          double newRate = currSum == 0 ? -1 : left / (currSum * 0.2);
          rates.add(newRate);
          currSum = 0;
        }
      }
      out.printf("Output for data set %d, %d bytes:%n", i, fileSize);
      for (Double rate : rates) {
        if (rate > -1) {
          out.printf("   Time remaining: %.0f seconds%n", Math.ceil(rate));
        } else {
          out.printf("   Time remaining: stalled%n");
        }
      }
      out.printf("Total time: %d seconds%n%n", ind);
    }
  }

}
