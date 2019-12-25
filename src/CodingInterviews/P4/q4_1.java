package CodingInterviews.P4;

import CodingInterviews.utils.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by max on 12/22/2016.
 */
public class q4_1 {

    // the function and the test are wrong , have no idea why it is as it is.
    // fixed in later version
    public static boolean routeBetweenNodes(GraphNode a, GraphNode b) {
        Set<GraphNode> encountered = new HashSet<>();
        LinkedList<GraphNode> visit = new LinkedList<>();
        encountered.add(a);
        encountered.add(b);
        visit.add(a);
        visit.add(b);
        while (!visit.isEmpty()) {
            GraphNode currNode = visit.remove();
            for (GraphNode node : currNode.getNeighbors()) {
                if (!encountered.add(node)) {
                    return true;
                }
                visit.add(node);
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
        b.addNeighbor(n6);
        n1.addNeighbor(n2);
        n1.addNeighbor(n3);
        n6.addNeighbor(n4);
        n6.addNeighbor(n5);
        boolean connected = routeBetweenNodes(a, b);
        n5.addNeighbor(n2);
        connected = routeBetweenNodes(a, b);
    }

}
