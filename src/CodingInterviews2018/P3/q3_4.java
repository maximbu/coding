package CodingInterviews2018.P3;

import java.util.Stack;
import java.util.stream.IntStream;

public class q3_4 {
    private static class QueueViaStacks<T> {
        Stack<T> s1 = new Stack<>();
        Stack<T> s2 = new Stack<>();

        public void enqueue(T val) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            s1.push(val);
        }

        public T dequeue() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public static void main(String[] args) {
        QueueViaStacks<Integer> q = new QueueViaStacks<Integer>();
        q.enqueue(1);
        q.enqueue(2);

        IntStream.range(0, 10).forEach(q::enqueue);
        IntStream.range(0, 5).mapToObj(i -> "Popped " + q.dequeue()).forEach(System.out::println);

        IntStream.range(15, 20).forEach(q::enqueue);
        IntStream.range(0, 10).mapToObj(i -> "Popped " + q.dequeue()).forEach(System.out::println);

    }


}
