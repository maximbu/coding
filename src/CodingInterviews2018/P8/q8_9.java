package CodingInterviews2018.P8;

import java.util.ArrayList;

public class q8_9 {

    private static void parens (String prefix , int openLeft , int closeLeft , ArrayList<String> ans ) {
        if (closeLeft == 0) {
            ans.add(prefix);
            return;
        }

        if (openLeft != 0) {
            parens(prefix + '(', openLeft - 1, closeLeft, ans);
        }

        if (openLeft != closeLeft) {
            parens(prefix + ')', openLeft, closeLeft - 1, ans);
        }

    }

    private static ArrayList<String> parens(int n){
        var ans = new ArrayList<String>();
        parens("",n,n,ans);
        return ans;
    }


    public static void main(String[] st){
        var ans = parens(4);
        ans.stream().map(s -> s + ", ").forEach(System.out::println);
        System.out.println();
    }

}
