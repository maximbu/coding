package CodingInterviews.P1;

/**
 * Created by max on 12/16/2016.
 */
public class q1_6 {
    public static String stringCompression(String st) {
        StringBuilder comp = new StringBuilder();
        char lastChar = st.charAt(0);
        int letterCnt = 1;
        for (int i=1;i<st.length();i++){
            char c = st.charAt(i);
            if(lastChar != c){
                comp.append(lastChar);
                comp.append(letterCnt);
                lastChar = c;
                letterCnt = 1;
            }
            else
            {
                letterCnt++;
            }
        }
        comp.append(lastChar);
        comp.append(letterCnt);
        return comp.length() > st.length() ? st : comp.toString();
    }


    public static void main(String[] args) {
        System.out.println("stringCompression(aabcccccaaa)"+"->"+stringCompression("aabcccccaaa"));
        System.out.println("stringCompression(aabccaa)"+"->"+stringCompression("aabccaa"));

    }
}
