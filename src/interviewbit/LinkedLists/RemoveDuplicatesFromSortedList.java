package interviewbit.LinkedLists;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode head = A;
        ListNode prev = A;
        A = A.next;
        while (A != null) {
            if (A.val == prev.val) {
                prev.next = A.next;
            } else {
                prev = A;
            }
            A = A.next;
        }
        return head;
    }
}
