package hackerRank.interviewPrep.Arrays;

public class LeftRotation {
    static int[] rotLeft(int[] a, int d) {
        int[] ans = new int[a.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = a[(i+d)%ans.length];
        }
        return ans;
    }
}
