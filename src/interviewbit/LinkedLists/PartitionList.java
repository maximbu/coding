package interviewbit.LinkedLists;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {

  public ListNode partition(ListNode A, int B) {
    ListNode smaller = new ListNode(-1);
    ListNode head = smaller;
    ListNode bigger = new ListNode(-1);
    ListNode biggerStart = bigger;
    while (A != null) {
      if (A.val < B) {
        smaller.next = new ListNode(A.val);
        smaller = smaller.next;
      } else {
        bigger.next = new ListNode(A.val);
        bigger = bigger.next;
      }
      A = A.next;
    }
    smaller.next = biggerStart.next;
    return head.next;

  }
}
