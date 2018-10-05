package interviewbit.LinkedLists;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapListNodesInPairs {

    public ListNode swapPairs(ListNode A) {
        if (A.next == null)
            return A;
        ListNode head = A.next;
        ListNode curr = null;
        while (A != null) {
            ListNode tmp = A.next;
            if (tmp != null) {
                A.next = tmp.next;
                tmp.next = A;
                if (curr != null) {
                    curr.next = tmp;
                }
            }
            curr = A;
            A = A.next;
        }
        return head;
    }
}
