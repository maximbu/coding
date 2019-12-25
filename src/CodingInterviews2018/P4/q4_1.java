package CodingInterviews2018.P4;

import CodingInterviews.utils.GraphNode;
import java.util.HashSet;
import java.util.LinkedList;

public class q4_1 {
    private static boolean hasRoute(GraphNode n1, GraphNode n2) {
        var set = new HashSet<GraphNode>();
        var traversal = new LinkedList<GraphNode>();
        if (n1 == n2) return true;
        traversal.add(n1);
        set.add(n1);
        while (!traversal.isEmpty()) {
            var currNode = traversal.remove();
            for (var node : currNode.getNeighbors()) {
                if (node == n2) return true;
                if (set.add(node)) {
                    traversal.add(node);
                }
            }
        }
        return false;
    }

    public static void main(String[] st) {
        GraphNode a = new GraphNode("a");
        GraphNode n1 = new GraphNode("n1");
        GraphNode n2 = new GraphNode("n2");
        GraphNode n3 = new GraphNode("n3");
        GraphNode n4 = new GraphNode("n4");
        GraphNode n5 = new GraphNode("n5");
        GraphNode n6 = new GraphNode("n6");
        GraphNode b = new GraphNode("b");
        a.addNeighbor(n1);

        n1.addNeighbor(n2);
        n1.addNeighbor(n3);

        n4.addNeighbor(n5);
        n5.addNeighbor(n6);
        n6.addNeighbor(n3);
        n6.addNeighbor(n2);
        n6.addNeighbor(b);

        boolean connected = hasRoute(a, b);
        System.out.println("expected false , got: " + connected);
        n3.addNeighbor(n4);
        connected = hasRoute(a, b);
        System.out.println("expected true , got: " + connected);
    }
}
