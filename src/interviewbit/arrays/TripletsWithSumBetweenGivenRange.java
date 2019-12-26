package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by max on 7/14/2017.
 * Given an array of real numbers greater than zero in form of strings.
 Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
 Return 1 for true or 0 for false.
 O(n) solution is expected.

 Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.

 */
public class TripletsWithSumBetweenGivenRange {
  public static void main(String[] st) {
    TripletsWithSumBetweenGivenRange q = new TripletsWithSumBetweenGivenRange();

    ArrayList<String> X = new ArrayList<>();
    X.add("0.6");
    X.add("0.7");
    X.add("0.8");
    X.add("1.2");
    X.add("0.4");

    System.out.println(q.solve(X));

    X = new ArrayList<>();
    X.add("0.503094");
    X.add("0.648924");
    X.add("0.999298");

    System.out.println(q.solve(X));
  }

  public int solve(ArrayList<String> A) {
    double smallMax1 = Double.MIN_VALUE;
    double smallMax2 = Double.MIN_VALUE;
    double smallMax3 = Double.MIN_VALUE;
    double smallMin1 = Double.MAX_VALUE;
    double smallMin2 = Double.MAX_VALUE;
    double smallMin3 = Double.MAX_VALUE;
    double midMin1 = Double.MAX_VALUE;
    double midMin2 = Double.MAX_VALUE;
    double midMax = Double.MIN_VALUE;
    double bigMin = Double.MAX_VALUE;
    for (String aA : A) {
      double d = Double.parseDouble(aA);
      if (d < 2.0 / 3) {
        if (d >= smallMax1) {
          smallMax3 = smallMax2;
          smallMax2 = smallMax1;
          smallMax1 = d;
        } else if (d >= smallMax2) {
          smallMax3 = smallMax2;
          smallMax2 = d;
        } else if (d > smallMax3) {
          smallMax3 = d;
        }

        if (d <= smallMin1) {
          smallMin3 = smallMin2;
          smallMin2 = smallMin1;
          smallMin1 = d;
        } else if (d <= smallMin2) {
          smallMin3 = smallMin2;
          smallMin2 = d;
        } else if (d < smallMin3) {
          smallMin3 = d;
        }
      } else if (d < 1 && d > 2.0 / 3) {
        if (d <= midMin1) {
          midMin2 = midMin1;
          midMin1 = d;
        } else if (d < midMin2) {
          midMin2 = d;
        }
        midMax = Math.max(midMax, d);
      } else if (d < 2 && d > 1) {
        bigMin = Math.min(bigMin, d);
      }
    }
    // three in small
    if (isValid(smallMax1, smallMax2, smallMax3)) {
      return 1;
    }
    // two in small , one in mid (mid min)
    if (isValid(smallMax1, smallMax2, midMin1)) {
      return 1;
    }

    // two in small , one in mid (mid max)
    if (isValid(smallMin1, smallMin2, midMax)) {
      return 1;
    }

    // two in small , one in big
    if (isValid(smallMin1, smallMin2, bigMin)) {
      return 1;
    }

    // one in small , two in mid
    if (isValid(smallMin1, midMin1, midMin2)) {
      return 1;
    }

    // one in small , one in mid , one in big
    if (isValid(smallMin1, midMin1, bigMin)) {
      return 1;
    }

    return 0;
  }

  private boolean isValid(double d1, double d2, double d3) {
    if (d1 == Double.MAX_VALUE || d1 == Double.MIN_VALUE) return false;
    if (d2 == Double.MAX_VALUE || d2 == Double.MIN_VALUE) return false;
    if (d3 == Double.MAX_VALUE || d3 == Double.MIN_VALUE) return false;
    double sum = d1 + d2 + d3;
    return sum < 2 && sum > 1;
  }
}
