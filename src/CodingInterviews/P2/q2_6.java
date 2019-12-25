package CodingInterviews.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;


/**
 * Created by max on 12/16/2016.
 */
public class q2_6 {

    public static <T> boolean palindrome(MyLinkedListNode<T> l) {
        MyLinkedListNode<T> copied = copy(l);
        MyLinkedListNode<T> reversed = reverse(copied);
        while (reversed != null) {
            if (reversed.getData() != l.getData())
                return false;
            reversed = reversed.getNext();
            l = l.getNext();
        }
        return true;
    }

    private static <T> MyLinkedListNode<T> copy(MyLinkedListNode<T> l) {
        if (l == null)
            return null;
        MyLinkedListNode<T> newHead = new MyLinkedListNode<T>(l.getData());
        MyLinkedListNode<T> curr = newHead;
        l = l.getNext();
        while (l != null) {
            curr.setNext(new MyLinkedListNode<T>(l.getData()));
            curr = curr.getNext();
            l = l.getNext();
        }
        return newHead;
    }


    public static <T> MyLinkedListNode<T> reverse(MyLinkedListNode<T> l) {
        if (l == null)
            return null;
        MyLinkedListNode<T> prev = null;
        MyLinkedListNode<T> curr = l;
        while (curr != null) {
            MyLinkedListNode<T> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        MyLinkedListNode<Integer> head = createList(1, 2, 3, 4, 3, 2, 1);
        System.out.println("palindrome(" + printList(head) + ")====>" + palindrome(head));
        head = createList(1, 2, 3, 4, 4, 3, 2, 1);
        System.out.println("palindrome(" + printList(head) + ")====>" + palindrome(head));
        head = createList(1, 2, 3, 4, 4, 4, 2, 1);
        System.out.println("palindrome(" + printList(head) + ")====>" + palindrome(head));
    }
}
