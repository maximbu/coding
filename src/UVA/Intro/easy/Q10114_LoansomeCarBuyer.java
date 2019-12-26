package UVA.Intro.easy;

import java.util.Arrays;
import java.util.Scanner;

class Q10114_LoansomeCarBuyer {

  public static void main(String[] st) {
    Q10114_LoansomeCarBuyer p = new Q10114_LoansomeCarBuyer();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String[] input = sc.nextLine().split("\\s+");
      double[] line = Arrays.stream(input).mapToDouble(Double::parseDouble).toArray();
      if (line[0] < 0)
        return;
      int loanDuration = (int) line[0];
      double downPayment = line[1];
      double loanAmount = line[2];
      int records = (int) line[3];
      double[] depreciationRate = new double[101];
      while (records-- > 0) {
        input = sc.nextLine().split("\\s+");
        line = Arrays.stream(input).mapToDouble(Double::parseDouble).toArray();
        depreciationRate[(int) line[0]] = line[1];
      }
      for (int i = 1; i < depreciationRate.length; i++) {
        if (depreciationRate[i] == 0) {
          depreciationRate[i] = depreciationRate[i - 1];
        }
      }
      int ans = solve(loanAmount, downPayment, loanAmount / loanDuration, depreciationRate);
      System.out.println(ans + " month" + (ans != 1 ? "s" : ""));
    }
  }

  private int solve(double loanAmount, double downPayment, double monthlyPayment,
                    double[] depreciationRate) {
    double buyerOwns = loanAmount;
    double carWorth = (loanAmount + downPayment) * (1 - depreciationRate[0]);
    if (carWorth > buyerOwns)
      return 0;
    for (int i = 1; i < depreciationRate.length; i++) {
      buyerOwns -= monthlyPayment;
      carWorth *= (1 - depreciationRate[i]);
      if (carWorth > buyerOwns)
        return i;
    }
    return depreciationRate.length;
  }

}
