package CodingInterviews.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;


/**
 * Created by max on 12/16/2016.
 */
public class q2_2 {

    public static <T> T KthToLast(MyLinkedListNode<T> l,int k){
        MyLinkedListNode<T> curr = l;
        MyLinkedListNode<T> kToLast = curr;
        for (int i = 0; i < k; i++) {
            curr = curr.getNext();
        }
        while (curr != null)
        {
            curr = curr.getNext();
            kToLast = kToLast.getNext();
        }
        return kToLast.getData();
    }




    public static void main(String[] args) {
        MyLinkedListNode<Integer> head = createList(1,2,3,4,2,3,4,4,5,2,6,1);
        System.out.println("KthToLast("+printList(head)+",4)====>"+KthToLast(head,4));
    }
}
