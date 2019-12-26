package UVA.AdHoc.RealLife_easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q10554_CaloriesFromFat {

  public static void main(String[] st) {
    Q10554_CaloriesFromFat p = new Q10554_CaloriesFromFat();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    while (true) {
      String line = sc.nextLine();
      if (line.equals("-")) return;
      List<Product> prod = new ArrayList<>();

      while (!line.equals("-")) {
        String[] input = line.split("\\s+");
        prod.add(new Product(input[0], input[1], input[2], input[3], input[4]));
        line = sc.nextLine();
      }
      int ans = solve(prod);
      out.println(ans + "%");
    }
  }

  private int solve(List<Product> prod) {
    double totalFat = prod.stream().mapToDouble(t -> t.fatCal).sum();
    double totalAll = prod.stream().mapToDouble(t -> t.totalCal).sum();
    return (int) Math.round(100.0 * totalFat / totalAll);
  }


  private static class Product {

    private double fatCal;
    private double totalCal;

    Product(String fat, String prot, String sugar, String starch, String alco) {
      int missingPer = 0;
      int fromFat = extractVal(fat, 9);
      if (fromFat >= 0) {
        fatCal += fromFat;
      }

      missingPer += handleNonFat(fat, 9);
      missingPer += handleNonFat(prot, 4);
      missingPer += handleNonFat(sugar, 4);
      missingPer += handleNonFat(starch, 4);
      missingPer += handleNonFat(alco, 7);

      int currentPer = 100 - missingPer;

      double onePer = 1.0 * totalCal / currentPer;
      totalCal += missingPer * onePer;
      if (fromFat < 0) {
        fatCal += -1.0 * fromFat * onePer;
      }
    }

    private int handleNonFat(String prot, int mult) {
      int fromProt = extractVal(prot, mult);
      if (fromProt >= 0) {
        totalCal += fromProt;
        return 0;
      }
      return -1 * fromProt;
    }

    private int extractVal(String input, int mult) {
      int val = Integer.parseInt(input.substring(0, input.length() - 1));
      switch (input.charAt(input.length() - 1)) {
        case 'g': {
          return val * mult;
        }
        case 'C': {
          return val;
        }
        default: {
          return -1 * val;
        }

      }
    }


  }
}
