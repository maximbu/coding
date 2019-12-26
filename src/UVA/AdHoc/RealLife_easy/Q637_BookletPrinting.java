package UVA.AdHoc.RealLife_easy;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class Q637_BookletPrinting {

  public static void main(String[] st) {
    Q637_BookletPrinting p = new Q637_BookletPrinting();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    while (true) {
      int size = sc.nextInt();
      if (size == 0)
        return;
      out.printf("Printing order for %d pages:%n", size);
      printPages(size);
    }
  }

  private void printPages(int size) {
    if (size == 1) {
      out.println("Sheet 1, front: Blank, 1");
      return;
    }
    if (size == 2) {
      out.println("Sheet 1, front: Blank, 1");
      out.println("Sheet 1, back : 2, Blank");
      return;
    }
    int len = size;
    while (len % 4 != 0) {
      len++;
    }

    boolean front = true;
    int i = 1;
    int iter = len / 2;
    while (i <= iter) {
      if (front) {
        out.printf("Sheet %d, front: %s, %d%n", (i + 1) / 2, len > size ? "Blank" : len, i);
      } else {
        out.printf("Sheet %d, back : %d, %s%n", (i + 1) / 2, i, len > size ? "Blank" : len);
      }
      i++;
      len--;
      front = !front;
    }
  }

}
