package interviewbit.LinkedLists;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 *     342 + 465 = 807
 * Make sure there are no trailing zeros in the output list
 * So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class AddTwoNumbersAsLists {

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (A != null || B != null || carry > 0) {
            int v = (A != null ? A.val : 0) + (B != null ? B.val : 0) + carry;
            curr.next = new ListNode(v % 10);
            carry = v / 10;
            curr = curr.next;
            if (A != null) {
                A = A.next;
            }
            if (B != null) {
                B = B.next;
            }
        }

        return head.next;
    }
}
