package interviewbit.LinkedLists;

/**
 * Reverse a linked list. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL,
 *
 * return 5->4->3->2->1->NULL.
 *
 * PROBLEM APPROACH :
 *
 * Complete solution code in the hints
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode next = A.next;
        if (next == null)
            return A;
        while (next != null) {
            next = A.next;
            A.next = prev;
            prev = A;
            A = next;
        }
        return prev;
    }
}
