package UVA.AdHoc.Palindrome;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q10945_MotherBear {
  public static void main(String[] st) {
    Q10945_MotherBear p = new Q10945_MotherBear();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    while (true) {
      String input = sc.nextLine();
      if (input.equals("DONE")) return;
      if (isPalindrome(input)) {
        out.println("You won't be eaten!");
      } else {
        out.println("Uh oh..");
      }
    }
  }

  private boolean isPalindrome(String st) {
    int start = 0;
    int end = st.length() - 1;
    char[] str = st.toCharArray();
    while (start < end) {
      while (!Character.isLetter(str[start]) && (start < end)) {
        start++;
      }
      while (!Character.isLetter(str[end]) && (start < end)) {
        end--;
      }
      if (!Character.isLetter(str[start]) && !Character.isLetter(str[end])) return true;
      if (Character.toLowerCase(str[start]) != Character.toLowerCase(str[end])) return false;
      start++;
      end--;
    }
    return true;
  }

}
