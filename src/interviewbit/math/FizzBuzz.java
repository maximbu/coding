package interviewbit.math;

import java.util.ArrayList;

/**
 * Created by max on 7/15/2017.
 * Given a positive integer N, print all the integers from 1 to N. But for multiples of 3 print “Fizz” instead of the number and for the multiples of 5 print “Buzz”. Also for number which are multiple of 3 and 5, prints “FizzBuzz”.
 * Note: Instead of printing the answer, you have to return it as list of strings.
 */
public class FizzBuzz {

  public static void main(String[] st) {
    FizzBuzz q = new FizzBuzz();

    int N = 5;
    System.out.println(q.fizzBuzz(N));
  }

  private String numToFizzBuzz(int n) {
    if (n % 3 == 0 && n % 5 == 0) {
      return ("FizzBuzz");
    }
    if (n % 3 == 0) {
      return "Fizz";
    }
    if (n % 5 == 0) {
      return "Buzz";
    }
    return String.valueOf(n);
  }

  public ArrayList<String> fizzBuzz(int A) {
    ArrayList<String> X = new ArrayList<>();
    for (int i = 1; i <= A; i++) {
      X.add(numToFizzBuzz(i));
    }
    return X;
  }
}
