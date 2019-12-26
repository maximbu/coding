package interviewbit.LinkedLists;


public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode bth = A;
        ListNode head = A;
        while (A != null && B-- > 0) {
            A = A.next;
        }
        if (A == null) {
            return head.next;
        }
        while (A.next != null) {
            A = A.next;
            bth = bth.next;
        }
        bth.next = bth.next.next;

        return head;
    }
}
