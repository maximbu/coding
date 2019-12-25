package CodingInterviews2018.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;

public class q2_3 {
  private static <T> void removeNode(MyLinkedListNode<T> toRemove) {
    MyLinkedListNode<T> tmp = toRemove.getNext();
    toRemove.setData(toRemove.getNext().getData());
    toRemove.setNext(toRemove.getNext().getNext());
    tmp.setNext(null);
  }


  public static void main(String[] args) {
    MyLinkedListNode<Integer> head = createList(1, 2, 3, 4, 5, 6);
    String orig = printList(head);
    removeNode(head.getNext().getNext());//3
    String afterDelete = printList(head);
    System.out.println("removeNode(" + orig + ")====>" + afterDelete);
  }
}
