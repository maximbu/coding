package P2;

import utils.MyLinkedListNode;

import java.util.HashSet;

import static utils.MyLinkedListNode.createList;
import static utils.MyLinkedListNode.printList;


/**
 * Created by max on 12/16/2016.
 */
public class q2_1 {

    public static <T> MyLinkedListNode<T> removeDups(MyLinkedListNode<T> l){
        HashSet<T> set = new HashSet<T>();
        MyLinkedListNode<T> curr = l;
        MyLinkedListNode<T> last = curr;
        while (curr != null) {
            if (set.add(curr.getData())) {
                last = curr;
            } else {
               last.setNext(curr.getNext());
            }
            curr = curr.getNext();
        }
        return l;
    }




    public static void main(String[] args) {
        MyLinkedListNode<Integer> head = createList(1,2,3,4,2,3,4,4,5,2,6,1);
        System.out.println("removeDups("+printList(head)+")====>"+printList(removeDups(head)));
    }
}
