package GeneralAlgos;

  public class Z {

    private int[] calculateZ(char[] input) {
      int[] Z = new int[input.length];
      int left = 0;
      int right = 0;
      for (int i = 1; i < input.length; i++) {
        if (i > right) { // building box for left = i
          left = right = i;
          right = updateForLeft(input, Z, left, right);
          continue;
        }
        //now inside a box (copy from prev box)
        int prev = i - left;
        //if value keeps inside box , copy it
        if (Z[prev] < right - i + 1) {
          Z[i] = Z[prev];
        } else { //building box for left = i
          left = i;
          right = updateForLeft(input, Z, left, right);
        }
      }
      return Z;
    }

    private int updateForLeft(char[] input, int[] z, int left, int right) {
      while (right < input.length && input[right] == input[right - left]) {
        right++;
      }
      z[left] = right - left;
      right--;
      return right;
    }
  }
