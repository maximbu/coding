package CodingInterviews2018.P2;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;

import CodingInterviews.utils.MyLinkedListNode;
import java.util.HashSet;
import java.util.Set;

public class q2_1 {

  private static <T> MyLinkedListNode<T> removeDups(MyLinkedListNode<T> head) {
    Set<T> set = new HashSet<T>();
    set.add(head.getData());
    MyLinkedListNode<T> start = head;
    while (head.getNext() != null) {
      if (!set.add(head.getNext().getData())) {
        head.setNext(head.getNext().getNext());
      } else {
        head = head.getNext();
      }
    }
    return start;
  }

  private static <T> MyLinkedListNode<T> removeDupsNoExtraMem(MyLinkedListNode<T> head) {
    MyLinkedListNode<T> start = head;
    while (head.getNext() != null) {
      if (isDuplicate(start, head.getNext())) {
        head.setNext(head.getNext().getNext());
      } else {
        head = head.getNext();
      }
    }
    return start;
  }


  private static <T> boolean isDuplicate(MyLinkedListNode<T> head, MyLinkedListNode<T> toCheck) {
    while (head != toCheck) {
      if (head.getData() == toCheck.getData())
        return true;
      head = head.getNext();
    }
    return false;
  }


  public static void main(String[] args) {
    MyLinkedListNode<Integer> head = createList(1, 2, 3, 4, 2, 3, 4, 4, 5, 2, 6, 1);
    System.out.println("removeDupsNoExtraMem(" + printList(head) + ")====>" + printList(removeDupsNoExtraMem(head)));
  }

}
