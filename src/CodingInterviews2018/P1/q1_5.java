package CodingInterviews2018.P1;

public class q1_5 {
  private static boolean isOneAway(String s1, String s2) {
    char[] s1Chars = s1.toCharArray();
    char[] s2Chars = s2.toCharArray();
    if (s1Chars.length == s2Chars.length) {
      return isOneEditAway(s1Chars, s2Chars);
    }
    if (s1Chars.length == s2Chars.length + 1) {
      return isOneAddAway(s2Chars, s1Chars);
    }
    if (s1Chars.length + 1 == s2Chars.length) {
      return isOneAddAway(s1Chars, s2Chars);
    }
    return false;
  }

  private static boolean isOneEditAway(char[] s1, char[] s2) {
    boolean diffFound = false;
    for (int i = 0; i < s1.length; i++) {
      if (s1[i] != s2[i]) {
        if (diffFound) return false;
        diffFound = true;
      }
    }
    return true;
  }

  private static boolean isOneAddAway(char[] s1, char[] s2) {
    int diffFound = 0;
    for (int i = 0; i < s1.length; i++) {
      if (s1[i] != s2[i + diffFound]) {
        if (diffFound != 0) return false;
        diffFound = 1;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    System.out.println("isOneAway(pale,ple)" + "->" + isOneAway("pale", "ple"));
    System.out.println("isOneAway(pales,pale)" + "->" + isOneAway("pales", "pale"));
    System.out.println("isOneAway(pale,bale)" + "->" + isOneAway("pale", "bale"));
    System.out.println("isOneAway(pale,bake)" + "->" + isOneAway("pale", "bake"));
  }
}
