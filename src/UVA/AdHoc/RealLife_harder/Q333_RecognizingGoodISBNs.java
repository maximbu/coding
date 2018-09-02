package UVA.AdHoc.RealLife_harder;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q333_RecognizingGoodISBNs {

  public static void main(String[] st) {
    Q333_RecognizingGoodISBNs p = new Q333_RecognizingGoodISBNs();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String ans = solve(line.trim());
      out.println(ans);
    }
  }

  private String solve(String s) {
    if(s.length() < 10) return s+" is incorrect.";
    List<Integer> nums = new ArrayList<>();
    char[] chars = s.toCharArray();
    for (char c:chars) {
      if (c == '-' || Character.isWhitespace(c))
        continue;
      if (Character.isDigit(c)) {
        nums.add(c - '0');
      } else if (nums.size() == 9 && c == 'X') {
        nums.add(10);
      } else
        return s + " is incorrect.";
    }
    if(nums.size() != 10) {
      return s+" is incorrect.";
    }
    List<Integer> partSums = new ArrayList<>();
    partSums.add(nums.get(0));
    for (int i = 1; i < nums.size(); i++) {
      partSums.add(nums.get(i)+partSums.get(i-1));
    }
    List<Integer> sums = new ArrayList<>();
    sums.add(partSums.get(0));
    for (int i = 1; i < partSums.size(); i++) {
      sums.add(partSums.get(i)+sums.get(i-1));
    }
    return s+" is "+(sums.get(9)%11==0?"":"in")+"correct.";
  }


}
