package P3;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by max on 12/18/2016.
 */
public class q3_2 {
    public static class StackMin{

        private Stack<Integer> st;
        private Stack<Integer> mins;

        LinkedList<String> l;

        public StackMin(){
            st = new Stack<>();
            mins = new Stack<>();
        }

        public void push(int val){
          st.push(val);
          if(mins.isEmpty() || val < mins.peek()){
              mins.push(val);
          }
        }
        public int pop(){
            Integer val = st.pop();
            if(val == mins.peek())
            {
                mins.pop();
            }
            return val;
        }
        public int pick() {
            return st.peek();
        }
        public boolean isEmpty(){
           return st.isEmpty();
        }
        public int getMin(){
            if(mins.isEmpty())
                return Integer.MAX_VALUE;
            return mins.peek();
        }
        @Override
        public String toString(){
          return st.toString();
        }

    }

    public static void main(String[] args){
        StackMin s = new StackMin();
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(6);
        s.push(1);
        s.push(8);
        int min = s.getMin();
        s.pop();
        min = s.getMin();
        s.pop();
        min = s.getMin();
        s.pop();
        min = s.getMin();
        s.pop();
        min = s.getMin();
        s.pop();
        min = s.getMin();
        s.pop();
        min = s.getMin();
    }
}
