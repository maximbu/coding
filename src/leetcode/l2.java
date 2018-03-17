package leetcode;


/**
 * Created by max on 6/24/2017.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 */
public class l2 {

    private final ListAdderHelper listAdderHelper = new ListAdderHelper();

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + ((next != null) ? ("->" + next.toString()) : "");
        }
    }

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        return listAdderHelper.addTwoNumbers(list1, list2);
    }


    public static void main(String[] st) {
        l2 q = new l2();
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        System.out.println(q.addTwoNumbers(list1, list2));

    }

    private static class ListAdderHelper {

        private int carry = 0;

        public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            while (list1 != null || list2 != null) {
                int val = calcValAndCarry(list1, list2);
                curr.next = new ListNode(val);
                curr = curr.next;
                if (list1 != null)
                    list1 = list1.next;
                if (list2 != null)
                    list2 = list2.next;
            }

            if (carry > 0) {
                curr.next = new ListNode(carry);
            }

            return dummy.next;
        }

        private int calcValAndCarry(ListNode n1, ListNode n2) {
            int v1 = 0, v2 = 0;
            if (n1 != null)
                v1 = n1.val;
            if (n2 != null)
                v2 = n2.val;
            int val = v1 + v2 + carry;
            carry = val / 10;
            return val % 10;
        }

    }
}
