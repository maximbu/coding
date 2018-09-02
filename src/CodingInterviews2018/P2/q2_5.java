package CodingInterviews2018.P2;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;

import CodingInterviews.utils.MyLinkedListNode;

public class q2_5 {

    private static MyLinkedListNode<Integer> sumLists(MyLinkedListNode<Integer> l1,
            MyLinkedListNode<Integer> l2) {
        int carry = 0;
        MyLinkedListNode<Integer> ans = null;
        MyLinkedListNode<Integer> start = null;
        while (l1 != null || l2 != null) {
            int a = (l1 == null ? 0 : l1.getData());
            int b = (l2 == null ? 0 : l2.getData());
            int sum = a + b + carry;
            MyLinkedListNode<Integer> node = new MyLinkedListNode<>(sum % 10);
            carry = sum / 10;
            if (ans == null) {
                start = node;
            } else {
                ans.setNext(node);
            }
            ans = node;
            if (l1 != null)
                l1 = l1.getNext();
            if (l2 != null)
                l2 = l2.getNext();
        }
        if (carry > 0) {
            ans.setNext(new MyLinkedListNode<>(carry));
        }
        return start;
    }

    private static MyLinkedListNode<Integer> sumLists2(MyLinkedListNode<Integer> l1,
            MyLinkedListNode<Integer> l2) {
        MyLinkedListNode<Integer> ans = reverse(sumLists(reverse(l1), reverse(l2)));
        reverse(l1);
        reverse(l2);
        return ans;
    }

    private static MyLinkedListNode<Integer> reverse(MyLinkedListNode<Integer> l) {
        MyLinkedListNode<Integer> prev = l;
        l = l.getNext();
        prev.setNext(null);
        while (l != null) {
            MyLinkedListNode<Integer> next = l.getNext();
            l.setNext(prev);
            prev = l;
            l = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        MyLinkedListNode<Integer> l = createList(1, 2, 3, 4);
        String ls = printList(l);
        System.out.println("reverse(" + ls + ")====>" + printList(reverse(l)));

        MyLinkedListNode<Integer> l1 = createList(7, 1, 6);
        MyLinkedListNode<Integer> l2 = createList(5, 9, 4);
        String l1s = printList(l1);
        String l2s = printList(l2);
        System.out
                .println("sumLists2(" + l1s + "," + l2s + ")====>" + printList(sumLists2(l1, l2)));

        MyLinkedListNode<Integer> l3 = createList(6, 1, 7);
        MyLinkedListNode<Integer> l4 = createList(3, 9, 5);
        String l3s = printList(l3);
        String l4s = printList(l4);
        System.out
                .println("sumLists2(" + l3s + "," + l4s + ")====>" + printList(sumLists2(l3, l4)));

        MyLinkedListNode<Integer> l5 = createList(9, 7, 8);
        MyLinkedListNode<Integer> l6 = createList(6, 8, 5);
        String l5s = printList(l5);
        String l6s = printList(l6);
        System.out
                .println("sumLists2(" + l5s + "," + l6s + ")====>" + printList(sumLists2(l5, l6)));

        MyLinkedListNode<Integer> l7 = createList(9, 9, 9);
        MyLinkedListNode<Integer> l8 = createList(2);
        String l7s = printList(l7);
        String l8s = printList(l8);
        System.out
                .println("sumLists2(" + l7s + "," + l8s + ")====>" + printList(sumLists2(l7, l8)));
    }
}
