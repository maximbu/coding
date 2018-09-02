package CodingInterviews2018.P3;

import java.util.ArrayList;
import java.util.Stack;

public class q3_3 {

    private static class SetOfStacks {

        int MAX_CAPACITY = 3;
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        int currStackNum;

        public SetOfStacks() {
            stacks.add(new Stack<>());
        }

        public void push(int val) {
            var currStack = stacks.get(currStackNum);
            if (currStack.size() == MAX_CAPACITY) {
                currStackNum++;
                currStack = new Stack<>();
                stacks.add(currStack);
            }
            currStack.push(val);
        }

        public int pop() {
            var currStack = stacks.get(currStackNum);
            int val = currStack.pop();
            if (currStack.isEmpty()) {
                currStackNum--;
            }
            return val;
        }

    }

    private static class SetOfStacksFollow {

        int MAX_CAPACITY = 3;
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        int currStackNum;

        public SetOfStacksFollow() {
            stacks.add(new Stack<>());
        }

        public void push(int val) {
            var currStack = stacks.get(currStackNum);
            if (currStack.size() == MAX_CAPACITY) {
                currStackNum++;
                currStack = new Stack<>();
                stacks.add(currStack);
            }
            currStack.push(val);
        }

        public int pop() {
            var currStack = stacks.get(currStackNum);
            int val = currStack.pop();
            while (currStackNum > 0 && currStack.isEmpty()) {
                currStack = stacks.get(--currStackNum);
            }
            return val;
        }

        public int popAt(int index) {
            if (index == currStackNum)
                return pop();
            var currStack = stacks.get(index);
            return currStack.pop();
        }


    }

    public static void main(String[] args) {
        SetOfStacks set = new SetOfStacks();
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 34; i++) {
            System.out.println("Popped " + set.pop());
        }

        SetOfStacksFollow set2 = new SetOfStacksFollow();
        for (int i = 0; i < 34; i++) {
            set2.push(i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Popped At 2:" + set2.popAt(2));
        }
        for (int i = 0; i < 30; i++) {
            System.out.println("Popped " + set2.pop());
        }
    }


}
