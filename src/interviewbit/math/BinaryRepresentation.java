package interviewbit.math;


/**
 * Created by max on 7/16/2017.
 * Given a number N >= 0, find its representation in binary.
  */
public class BinaryRepresentation {
  public static void main(String[] st) {
    BinaryRepresentation q = new BinaryRepresentation();

    int N = 6;
    System.out.println(q.findDigitsInBinary(N));
  }

  public String findDigitsInBinary(int a) {
    if (a == 0) return "0";
    StringBuilder sb = new StringBuilder();
    while (a > 0){
      sb.append(a%2);
      a = a/2;
    }
    return sb.reverse().toString();
  }
}
