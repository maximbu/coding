package CodingInterviews2018.P8;

import java.util.ArrayList;

public class q8_7 {

    private static ArrayList<String> permWithoutDups(String s) {
        var ans = new ArrayList<String>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }
        char first = s.charAt(0);
        String rest = s.substring(1);
        var withoutFirst = permWithoutDups(rest);
        for(var ex:withoutFirst){
            for(int i=0; i<=ex.length();i++){
                ans.add(ex.substring(0, i) + first + ex.substring(i));
            }
        }
        return ans;
    }


    public static void main (String[] st){
       var ans = permWithoutDups("abcde");
    }

}
