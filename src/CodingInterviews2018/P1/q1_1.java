package CodingInterviews2018.P1;

import java.util.Arrays;

public class q1_1 {
  private static boolean isUniqueNaive(String s){
    boolean arr [] = new boolean[256];
    for(char ch:s.toCharArray()){
      if(arr[ch]) return false;
      arr[ch] = true;
    }
    return true;
  }

  private static boolean isUniqueNoExtraMem(String s){
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    for(int i=1; i < chars.length ;i++){
      if(chars[i]==chars[i-1]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("abcdefg"+"->"+isUniqueNaive("abcdefg"));
    System.out.println("abcdefc"+"->"+isUniqueNaive("abcdefc"));

    System.out.println("abcdefg"+"->"+isUniqueNoExtraMem("abcdefg"));
    System.out.println("abcdefc"+"->"+isUniqueNoExtraMem("abcdefc"));
  }
}
