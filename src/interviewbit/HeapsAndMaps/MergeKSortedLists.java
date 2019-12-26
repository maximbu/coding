package interviewbit.HeapsAndMaps;

import interviewbit.LinkedLists.ListNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Example :
 *
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * will result in
 *
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode l : a) {
            if (l != null) {
                pq.add(l);
            }
        }
        while (!pq.isEmpty()) {
            ListNode currMin = pq.poll();
            curr.next = new ListNode(currMin.val);
            if (currMin.next != null) {
                pq.add(currMin.next);
            }
            curr = curr.next;
        }
        curr = head.next;
        head.next = null;
        return curr;
    }
}
