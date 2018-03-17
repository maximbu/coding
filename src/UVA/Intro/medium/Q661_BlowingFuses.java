package UVA.Intro.medium;

import java.util.Arrays;
import java.util.Scanner;

class Q661_BlowingFuses {

  public static void main(String[] st) {
    Q661_BlowingFuses p = new Q661_BlowingFuses();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    int seq = 1;
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      if (Arrays.stream(line).allMatch(t -> t == 0))
        return;
      int numOfDevices = line[0];
      int numOfOperations = line[1];
      int fuseCapacity = line[2];
      boolean[] devicesOn = new boolean[numOfDevices];
      int[] devicesCapacity = new int[numOfDevices];
      for (int i = 0; i < numOfDevices; i++) {
        int capacity = sc.nextInt();
        sc.nextLine();
        devicesCapacity[i] = capacity;
      }
      int max = 0;
      int sum = 0;
      for (int i = 0; i < numOfOperations; i++) {
        int device = sc.nextInt() - 1;
        sc.nextLine();
        devicesOn[device] = !devicesOn[device];
        if (devicesOn[device]) {
          sum += devicesCapacity[device];
        } else {
          sum -= devicesCapacity[device];
        }
        max = Math.max(max, sum);
      }

      System.out.println("Sequence " + (seq++));
      if (max > fuseCapacity) {
        System.out.println("Fuse was blown.");
      } else {
        System.out.println("Fuse was not blown.");
        System.out.println("Maximal power consumption was " + max + " amperes.");
      }
      System.out.println();
    }
  }

}
