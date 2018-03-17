package P8;

import java.util.*;

/**
 * Created by max on 12/28/2016.
 */
public class q8_9 {
    public static Set<String> parentheses1(int n){
        if(n==1){
            return new HashSet<>(Collections.singletonList("()"));
        }
        Set<String> prev = parentheses1(n-1);
        HashSet<String> ans = new HashSet<>();
        for(String s:prev){
            ans.add("()"+s);
            ans.add(s+"()");
            ans.addAll(addParenthesesInside2(s));
        }
        return ans;
    }

    private static HashSet<String> addParenthesesInside2(String s) {
        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                String newSt = s.substring(0,i+1)+"()"+s.substring(i+1);
                ans.add(newSt);
            }
        }
        return ans;
    }

    public static Set<String> parentheses2(int n) {
        char[] ch = new char[2*n];
        HashSet<String> ans = new HashSet<>();
        parentheses2Rec(ans,n,n,ch,0);
        return ans;
    }

    private static void parentheses2Rec(HashSet<String> ans, int left, int right, char[] s,int ind) {
        if(left<0 || right<left){
            return;
        }
        if(left == 0 && right == 0){
            ans.add(new String(s));
        }
        else{
            s[ind]='(';
            parentheses2Rec(ans,left-1,right,s,ind+1);

            s[ind]=')';
            parentheses2Rec(ans,left,right-1,s,ind+1);
        }
    }

    public static void main(String[] st){
        Set<String> ans = parentheses1(4);
        for (String s : ans){
            System.out.println(s+", ");
        }
        System.out.println();

        Set<String> ans2 = parentheses2(4);
        for (String s : ans2){
            System.out.println(s+", ");
        }
        System.out.println();
    }
}
