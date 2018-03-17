package P2;

import utils.MyLinkedListNode;

import static utils.MyLinkedListNode.createList;
import static utils.MyLinkedListNode.printList;


/**
 * Created by max on 12/16/2016.
 */
public class q2_7 {

    public static <T>  MyLinkedListNode<T> loopDetection(MyLinkedListNode<T> l) {
        MyLinkedListNode<T> h = l;
        MyLinkedListNode<T> slow = l;
        MyLinkedListNode<T> quick = l;
        while (quick != null){
            slow = slow.getNext();
            quick = quick.getNext();
            if(quick == null) return null;
            quick = quick.getNext();
            if(slow == quick)
                break;
        }
        if(quick == null) return null;

        return getInterseptionNode(h, slow);
    }

    private static <T> MyLinkedListNode<T> getInterseptionNode(MyLinkedListNode<T> h, MyLinkedListNode<T> nodeOnLoop) {
        MyLinkedListNode<T> loopIter;
        while (true){
            loopIter = nodeOnLoop.getNext();
            while (loopIter != nodeOnLoop)
            {
                loopIter = loopIter.getNext();
                if(h == loopIter) {
                   return h;
                }
            }
            h = h.getNext();

        }
    }


    public static void main(String[] args) {
        MyLinkedListNode<Integer> l1 = createList(1,2,3,4,5,6,7);
        MyLinkedListNode<Integer> l2 = createList(1,2,3,4,3,2,1);
        MyLinkedListNode<Integer> l3 = createList(8,9);
        l3.getNext().setNext(l1.getNext().getNext());
        MyLinkedListNode<Integer> t = l1.getNext().getNext().getNext().getNext();
        t.setNext(l3);
        System.out.println("loopDetection(noLoop)====>"+loopDetection(l2));
        System.out.println("loopDetection(loop)====>"+loopDetection(l1));
    }
}
