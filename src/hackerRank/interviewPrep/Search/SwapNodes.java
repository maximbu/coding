package hackerRank.interviewPrep.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SwapNodes {

    static class Node {
        int index;
        Node left;
        Node right;

        public Node(int index) {
            this.index = index;
        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        Node head = buildTree(indexes);
        HashMap<Integer, List<Node>> levelToNode = new HashMap<>();
        fillLevelToNode(head, 1, levelToNode);

        int[][] ans = new int[queries.length][indexes.length];

        for (int i = 0; i < queries.length; i++) {
            doSwaps(levelToNode,queries[i],indexes.length);
            ans[i] = inOrder(head);
            //doSwaps(levelToNode,queries[i],indexes.length);
        }
        return ans;
    }

    private static void doSwaps(HashMap<Integer, List<Node>> levelToNode, int levelMul, int maxLevel) {
        for (int i = levelMul; i <= maxLevel; i+=levelMul) {
            for (Node n : levelToNode.getOrDefault(i, Collections.emptyList())) {
                Node tmp = n.left;
                n.left = n.right;
                n.right = tmp;
            }
        }

    }

    private static void fillLevelToNode(Node head, int i, HashMap<Integer, List<Node>> levelToNode) {
        if (head == null)
            return;
        if (!levelToNode.containsKey(i)) {
            levelToNode.put(i, new ArrayList<>());
        }
        levelToNode.get(i).add(head);
        fillLevelToNode(head.left, i + 1, levelToNode);
        fillLevelToNode(head.right, i + 1, levelToNode);
    }

    private static Node buildTree(int[][] indexes) {
        HashMap<Integer, Node> idToNode = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            int[] children = indexes[i];
            for (int j = 0; j < 2; j++) {
                if (!idToNode.containsKey(children[j])){
                    idToNode.put(children[j], new Node(children[j]));
                }
            }

            Node left = idToNode.get(children[0]);
            Node right = idToNode.get(children[1]);
            Node curr = idToNode.getOrDefault(i + 1, new Node(i + 1));
            curr.left = left;
            curr.right = right;
            idToNode.put(i + 1, curr);
        }
        return idToNode.get(1);
    }



    private static int[] inOrder(Node head) {
        ArrayList<Integer> ind = new ArrayList<>();
        inOrderRec(head, ind);
        return ind.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void inOrderRec(Node head, ArrayList<Integer> ind) {
        if (head == null || head.index == -1)
            return;
        if (head.left != null) {
            inOrderRec(head.left, ind);
        }
        ind.add(head.index);
        if (head.right != null) {
            inOrderRec(head.right, ind);
        }
    }

    public static void main(String[] st) {
        int[][] indexes = new int[3][2];
        indexes[0] = new int[]{2, 3};
        indexes[1] = new int[]{-1, -1};
        indexes[2] = new int[]{-1, -1};
        int[] queries = new int[2];
        queries[0] = queries[1] = 1;
        System.out.println(Arrays.deepToString(swapNodes(indexes, queries)));
    }
}
