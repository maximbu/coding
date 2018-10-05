package interviewbit.LinkedLists;

/**
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 *
 * Notes:
 *
 * Expected solution is linear in time and constant in space.
 * For example,
 *
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 */
public class PalindromeList {

    public int lPalin(ListNode A) {
        int cnt = countNodes(A);
        if (cnt < 2)
            return 1;
        ListNode prev = null;
        int h = cnt / 2;

        while (h > 0) {
            ListNode temp = A.next;
            A.next = prev;
            prev = A;
            A = temp;
            h--;
        }
        if (cnt % 2 == 1) {
            A = A.next;
        }
        return compare(A, prev);

    }

    private int compare(ListNode A, ListNode B) {
        while (A != null) {
            if (B.val != A.val) {
                return 0;
            }
            B = B.next;
            A = A.next;
        }
        return 1;
    }

    private int countNodes(ListNode A) {
        int cnt = 0;
        while (A != null) {
            A = A.next;
            cnt++;
        }
        return cnt;
    }
}
