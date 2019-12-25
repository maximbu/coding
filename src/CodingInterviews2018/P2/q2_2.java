package CodingInterviews2018.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;

public class q2_2 {
  private static <T> MyLinkedListNode<T> kthToLast(MyLinkedListNode<T> head, int k) {
    MyLinkedListNode<T> start = head;
    while (head.getNext() != null) {
      head = head.getNext();
      if (--k <= 0) {
        start = start.getNext();
      }
    }
    return start;
  }

  public static void main(String[] args) {
    MyLinkedListNode<Integer> head = createList(1, 2, 3, 4, 2, 3, 4, 4, 5, 2, 6, 1);
    System.out.println("kthToLast(" + printList(head) + ",4)====>" + kthToLast(head, 4));
  }
}
