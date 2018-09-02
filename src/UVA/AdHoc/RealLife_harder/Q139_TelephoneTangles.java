package UVA.AdHoc.RealLife_harder;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q139_TelephoneTangles {

  public static void main(String[] st) {
    Q139_TelephoneTangles p = new Q139_TelephoneTangles();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    List<Area> areas = new ArrayList<>();
    String line = sc.nextLine();
    while (!line.equals("000000")) {
      String[] input = line.split("\\s+");
      String id = input[0];
      String name = line.substring(id.length() + 1, line.indexOf('$'));
      int price = Integer.parseInt(line.substring(line.indexOf('$') + 1));
      areas.add(new Area(id, name, price));
      line = sc.nextLine();
    }
    String number = sc.next();
    while (!number.equals("#")) {
      int duration = sc.nextInt();
      boolean found = false;
      for (Area area : areas) {
        if (number.startsWith(area.id) && valid(number, area)) {
          out.println(String.format("%-16s%-25s%10s%5d%6.2f%7.2f",
              number, area.name, number.substring(area.id.length()),
              duration, area.price / 100.0,
              duration * area.price / 100.0));
          found = true;
          break;
        }
      }
      if(!found){
        if(number.startsWith("0")) {
          out.println(String.format("%-16s%-35s%5d%13.2f",
              number,
              "Unknown",
              duration, -1.0));
        }
        else {
          out.println(String.format("%-16s%-25s%10s%5d%6.2f%7.2f",
              number, "Local", number,
              duration, 0.0,
              0.0));
        }

      }
      sc.nextLine();
      number = sc.next();
    }
  }

  private boolean valid(String number, Area area) {
    int realNumberLen = number.substring(area.id.length()).length();
    return area.id.length() == 0 || area.id.startsWith("00") && realNumberLen < 11 && realNumberLen > 3
        || area.id.startsWith("0") && realNumberLen < 8 && realNumberLen > 3;
  }

  private class Area {

    private String id;
    private String name;
    private int price;

    Area(String id, String name, int price) {
      this.id = id;
      this.name = name;
      this.price = price;
    }

    @Override
    public String toString() {
      return "Area{" +
          "id='" + id + '\'' +
          ", name='" + name + '\'' +
          ", price=" + price +
          '}';
    }
  }

}
