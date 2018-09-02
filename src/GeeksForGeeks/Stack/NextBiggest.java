package GeeksForGeeks.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextBiggest {

    public ArrayList<Integer> nextBiggest(ArrayList<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> queue = new Stack<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            int currElement = arr.get(i);
            while (!queue.isEmpty() && queue.peek() < currElement) {
                queue.pop();
            }
            if (queue.isEmpty()) {
                ans.add(0, -1);
                queue.push(currElement);
            } else {
                ans.add(0, queue.peek());
                if (currElement > queue.peek()) {
                    queue.pop();
                }
                queue.push(currElement);
            }

        }
        return ans;
    }

    public static void main(String[] st) {
        NextBiggest q = new NextBiggest();
        var list = new ArrayList<>(Arrays.asList(1, 5, 35, 13, 12, 8, 21));
        System.out.println(q.nextBiggest(list));
    }
}
