package interviewbit.LinkedLists;

import java.util.Arrays;
import java.util.Random;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1,2,3,4,5,NULL, m = 2 and n = 4,
 *
 * return 1,4,3,2,5,NULL.
 *
 *  Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list. Note 2:
 * Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */
public class ReverseLinkListII {

  public ListNode reverseList(ListNode A, int C) {
    ListNode prev = null;
    ListNode next = A.next;
    ListNode head = A;
    if (next == null)
      return A;
    while (next != null && C >= 0) {
      next = A.next;
      A.next = prev;
      prev = A;
      A = next;
      C--;
    }
    head.next = A;
    return prev;
  }

  //TODO : over complicated - simply point to the tail in reverseList instead
  public ListNode reverseBetween(ListNode A, int B, int C) {
    ListNode head = A;
    int len = C - B;
    int origB = B;
    if (len == 0)
      return A;
    ListNode last = A;
    while (A != null && B > 1) {
      last = A;
      A = A.next;
      B--;
    }
    if (A == null)
      return head;

    if (origB == 1) {
      return reverseList(A, len);
    }
    last.next = reverseList(A, len);
    return head;
  }

  public static void main(String[] st) {
    ReverseLinkListII q = new ReverseLinkListII();
    ListNode l = new ListNode(1);
    l.next = new ListNode(2);
    l.next.next = new ListNode(3);
    System.out.println(q.reverseBetween(l, 1, 2));
    l = new ListNode(1);
    l.next = new ListNode(2);
    l.next.next = new ListNode(3);
    System.out.println(q.reverseBetween(l, 2, 3));
    l = listNodeFromArray(new int[]{81, 65, 17, 26, 47, 45, 59, 99, 42, 73, 71, 28, 83, 98, 63, 19, 30, 62, 2, 96, 43, 11, 37, 40, 6, 51, 82, 29, 84, 92, 27, 57, 75, 3, 66, 87, 50, 23});
    System.out.println(q.reverseBetween(l, 1, 29));
  }

  private static ListNode listNodeFromArray(int[] ints) {
    ListNode l = new ListNode(ints[0]);
    ListNode head = l;
    for (int i = 1; i < ints.length; i++) {
      l.next = new ListNode(ints[i]);
      l = l.next;
    }
    return head;
  }
}
