package interviewbit.stacksAndQueues;

import java.util.Stack;

public class MinStack {
    static class Solution {
        private Stack<Integer> nums = new Stack<>();
        private Stack<Integer> min = new Stack<>();

        public void push(int x) {
            nums.push(x);
            if (min.empty() || min.peek() > x) {
                min.push(x);
            }
        }

        public void pop() {
            if (nums.empty()) {
                return;
            }
            int x = nums.pop();
            if (x == min.peek()) {
                min.pop();
            }
        }

        public int top() {
            if (nums.empty()) {
                return -1;
            }
            return nums.peek();
        }

        public int getMin() {
            if (min.empty()) {
                return -1;
            }
            return min.peek();
        }
    }
}
