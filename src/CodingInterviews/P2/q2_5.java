package CodingInterviews.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;


/**
 * Created by max on 12/16/2016.
 */
public class q2_5 {

    public static  MyLinkedListNode<Integer> sumLists1(MyLinkedListNode<Integer> l1,MyLinkedListNode<Integer> l2) {
        MyLinkedListNode<Integer> head = null;
        MyLinkedListNode<Integer> curr = null;
        Integer val;
        boolean carry = false;
        while (l1 != null || l2 != null) {
            val = 0;
            if (l1 != null) {
                val += l1.getData();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                val += l2.getData();
                l2 = l2.getNext();
            }

            if (carry) {
                val += 1;
            }
            carry = val > 9;
            val %= 10;

            if (head == null) {
                head = new MyLinkedListNode<>(val);
                curr = head;
            } else {
                curr.setNext(new MyLinkedListNode<>(val));
                curr = curr.getNext();
            }

        }
        if(carry)
        {
            curr.setNext(new MyLinkedListNode<>(1));
        }

        return head;
    }


    public static MyLinkedListNode<Integer> reverse (MyLinkedListNode<Integer> l)
    {
        MyLinkedListNode<Integer> prev = null;
        MyLinkedListNode<Integer> curr = l;
        while (curr!=null)
        {
            MyLinkedListNode<Integer> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static  MyLinkedListNode<Integer> sumLists2(MyLinkedListNode<Integer> l1,MyLinkedListNode<Integer> l2) {
        MyLinkedListNode<Integer> tmpL1 = reverse(l1);
        MyLinkedListNode<Integer> tmpL2 = reverse(l2);
        MyLinkedListNode<Integer> ans = reverse(sumLists1(tmpL1, tmpL2));
        reverse(tmpL1);
        reverse(tmpL2);
        return ans;
    }




    public static void main(String[] args) {
        MyLinkedListNode<Integer> l1 = createList(7,1,6);
        MyLinkedListNode<Integer> l2 = createList(5,9,4);
        String l1s = printList(l1);
        String l2s = printList(l2);
        System.out.println("sumLists1("+l1s+","+l2s+")====>"+printList(sumLists1(l1,l2)));

        MyLinkedListNode<Integer> l3 = createList(6,1,7);
        MyLinkedListNode<Integer> l4 = createList(3,9,5);
        String l3s = printList(l3);
        String l4s = printList(l4);
        System.out.println("sumLists2("+l3s+","+l4s+")====>"+printList(sumLists2(l3,l4)));
    }
}
