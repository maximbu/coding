package interviewbit.LinkedLists;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 *
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {

    public ListNode rotateRight(ListNode A, int B) {
        ListNode head = A;
        int len = 0;
        ListNode last = A;
        while (A != null) {
            last = A;
            A = A.next;
            len++;
        }
        if (len == 1) {
            return head;
        }
        int move = (len - B) % len;
        if (move < 0) {
            move += len;
        }
        if (move == 0) {
            return head;
        }

        A = head;

        while (move > 1) {
            A = A.next;
            move--;
        }
        ListNode tmp = A.next;
        last.next = head;
        A.next = null;
        return tmp;
    }
}
