package interviewbit.DynamicProgramming;

/**
 * Given a 3Xn board, find the number of ways to color it using at most 4 colors such that no two adjacent boxes have same color. Diagonal neighbors are not treated as adjacent boxes.
 * Output the ways%1000000007 as the answer grows quickly.
 *
 * 1<= n < 100000
 *
 * Example:
 * Input: n = 1
 * Output: 36
 */
public class WaysToColorA3xNBoard {

  public int solve(int A) {
    long threeCol = 4 * 3 * 2;
    long twoCol = 4 * 3;
    for (int i = 2; i < A + 1; i++) {
      long newThreeCol = ((11 * threeCol) % 1000000007 + (10 * twoCol) % 1000000007) % 1000000007;
      long newTwoCol = ((5 * threeCol) % 1000000007 + (7 * twoCol) % 1000000007) % 1000000007;
      threeCol = newThreeCol;
      twoCol = newTwoCol;
    }
    return (int) ((threeCol + twoCol) % 1000000007);
  }


  public static void main(String[] st) {
    WaysToColorA3xNBoard q = new WaysToColorA3xNBoard();
    System.out.println(q.solve(1));
    System.out.println(q.solve(2));
  }

}
