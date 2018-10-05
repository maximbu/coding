package interviewbit.GraphDataStructure;

import java.util.LinkedList;

/**
 * You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, return it in form of a string.
 *
 * Note:
 *
 * Returned string should not contain leading zeroes.
 * For example,
 *
 * For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
 * For N = 2, 10 is the answer.
 */
public class SmallestMultipleWith0And1 {
    private static class Node {
        String value;
        int modN;

        public Node(String val, int mod) {
            value = val;
            modN = mod;
        }
    }

    public String multiple(int N) {
        if (N < 2) {
            return N + "";
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(new Node("1", 1));

        boolean[] visited = new boolean[N];
        visited[1] = true;

        while (true) {
            Node node = queue.removeFirst();

            if (node.modN == 0) {
                return node.value;
            }

            for (int i = 0; i < 2; i++) {
                int x = (node.modN * 10 + i) % N;
                if (!visited[x]) {
                    queue.addLast(new Node(node.value + i, x));
                    visited[x] = true;
                }
            }
        }
    }
}
