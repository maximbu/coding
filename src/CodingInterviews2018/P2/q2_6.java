package CodingInterviews2018.P2;

import CodingInterviews.utils.MyLinkedListNode;

import java.util.ArrayList;

import static CodingInterviews.utils.MyLinkedListNode.createList;
import static CodingInterviews.utils.MyLinkedListNode.printList;

public class q2_6 {

    private static <T> boolean isPalindrome(MyLinkedListNode<T> l) {
        int len = getLength(l);
        var arr = new ArrayList<T>();
        for (int i = 0; i < len / 2; i++) {
            arr.add(0, l.getData());
            l = l.getNext();
        }
        if (len % 2 == 1) {
            l = l.getNext();
        }
        int i = 0;
        while (l != null) {
            if (arr.get(i) != l.getData()) {
                return false;
            }
            l = l.getNext();
            i++;
        }
        return true;
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
        MyLinkedListNode<Integer> head = createList(1, 2, 3, 4, 3, 2, 1);
        System.out.println("palindrome(" + printList(head) + ")====>" + isPalindrome(head));
        head = createList(1, 2, 3, 4, 4, 3, 2, 1);
        System.out.println("palindrome(" + printList(head) + ")====>" + isPalindrome(head));
        head = createList(1, 2, 3, 4, 4, 4, 2, 1);
        System.out.println("palindrome(" + printList(head) + ")====>" + isPalindrome(head));
    }
}
