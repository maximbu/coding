package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;
import java.util.regex.Pattern;

class Q272_TEXQuotes {

  public static void main(String[] st){
    Q272_TEXQuotes p = new Q272_TEXQuotes();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    boolean left = true;
    while(sc.hasNextLine()){
      String input = sc.nextLine();
      while(input.contains("\"")){
        String stringToReplaceWith = "``";
        if(!left){
          stringToReplaceWith = "''";
        }
        input = input.replaceFirst(Pattern.quote("\""),stringToReplaceWith);
        left = !left;
      }
      out.println(input);
    }
  }

}
