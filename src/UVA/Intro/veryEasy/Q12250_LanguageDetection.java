package UVA.Intro.veryEasy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.Scanner;

class Q12250_LanguageDetection {
  public static void main(String[] st){
    Q12250_LanguageDetection p = new Q12250_LanguageDetection();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    int i = 1;
    HashMap<String,String> hiToLang = new HashMap<>();
    hiToLang.put("HELLO","ENGLISH");
    hiToLang.put("HOLA","SPANISH");
    hiToLang.put("HALLO","GERMAN");
    hiToLang.put("BONJOUR","FRENCH");
    hiToLang.put("CIAO","ITALIAN");
    hiToLang.put("ZDRAVSTVUJTE","RUSSIAN");
    while(true){
      String input = sc.nextLine();
      if(input.equals("#")) return;
      out.println("Case " + i++ + ": " + hiToLang.getOrDefault(input,"UNKNOWN"));
    }
  }
}
