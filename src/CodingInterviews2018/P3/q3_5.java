package CodingInterviews2018.P3;

import java.util.Stack;

public class q3_5 {

    private static Stack<Integer> sortStack(Stack<Integer> s){
        var helper = new Stack<Integer>();
        while(!s.isEmpty()){
            putInPlace(helper,s,s.pop());
        }
        return helper;
    }

    private static void putInPlace(Stack<Integer> s, Stack<Integer> helper , int val){
        int cnt = 0;
        while(!s.empty() && s.peek()<val){
            helper.push(s.pop());
            cnt++;
        }
        s.push(val);
        while(cnt > 0){
            s.push(helper.pop());
            cnt--;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(); //3 , 5 , 7 ,2 , 4
        s.push(3);
        s.push(5);
        s.push(7);
        s.push(2);
        s.push(4);
        String before = s.toString();
        s = sortStack(s);
        String after = s.toString();
        System.out.println("before:"+before+" after:"+after);
    }
}
