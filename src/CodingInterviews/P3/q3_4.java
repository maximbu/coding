package CodingInterviews.P3;

import java.util.Stack;

/**
 * Created by max on 12/22/2016.
 */
public class q3_4 {
    public static class QueueByStacks<T> {
        Stack<T> stack;
        Stack<T> helperStack;

        public QueueByStacks() {
            stack = new Stack<T>();
            helperStack = new Stack<T>();
        }

        public void enqueue(T item) {
            copyItems(helperStack, stack);
            stack.push(item);

        }

        public T peek() {
            copyItems(stack, helperStack);
            return helperStack.peek();
        }

        public T dequeue() {
            copyItems(stack, helperStack);
            return helperStack.pop();
        }

        private void copyItems(Stack<T> from, Stack<T> to) {
            while (!from.isEmpty()) {
                to.push(from.pop());
            }
        }

        public boolean isEmpty() {
            return stack.isEmpty() && helperStack.isEmpty();
        }

    }

    public static void main(String[] args) {
        QueueByStacks<Integer> q = new QueueByStacks<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        Integer a = q.peek();
        a = q.peek();

        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Popped " + q.dequeue());
        }

        for (int i = 15; i < 20; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Popped " + q.dequeue());
        }
    }
}
