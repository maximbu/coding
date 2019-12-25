package CodingInterviews2018.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;

public class q2_4 {
  private static MyLinkedListNode<Integer> partitionList(MyLinkedListNode<Integer> head, int k) {
    MyLinkedListNode<Integer> smaller = null;
    MyLinkedListNode<Integer> bigger = null;
    MyLinkedListNode<Integer> startSmaller = null;
    MyLinkedListNode<Integer> startBigger = null;
    while (head != null) {
      MyLinkedListNode<Integer> next = head.getNext();
      if (head.getData() < k) {
        if (smaller == null) {
          smaller = head;
          startSmaller = head;
        } else {
          smaller.setNext(head);
          smaller = smaller.getNext();
        }
        smaller.setNext(null);
      } else {
        if (bigger == null) {
          bigger = head;
          startBigger = head;
        } else {
          bigger.setNext(head);
          bigger = bigger.getNext();
        }
        bigger.setNext(null);
      }
      head = next;
    }
    if (smaller != null) {
      smaller.setNext(startBigger);
      return startSmaller;
    }
    return startBigger;
  }

  public static void main(String[] args) {
    MyLinkedListNode<Integer> head = createList(3, 5, 8, 5, 10, 2, 1);
    String orig = printList(head);
    System.out.println("partitionList(" + orig + ",5)====>" + printList(partitionList(head, 1)));
  }
}
