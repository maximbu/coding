package hackerRank.interviewPrep.Greedy;

import java.util.Arrays;

// WIP !!!
public class ReverseShuffleMerge {

    static String reverseShuffleMerge(String st) {
        String sorted = createInitialString(st);
        while (!canBeOrdered(sorted, st)) {
            sorted = nextInorder(sorted);
        }
        return sorted;
    }

    private static String createInitialString(String st) {
        int[] occ = new int['z' - 'a' + 1];
        for (char c : st.toCharArray()) {
            occ[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < occ.length; i++) {
            for (int k = 0; k < occ[i] / 2; k++) {
                sb.append((char)( 'a' + i));
            }
        }
        char[] tmp = sb.toString().toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }

    //abcd -> abdc -> acbd -> acdb -> adbc -> adcb -> bacd
    private static String nextInorder(String sorted) {
        char[] chars = sorted.toCharArray();
        int right = chars.length-1;
        while (right>0 && chars[right]<chars[right-1]) {
            right--;
        }
        right--;
        if (right == 0) return sorted;
        int left = right+1;
        for (int i = left; i < chars.length; i++) {
            if(chars[i]>chars[right]){
                left = i;
            }
        }
        char tmp = chars[left];
        chars[left]=chars[right];
        chars[right]=tmp;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(chars,right+1,chars.length-right-1).reverse();
        return String.valueOf(chars, 0, right + 1)
                + sb2;
    }

    private static boolean canBeOrdered(String sorted, String expected) {
        String reversed = new StringBuilder(sorted).reverse().toString();
        int i = 0;
        for (int j = 0; j < expected.length(); j++) {
            if (reversed.charAt(i) == expected.charAt(j)) {
                i++;
            }
            if (i == reversed.length()) {
                return true;
            }
        }
        return i == reversed.length();
    }

    public static void main(String[] s){
        System.out.println(reverseShuffleMerge("aeiouuoiea"));
        System.out.println(reverseShuffleMerge("abcdefgabcdefg"));
        System.out.println(reverseShuffleMerge("eggegg"));
    }
}
