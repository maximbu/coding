package hackerRank.interviewPrep.StringManipulation;

public class AlternatingCharacters {
    static int alternatingCharacters(String s) {
        int cnt = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cnt++;
            }
        }
        return cnt;
    }
}
