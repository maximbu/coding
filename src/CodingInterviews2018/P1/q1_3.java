package CodingInterviews2018.P1;

public class q1_3 {

  private static String urlify(char[] in, int realLen) {
    int copyTo = in.length - 1;
    for (int i = realLen - 1; i >= 0; i--) {
      if (in[i] != ' ') {
        in[copyTo--] = in[i];
      } else {
        in[copyTo--] = '0';
        in[copyTo--] = '2';
        in[copyTo--] = '%';
      }
    }
    return new String(in);
  }

  public static void main(String[] args) {
    System.out.println("urlify(Mr John Smith    )" + "->" + urlify("Mr John Smith    ".toCharArray(), 13));
  }
}
