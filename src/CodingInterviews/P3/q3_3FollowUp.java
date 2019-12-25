package CodingInterviews.P3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by max on 12/21/2016.
 */
public class q3_3FollowUp {
    public static class StackOfPiles<T> {
        int threshold;
        List<Stack<T>> stacks;
        int lastStackUsed;

        public StackOfPiles(int threshold) {
            this.threshold = threshold;
            stacks = new ArrayList<>();
            stacks.add(new Stack<>());
            lastStackUsed = 0;
        }

        public void push(T obj) {
            if (stacks.get(lastStackUsed).size() >= threshold) {
                stacks.add(new Stack<>());
                lastStackUsed++;
            }
            stacks.get(lastStackUsed).push(obj);
        }

        public T pop() {
            return popAt(lastStackUsed);
        }

        private boolean shouldRemoveStack(int stackIndex) {
            return stackIndex != 0 && stacks.get(stackIndex).size() == 1;
        }

        private T popAndRemoveStack(int stackIndex) {
            Stack<T> stack = stacks.get(stackIndex);
            T val = stack.pop();
            stacks.remove(stack);
            return val;
        }

        public T popAt(int index) {
            if (shouldRemoveStack(index)) {
                T val = popAndRemoveStack(index);
                lastStackUsed--;
                return val;
            }
            return stacks.get(index).pop();
        }


    }

    public static void main(String[] args) {
        int capacity_per_substack = 5;
        StackOfPiles<Integer> set = new StackOfPiles<>(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("Popped At 3:" + set.popAt(3));
        }
        for (int i = 0; i < 30; i++) {
            System.out.println("Popped " + set.pop());
        }
    }

}
