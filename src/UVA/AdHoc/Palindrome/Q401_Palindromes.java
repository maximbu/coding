package UVA.AdHoc.Palindrome;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

class Q401_Palindromes {
  public static void main(String[] st) {
    Q401_Palindromes p = new Q401_Palindromes();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    HashMap<Character, Character> mirror = getMirrorMap();
    while (sc.hasNextLine()) {
      String input = sc.nextLine().trim();
      boolean isPalindrome = isPalindrome(input);
      boolean isMirror = isMirror(input,mirror);
      if(isPalindrome && isMirror){
        out.println(input+ " -- is a mirrored palindrome.");
      }
      else if(isPalindrome){
        out.println(input+ " -- is a regular palindrome.");
      }
      else if(isMirror){
        out.println(input+ " -- is a mirrored string.");
      }
      else {
        out.println(input+ " -- is not a palindrome.");
      }
      out.println();
    }
  }

  private boolean isMirror(String st,HashMap<Character, Character> mirror) {
    return IntStream.range(0, (1+st.length())/2)
        .allMatch(i -> mirror.getOrDefault(st.charAt(i),'?') == st.charAt(st.length() - i - 1));
  }

  private HashMap<Character, Character> getMirrorMap() {
    HashMap<Character,Character> mirror = new HashMap<>();
    mirror.put('A','A');
    mirror.put('E','3');
    mirror.put('H','H');
    mirror.put('I','I');
    mirror.put('J','L');
    mirror.put('L','J');
    mirror.put('M','M');
    mirror.put('O','O');
    mirror.put('S','2');
    mirror.put('T','T');
    mirror.put('U','U');
    mirror.put('V','V');
    mirror.put('W','W');
    mirror.put('X','X');
    mirror.put('Y','Y');
    mirror.put('Z','5');
    mirror.put('1','1');
    mirror.put('2','S');
    mirror.put('3','E');
    mirror.put('5','Z');
    mirror.put('8','8');
    return mirror;
  }

  private boolean isPalindrome(String st) {
    return IntStream.range(0, st.length()/2)
        .allMatch(i -> st.charAt(i) == st.charAt(st.length() - i - 1));
  }

}
