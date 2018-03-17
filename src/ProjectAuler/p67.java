package ProjectAuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 1/27/2017.
 */
public class p67 {
    /*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
    3
    7 4
    2 4 6
    8 5 9 3

    That is, 3 + 7 + 4 + 9 = 23.

    Find the maximum total from top to bottom of the triangle in p067_triangle.txt file
     */


  public int questionNaive(int[][] triangle) {
    int len = triangle.length;
    int[] currLevelBest = new int[len];
    int[] prevLevelBest = new int[len];
    for (int i = 0; i < len; i++) {
      prevLevelBest[i]= triangle[len-1][i];
    }
    for (int i = triangle.length-2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        currLevelBest[j] = triangle[i][j]+Math.max(prevLevelBest[j],prevLevelBest[j+1]);
      }
      prevLevelBest= Arrays.copyOf(currLevelBest,currLevelBest.length);
    }
    
    return currLevelBest[0];
  }

    public static void main(String[] st) {
        p67 q = new p67();
      int[][] triangle = new int[100][100];
      try {
          List<String> strings = Files.readAllLines(Paths.get("C:\\Users\\max\\IdeaProjects\\CodingInterviews\\out\\production\\CodingInterviews\\ProjectAuler\\p067_triangle.txt"));
            int i=0;
            for (String s:strings){
                triangle[i] = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

      try {
        int[] input;
        List<String> strings = Files.readAllLines(Paths.get("C:\\Users\\max\\IdeaProjects\\CodingInterviews\\out\\production\\CodingInterviews\\ProjectAuler\\qSort_killer2.txt"));
        input = new int[strings.size()];
        int i=0;
        for (String s:strings){
          input[i] = Integer.parseInt(s);
          i++;
        }
        Arrays.sort(input);
        int x = input.length;
      } catch (IOException e) {
        e.printStackTrace();
      }

        System.out.println(q.questionNaive(triangle));
    }
}
