package interviewbit.LinkedLists;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
 *
 * For example, given following linked lists :
 *
 *   5 -> 8 -> 20
 *   4 -> 11 -> 15
 * The merged list should be :
 *
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode ans = new ListNode(0);
        ListNode ansHead = ans;
        while (A != null || B != null) {
            if (A == null) {
                ans.next = new ListNode(B.val);
                ans = ans.next;
                B = B.next;
                continue;
            }
            if (B == null) {
                ans.next = new ListNode(A.val);
                ans = ans.next;
                A = A.next;
                continue;
            }
            if (A.val < B.val) {
                ans.next = new ListNode(A.val);
                ans = ans.next;
                A = A.next;
                continue;
            }
            ans.next = new ListNode(B.val);
            ans = ans.next;
            B = B.next;
        }
        return ansHead.next;
    }
}
