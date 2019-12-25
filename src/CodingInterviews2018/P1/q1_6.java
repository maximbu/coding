package CodingInterviews2018.P1;

public class q1_6 {
  private static String compress(String st) {
    StringBuilder sb = new StringBuilder();
    int cnt = 1;
    char[] chars = st.toCharArray();
    int length = chars.length;
    for (int i = 0; i < length - 1; i++) {
      if (chars[i] == chars[i + 1]) {
        cnt++;
      } else {
        sb.append(chars[i]);
        sb.append(cnt);
        cnt = 1;
      }
    }
    sb.append(chars[length - 1]);
    sb.append(cnt);
    return sb.length() > chars.length ? st : sb.toString();
  }

  public static void main(String[] args) {
    System.out.println("compress(aabcccccaaa)" + "->" + compress("aabcccccaaa"));
    System.out.println("compress(aabcccccaaaaxy)" + "->" + compress("aabcccccaaaaxy"));
    System.out.println("compress(aabccaa)" + "->" + compress("aabccaa"));

  }

}
