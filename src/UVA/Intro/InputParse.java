package UVA.Intro;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputParse {

  /*
    Sample Input :
    3
    1 2
    5 7
    6 3
    Sample Output :
    3
    12
    9
  */
  public void testCasesGiven(){
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
    sc.nextLine();
    while(n-- > 0){
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println(result);
    }
  }

  /*
   Sample Input :
   1 2
   5 7
   6 3
   0 0
   Sample Output :
   3
   12
   9
 */
  public void endsWithZeroes(){
    Scanner sc = new Scanner(in);
    while(true){
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      if(IntStream.of(line).noneMatch(t->t != 0)) return;
      int result = solve(line);
      out.println(result);
    }
  }

  /*
   Sample Input :
   1 2
   5 7
   6 3
   Sample Output :
   3
   12
   9
 */
  public void endsWithEOF(){
    Scanner sc = new Scanner(in);
    while(sc.hasNextLine()){
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println(result);
    }
  }

  /*
   Sample Input :
   1 2
   5 7
   6 3
   Sample Output :
   Case 1: 3

   Case 2: 12

   Case 3: 9

 */
  public void casesAndBlanks() {
    Scanner sc = new Scanner(in);
    int n = 1;
    while (sc.hasNextLine()) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println("Case " + n++ + ": " + result);
      out.println();
    }
  }

  /*
   Sample Input :
   1 2
   5 7
   6 3
   Sample Output :
   Case 1: 3

   Case 2: 12

   Case 3: 9
 */

  public void casesAndBlanksNoEmptyLineAtTheEnd() {
    Scanner sc = new Scanner(in);
    int n = 1;
    while (sc.hasNextLine()) {
      if (n > 1) out.println();
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println("Case " + n++ + ": " + result);
    }
  }

  /*
  Sample Input :
  1 1
  2 3 4
  3 8 1 1
  4 7 2 9 3
  5 1 1 1 1 1
  Sample Output :
  1
  7
  10
  21
  5
  */
  public void variableNumOfInputs(){
    Scanner sc = new Scanner(in);
    while(sc.hasNextLine()){
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).skip(1).mapToInt(Integer::parseInt).toArray();
      int result = solve(line);
      out.println(result);
    }
  }

  private int solve(int[] line) {
    return IntStream.of(line).sum();
  }

  public static void main(String[] st){
    InputParse p = new InputParse();
    //p.testCasesGiven();
    //p.endsWithZeroes();
    //p.endsWithEOF();
    //p.casesAndBlanks();
    //p.casesAndBlanksNoEmptyLineAtTheEnd();
    p.variableNumOfInputs();
  }
}
