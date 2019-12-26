package interviewbit.LinkedLists;

import java.util.Random;

/**
 * Sort a linked list using insertion sort.
 *
 * We have explained Insertion Sort at Slide 7 of Arrays
 *
 * Insertion Sort Wiki has some details on Insertion Sort as well.
 *
 * Example :
 *
 * Input : 1 -> 3 -> 2
 *
 * Return 1 -> 2 -> 3
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode A) {
        ListNode head = A;
        ListNode tmp;
        while (A != null) {
            tmp = A.next;
            head = insertSorted(head, A);
            A = tmp;
        }
        return head;
    }

    public ListNode insertSorted(ListNode A, ListNode toInsert) {
        ListNode head = A;
        ListNode prev = null;
        while (A != null && A != toInsert) {
            if (toInsert.val < A.val) {
                if (prev == null) {
                    head = toInsert;
                } else {
                    prev.next = toInsert;
                }
                toInsert.next = A;
                return head;
            }
            prev = A;
            A = A.next;
        }
        if (A == null) {
            prev.next = toInsert;
        }
        toInsert.next = null;
        return head;
    }

    public static void main(String[] st) {
        InsertionSortList q = new InsertionSortList();
        ListNode l = new ListNode(1);
        ListNode h = l;
        Random r = new Random();
        for (int i = 2; i < 8; i++) {
            l.next = new ListNode(r.nextInt(100));
            l = l.next;
        }
        System.out.println(h);
        System.out.println(q.insertionSortList(h));
    }
}
