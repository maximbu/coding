package P2;

import utils.MyLinkedListNode;

import static utils.MyLinkedListNode.createList;
import static utils.MyLinkedListNode.printList;


/**
 * Created by max on 12/16/2016.
 */
public class q2_3 {

    public static <T> void deleteNode(MyLinkedListNode<T> l){
        l.setData(l.getNext().getData());
        l.setNext(l.getNext().getNext());
    }




    public static void main(String[] args) {
        MyLinkedListNode<Integer> head = createList(1,2,3,4,5,6);
        String orig = printList(head);
        deleteNode(head.getNext().getNext());//3
        String afterDelete = printList(head);
        System.out.println("deleteNode("+orig+")====>"+afterDelete);
    }
}
