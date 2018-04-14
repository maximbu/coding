package UVA.AdHoc.RealLife_easy;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Q857_Quantiser {

  public static void main(String[] st) {
    Q857_Quantiser p = new Q857_Quantiser();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(in);
    while (true) {
      int size = sc.nextInt();
      sc.nextLine();
      if (size == -1) {
        out.println(-1);
        return;
      }
      List<Note> notes = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        String[] input = sc.nextLine().split("\\s+");
        int[] data = Arrays.stream(input).mapToInt(s -> Integer.parseInt(s.trim())).toArray();
        notes.add(new Note(data[0],data[1],data[2],data[3],data[4]));
      }
      List<Note> ans = solve(notes);
      out.println(ans.size());
      for (Note an : ans) {
        out.println(an);
      }
    }
  }

  private List<Note> solve(List<Note> notes) {
    List<Note> ans = new ArrayList<>();
    HashSet<Note> seen = new HashSet<>();
    for (Note note : notes) {
      if (!seen.add(note)) {
        seen.remove(note);
        ans.remove(ans.lastIndexOf(note));
      } else {
        ans.add(note);
      }
    }
    return ans;
  }


  private class Note {

    private int code;
    private int note;
    private int m;
    private int b;
    private int t;

    public Note(int code, int note, int m, int b, int t) {
      this.code = code;
      this.note = note;
      this.m = m;
      this.b = b;
      this.t = t;
      quantise();
    }

    void quantise() {
      t = ((t + 30) / 60) * 60;
      if (t == 480) {
        t = 0;
        b++;
        if (b == 5) {
          b = 1;
          m++;
        }
      }
    }

    @Override
    public String toString() {
      return String.format("%d %d %d %d %d", code, note, m, b, t);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Note note1 = (Note) o;
      return note == note1.note &&
          m == note1.m &&
          b == note1.b &&
          t == note1.t;
    }

    @Override
    public int hashCode() {
      return Objects.hash(note);
    }
  }
}
