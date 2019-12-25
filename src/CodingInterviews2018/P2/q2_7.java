package CodingInterviews2018.P2;

import CodingInterviews.utils.MyLinkedListNode;

import static CodingInterviews.utils.MyLinkedListNode.createList;

public class q2_7 {

    private static <T> MyLinkedListNode<T> intersection(MyLinkedListNode<T> l1,
                                                        MyLinkedListNode<T> l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        while (len1 < len2) {
            if (l1 == l2)
                return l1;
            l2 = l2.getNext();
            len1++;
        }
        while (len2 < len1) {
            if (l1 == l2)
                return l1;
            l1 = l1.getNext();
            len2++;
        }
        while (l1 != null) {
            if (l1 == l2)
                return l1;
            l2 = l2.getNext();
            l1 = l1.getNext();
        }
        return null;
    }


    private static <T> int getLength(MyLinkedListNode<T> l) {
        int cnt = 0;
        while (l != null) {
            cnt++;
            l = l.getNext();
        }
        return cnt;
    }


    public static void main(String[] args) {
        MyLinkedListNode<Integer> l1 = createList(1, 2, 3, 4, 5, 6, 7);
        MyLinkedListNode<Integer> l2 = createList(1, 2, 3, 4, 3, 2, 1);
        MyLinkedListNode<Integer> l3 = createList(8, 9);
        l3.getNext().setNext(l1.getNext().getNext());
        System.out.println("getInterseptionNode(l1,l2)====>" + intersection(l1, l2));
        System.out.println("getInterseptionNode(l1,l3)====>" + intersection(l1, l3));
    }
}
