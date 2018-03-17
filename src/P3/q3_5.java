package P3;

import java.util.Stack;

/**
 * Created by max on 12/22/2016.
 */
public class q3_5 {
    public static void sort(Stack<Integer> s) {
        Stack<Integer> h = new Stack<>();
        while (!s.isEmpty()) {
            Integer tmp = s.pop();
            insertOrdered(tmp, h, s);
        }
        while (!h.isEmpty()) {
            s.push(h.pop());
        }
    }


    public static void insertOrdered(Integer x, Stack<Integer> s, Stack<Integer> helper) {
        int movedItems = 0;
        while (!s.isEmpty()) {
            Integer curr = s.peek();
            if (curr < x) {
                break;
            }
            helper.push(s.pop());
            movedItems++;
        }
        s.push(x);
        for (int i = 0; i < movedItems; i++) {
            s.push(helper.pop());
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
        sort(s);
        String after = s.toString();
        System.out.println("before:"+before+" after:"+after);
    }

}

