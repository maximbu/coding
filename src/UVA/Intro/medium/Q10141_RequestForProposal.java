package UVA.Intro.medium;

import java.util.Arrays;
import java.util.Scanner;

class Q10141_RequestForProposal {

  public static void main(String[] st) {
    Q10141_RequestForProposal p = new Q10141_RequestForProposal();
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
      int numOfReq = line[0];
      int numOfProposals = line[1];
      for (int i = 0; i < numOfReq; i++) {
        sc.nextLine();
      }
      String bestName = "";
      double bestPrice = Double.MAX_VALUE;
      double bestFit = 0;
      for (int i = 0; i < numOfProposals; i++) {
        String name = sc.nextLine();
        double price = sc.nextDouble();
        int fitReq = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < fitReq; j++) {
          sc.nextLine();
        }
        if (fitReq > bestFit || (fitReq == bestFit && price < bestPrice)) {
          bestFit = fitReq;
          bestPrice = price;
          bestName = name;
        }
      }
      if (seq > 1)
        System.out.println();
      System.out.println("RFP #" + (seq++));
      System.out.println(bestName);
    }
  }

}
