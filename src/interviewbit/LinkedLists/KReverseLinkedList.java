package interviewbit.LinkedLists;

import java.util.Random;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the
 *
 * list K at a time and returns modified linked list.
 *
 *  NOTE : The length of the list is divisible by K
 * Example :
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
 *
 * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
 *
 * Try to solve the problem using constant extra space.
 */
public class KReverseLinkedList {

  public ListNode reverseList(ListNode A, int B) {
    ListNode current = A;
    ListNode next = null;
    ListNode prev = null;

    for (int i=0;i < B && current != null;i++)
    {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    if (next != null)
      A.next = reverseList(next, B);

    return prev;
  }

  public static void main(String[] st) {
    KReverseLinkedList q = new KReverseLinkedList();
    ListNode l = listNodeFromArray(new int[]{6, 10, 0, 3, 4, 8});
    System.out.println(q.reverseList(l, 3));
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
