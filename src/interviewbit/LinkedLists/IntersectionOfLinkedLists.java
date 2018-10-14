package interviewbit.LinkedLists;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 *  Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfLinkedLists {

  public ListNode getIntersectionNode(ListNode a, ListNode b) {
    int lenA = getLen(a);
    int lenB = getLen(b);
    while (lenA > lenB) {
      a = a.next;
      lenA--;
    }
    while (lenB > lenA) {
      b = b.next;
      lenB--;
    }
    while (a != null) {
      if (a == b) {
        return a;
      }
      a = a.next;
      b = b.next;
    }
    return null;
  }

  private int getLen(ListNode h) {
    int len = 0;
    while (h != null) {
      h = h.next;
      len++;
    }
    return len;
  }
}
