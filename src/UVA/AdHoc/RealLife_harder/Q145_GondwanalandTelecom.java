package UVA.AdHoc.RealLife_harder;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Q145_GondwanalandTelecom {

  public static void main(String[] st) {
    Q145_GondwanalandTelecom p = new Q145_GondwanalandTelecom();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    Map<Character, Pricing> prices = getPrices();
    String line = sc.nextLine();
    while (!line.equals("#")) {
      String[] input = line.split("\\s+");
      char area = input[0].charAt(0);
      String number = input[1];
      int fromH = Integer.valueOf(input[2]);
      int fromM = Integer.valueOf(input[3]);
      int toH = Integer.valueOf(input[4]);
      int toM = Integer.valueOf(input[5]);
      if (toH<fromH || toH==fromH && toM<=fromM) {
        toH += 24;
      }
      int from = fromH * 60 + fromM;
      int to = toH * 60 + toM;
      int day=0, evening=0, night=0;
      for (int i = 0; i < 2 * 24 * 60; i++) {
        if (i > from && i <= to) {
          if (i <= 8 * 60)
            night++;
          else if (i <= 18 * 60)
            day++;
          else if (i <= 22 * 60)
            evening++;
          else if (i <= (24 + 8) * 60)
            night++;
          else if (i <= (24 + 18) * 60)
            day++;
          else if (i <= (24 + 22) * 60)
            evening++;
          else
            night++;
        }
      }
      out.println(String.format("%10s%6d%6d%6d%3s%8.2f", number, day, evening, night, area,
          prices.get(area).dayRate * day + prices.get(area).eveningRate * evening
              + prices.get(area).nightRate * night));
      line = sc.nextLine();
    }
  }

  private Map<Character, Pricing> getPrices() {
    Map<Character, Pricing> prices = new HashMap<>();
    prices.put('A',new Pricing(0.1,0.06,0.02));
    prices.put('B',new Pricing(0.25,0.15,0.05));
    prices.put('C',new Pricing(0.53,0.33,0.13));
    prices.put('D',new Pricing(0.87,0.47,0.17));
    prices.put('E',new Pricing(1.44,0.80,0.30));
    return prices;
  }




  private class Pricing {

    private final double dayRate;
    private final double eveningRate;
    private final double nightRate;

    Pricing(double dayRate, double eveningRate, double nightRate) {
      this.dayRate = dayRate;
      this.eveningRate = eveningRate;
      this.nightRate = nightRate;
    }
  }
}
