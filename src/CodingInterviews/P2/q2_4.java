package CodingInterviews.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;


/**
 * Created by max on 12/16/2016.
 */
public class q2_4 {

    public static  MyLinkedListNode<Integer> partition(MyLinkedListNode<Integer> node,Integer partitionMember) {
        MyLinkedListNode<Integer> head = node;
        MyLinkedListNode<Integer> tail = node;

        while (node != null) {
            MyLinkedListNode<Integer> next = node.getNext();
            if (node.getData() < partitionMember) {
                node.setNext(head);
                head = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        tail.setNext(null);
        return head;
    }




    public static void main(String[] args) {
        MyLinkedListNode<Integer> head = createList(3, 5 , 8, 5 , 10 ,2 ,1);
        String orig = printList(head);
        System.out.println("partition("+orig+",5)====>"+printList(partition(head,10)));
    }
}
