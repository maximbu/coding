package interviewbit.Backtracking;

import interviewbit.LinkedLists.ListNode;

/**
 * Reverse a linked list using recursion.
 *
 * Example :
 * Given 1->2->3->4->5->NULL,
 *
 * return 5->4->3->2->1->NULL.
 */
public class ReverseLinkListRecursion {

  public ListNode reverseList(ListNode A) {
    if (A.next == null) {
      return A;
    }
    ListNode rev = reverseList(A.next);
    A.next.next = A;
    A.next = null;
    return rev;
  }
}
