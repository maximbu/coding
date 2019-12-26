package UVA.AdHoc.RealLife_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

class Q161_TrafficLights {

  public static void main(String[] st) {
    Q161_TrafficLights p = new Q161_TrafficLights();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    List<Integer> lights = new ArrayList<>();
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      if (input.length == 0 || input[0].isEmpty())
        continue;
      int[] line = Arrays.stream(input).mapToInt(s -> Integer.parseInt(s.trim())).toArray();
      if (line.length == 3 && Arrays.stream(line).sum() == 0) {
        return;
      }
      for (int light : line) {
        if (light != 0) {
          lights.add(light);
        } else {
          String ans = solve(lights);
          System.out.println(ans);
          lights.clear();
        }
      }

    }
  }

  private String solve(List<Integer> lights) {
    int min = Integer.MAX_VALUE;
    for (Integer light : lights) {
      min = Math.min(min, light);
    }
    int i = min * 2;
    while (i <= 5 * 60 * 60) {
      boolean allGreen = true;
      for (Integer light : lights) {
        if ((i / light) % 2 == 1 || (i % light) + 5 >= light) {
          allGreen = false;
          break;
        }
      }
      if (allGreen) {
        int sec = i % 60;
        int h = i / (60 * 60);
        int m = (i / 60) - h * 60;
        return String.format("%02d:%02d:%02d", h, m, sec);
      }
      i++;
    }
    return "Signals fail to synchronise in 5 hours";
  }
}
