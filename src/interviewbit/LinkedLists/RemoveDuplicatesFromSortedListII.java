package interviewbit.LinkedLists;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode curr = head;
        int prev = Integer.MAX_VALUE;
        while (A != null) {
            if (A.val != prev && (A.next == null || A.next.val != A.val)) {
                ListNode node = new ListNode(A.val);
                curr.next = node;
                curr = node;
            }
            prev = A.val;
            A = A.next;
        }
        return head.next;
    }
}
