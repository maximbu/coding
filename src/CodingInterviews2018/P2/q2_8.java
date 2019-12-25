package CodingInterviews2018.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;

public class q2_8 {

    private static <T> MyLinkedListNode<T> loopDetection(MyLinkedListNode<T> l) {
        var slow = l;
        var quick = l;
        while (quick != null) {
            quick = quick.getNext();
            if (quick == slow) {
                return findLoop(l, slow);
            }
            slow = slow.getNext();
            if (quick == null)
                return null;
            quick = quick.getNext();
        }
        return null;
    }

    private static <T> MyLinkedListNode<T> findLoop(MyLinkedListNode<T> start,
                                                    MyLinkedListNode<T> loopNode) {
        var helper = loopNode;
        while (start != loopNode) {
            loopNode = loopNode.getNext();
            if (loopNode == helper) {
                start = start.getNext();
            }
        }
        return start;
    }

    public static void main(String[] args) {
        MyLinkedListNode<Integer> l1 = createList(1, 2, 3, 4, 5, 6, 7);
        MyLinkedListNode<Integer> l2 = createList(1, 2, 3, 4, 3, 2, 1);
        MyLinkedListNode<Integer> l3 = createList(8, 9);
        l3.getNext().setNext(l1.getNext().getNext());
        MyLinkedListNode<Integer> t = l1.getNext().getNext().getNext().getNext();
        t.setNext(l3);
        System.out.println("loopDetection(noLoop)====>" + loopDetection(l2));
        System.out.println("loopDetection(loop)====>" + loopDetection(l1));
        System.out.println("loopDetection(loop2)====>" + loopDetection(l3));
    }

}
