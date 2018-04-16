package CodingInterviews.P3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by max on 12/21/2016.
 */
public class q3_3 {
    public static class StackOfPiles<T>{
        int  threshold;
        List<Stack<T>> stacks;
        int lastStackUsed ;

        public StackOfPiles(int threshold){
            this.threshold = threshold;
            stacks = new ArrayList<>();
            stacks.add(new Stack<>());
            lastStackUsed =0;
        }

        public void push(T obj){
            if(stacks.get(lastStackUsed).size() >= threshold){
                stacks.add(new Stack<>());
                lastStackUsed ++;
            }
            stacks.get(lastStackUsed).push(obj);
        }

        public T pop(){
            Stack<T> lastStack = stacks.get(lastStackUsed);
            if(lastStackUsed != 0 && lastStack.size() == 1){
                T val = lastStack.pop();
                stacks.remove(lastStackUsed);
                lastStackUsed--;
                return val;
            }
            return  lastStack.pop();
        }

    }

    public static void main(String[] args) {
        int capacity_per_substack = 5;
        StackOfPiles<Integer> set = new StackOfPiles<Integer>(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped " + set.pop());
        }
    }

}
