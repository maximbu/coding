package CodingInterviews2018.P1;

public class q1_2 {
  private static boolean isPermutation(String s1, String s2){
    if(s1.length() != s2.length()) return false;

    char[] chars = s1.toCharArray();
    char[] chars2 = s2.toCharArray();
    int arr[] = new int[256];

    for(char ch:chars){
      arr[ch]++;
    }

    for(char c : chars2){
      if(arr[c] < 1) return false;
      arr[c]--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("isPermutation(abcdefgg,gfedcgab)"+"->"+isPermutation("abcdefgg","gfedcgab"));
    System.out.println("isPermutation(abcdefg,gfedcaa)"+"->"+isPermutation("abcdefg","gfedcaa"));
  }

}
