package interviewbit.LinkedLists;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example :
 *
 * Input : 1 , 5 , 4 , 3
 *
 * Returned list : 1 , 3 , 4 , 5
 */
public class SortList {


  public ListNode sortList(ListNode from) {
    if (from == null || from.next == null) {
      return from;
    }
    ListNode slow = from;
    ListNode fast = from;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (slow.next == fast) {
      slow = from;
    }
    ListNode tmp = slow.next;
    slow.next = null;
    ListNode left = sortList(from);
    ListNode right = sortList(tmp);
    return merge(left, right);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode ans = new ListNode(0);
    ListNode temp = ans;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        temp.next = new ListNode(left.val);
        left = left.next;
      } else {
        temp.next = new ListNode(right.val);
        right = right.next;
      }
      temp = temp.next;
    }
    temp.next = (right != null) ? right : left;
    return ans.next;
  }

  public static void main(String[] st) {
    SortList q = new SortList();
    q.sortList(new ListNode(1));
    printList(q.sortList((listNodeFromArray(new int[]{5, 66, 68, 42, 73, 25, 84, 63, 72, 20, 77, 38, 8, 99, 92, 49, 74, 45, 30, 51, 50, 95, 56, 19, 31, 26, 98, 67, 100, 2, 24, 6, 37, 69, 11, 16, 61, 23, 78, 27, 64, 87, 3, 85, 55, 22, 33, 62}))));
  }

  private static void printList(ListNode l) {
    while (l != null) {
      System.out.print(l.val + "->");
      l = l.next;
    }
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
