package interviewbit.LinkedLists;

/**
 * Given a singly linked list
 *
 *     L: L0 → L1 → … → Ln-1 → Ln,
 * reorder it to:
 *
 *     L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * You must do this in-place without altering the nodes’ values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public ListNode reorderList(ListNode A) {
        ListNode head = A;
        ListNode slow = A;
        ListNode fast = A;
        ListNode beforeSlow = A;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            beforeSlow = slow;
            slow = slow.next;
        }
        beforeSlow.next = null;
        ListNode helper = slow;
        ListNode prev = null;
        while(slow != null){
            helper = slow.next;
            slow.next = prev;
            prev = slow;
            slow = helper;
        }
        ListNode end = prev;
        if(head == end) return head;

        helper = head;
        while(head != null && end != null){
            prev = head.next;
            head.next = end;
            slow = end.next;
            end.next = prev;
            head = end.next;
            end = slow;
            // 1->2->3     6->5->4
            //1->6->2
        }
        if(end != null){
            beforeSlow.next.next = end;
        }

        return helper;
    }


    public static void main(String[] st) {
        ReorderList q = new ReorderList();
        ListNode l = new ListNode(1);
        ListNode h = l;
        for(int i = 2;i<8;i++){
            l.next = new ListNode(i);
            l = l.next;
        }
        System.out.println(q.reorderList(h));
    }
}
