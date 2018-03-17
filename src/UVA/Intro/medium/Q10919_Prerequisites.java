package UVA.Intro.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

class Q10919_Prerequisites {

  public static void main(String[] st) {
    Q10919_Prerequisites p = new Q10919_Prerequisites();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int numOfCourses = sc.nextInt();
      if (numOfCourses == 0)
        return;

      int numOfCategories = sc.nextInt();
      sc.nextLine();
      Set<Integer> courses = new HashSet<>();
      for (int i = 0; i < numOfCourses; i++) {
        courses.add(sc.nextInt());
      }
      sc.nextLine();
      boolean meetsReq = true;

      for (int i = 0; i < numOfCategories; i++) {
        String[] input = sc.nextLine().split("\\s+");
        int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int minCourses = line[1];
        int cnt = (int) IntStream.range(2, line.length).filter(j -> courses.contains(line[j]))
            .count();
        if (cnt < minCourses) {
          meetsReq = false;
        }
      }
      System.out.println(meetsReq ? "yes" : "no");
    }
  }

}
