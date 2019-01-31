package hackerRank.interviewPrep.StringManipulation;

import java.util.Arrays;

public class CommonChild {
    static int commonChild(String s1, String s2) {
        int[][] mem = new int[s1.length()][s1.length()];
        return commonChild(s1, s2, mem );
    }

    private static int commonChild(String s1, String s2, int[][] mem) {
        for (int i = 0; i < s1.length(); i++) {
            mem[s1.length()-1][i]=s2.substring(i).contains(""+s1.charAt(s1.length()-1)) ? 1 : 0;
            mem[i][s1.length()-1]=s1.substring(i).contains(""+s2.charAt(s2.length()-1)) ? 1 : 0;
        }
        for (int i = s1.length() - 2; i >= 0; i--) {
            for (int j = s1.length() - 2; j >= 0; j--) {
                mem[i][j] = Math.max(mem[i+1][j],mem[i][j+1]);
                if (s1.charAt(i) == s2.charAt(j)) {
                    mem[i][j] = Math.max(mem[i][j],1+mem[i+1][j+1]);
                }
            }
        }
        return mem[0][0];
    }

    private static int commonChildRec(String s1, String s2, int[][] mem,int i,int j) {
        if (s1.length() == 1) {
            return s2.contains(s1) ? 1 : 0;
        }
        if (s2.length() == 1) {
            return s1.contains(s2) ? 1 : 0;
        }
        if(mem[i][j] != -1){
            return mem[i][j];
        }
        int max = Math.max(commonChildRec(s1, s2.substring(1), mem,i,j+1), commonChildRec(s1.substring(1), s2, mem,i+1,j));
        if (s1.charAt(0) == s2.charAt(0)) {
            max = Math.max(max, 1 + commonChildRec(s1.substring(1), s2.substring(1), mem,i+1,j+1));
        }
        mem[i][j] = max;
        return max;
    }
}
