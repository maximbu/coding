package UVA.AdHoc.RealLife_easy;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

class Q10528_MajorScales {

  public static void main(String[] st) {
    Q10528_MajorScales p = new Q10528_MajorScales();
    p.solve();
  }

  private String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
  private int[] jumps = {2, 2, 1, 2, 2, 2, 1};

  private void solve() {
    Scanner sc = new Scanner(in);
    HashMap<String, List<String>> allOptions = generateAllScales();
    while (true) {
      String line = sc.nextLine();
      if (line.equals("END"))
        return;
      String[] input = line.split("\\s+");
      List<String> optional = solve(input, allOptions);
      out.println(String.join(" ", optional));
    }
  }

  private List<String> solve(String[] input, HashMap<String, List<String>> allOptions) {
    List<String> optional = new ArrayList<>();
    for (String note : notes) {
      List<String> scale = allOptions.get(note);
      boolean isGood = Arrays.stream(input).allMatch(scale::contains);
      if (isGood) {
        optional.add(note);
      }
    }
    return optional;
  }

  private HashMap<String, List<String>> generateAllScales() {
    HashMap<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < notes.length; i++) {
      String note = notes[i];
      List<String> scale = new ArrayList<>();
      map.put(note, scale);
      scale.add(note);
      int index = i;
      for (int jump : jumps) {
        index = (index + jump) % notes.length;
        scale.add(notes[index]);
      }
    }
    return map;
  }


}
