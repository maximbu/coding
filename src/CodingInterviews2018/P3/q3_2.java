package CodingInterviews2018.P3;

import java.util.Stack;

public class q3_2 {
    private static class StackMin {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int val){
            stack.push(val);
            if(minStack.empty() || val <= minStack.peek()){
                minStack.push(val);
            }
        }

        public int pop(){
            int val = stack.pop();
            if(val == minStack.peek()){
                minStack.pop();
            }
            return val;
        }

        public int min(){
            return minStack.peek();
        }

        public void print(){
            System.out.println(stack.toString());
        }

    }

    public static void main(String[] args){
        StackMin s = new StackMin();
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(6);
        s.push(2);
        s.push(1);
        s.push(8);
        s.print();
        int min = s.min();
        System.out.println("min is "+ min);
        s.pop();
        min = s.min();
        s.print();
        System.out.println("min is "+ min);
        s.pop();
        min = s.min();
        s.print();
        System.out.println("min is "+ min);
        s.pop();
        min = s.min();
        s.print();
        System.out.println("min is "+ min);
        s.pop();
        min = s.min();
        s.print();
        System.out.println("min is "+ min);
        s.pop();
        min = s.min();
        s.print();
        System.out.println("min is "+ min);
        s.pop();
        min = s.min();
        s.print();
        System.out.println("min is "+ min);
        s.pop();
//        min = s.min();
        s.print();
//        System.out.println("min is "+ min);
    }

}
