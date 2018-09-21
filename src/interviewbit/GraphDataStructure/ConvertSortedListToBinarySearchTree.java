package interviewbit.GraphDataStructure;

import interviewbit.LinkedLists.ListNode;
import interviewbit.Trees.TreeNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 *  A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example :
 *
 *
 * Given A : 1 -> 2 -> 3
 * A height balanced BST  :
 *
 *       2
 *     /   \
 *    1     3
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode a) {
        int len = 0;
        ListNode head = a;

        while(a != null){
            a = a.next;
            len++;
        }

        return sortedListToBST(head,0,len-1);
    }

    private TreeNode sortedListToBST(ListNode a,int from , int to) {
        if (from > to)
            return null;
        int mid = (from + to) / 2;
        ListNode head = a;
        int k = mid;
        while (k > 0) {
            a = a.next;
            k--;
        }
        TreeNode root = new TreeNode(a.val);
        root.left = sortedListToBST(head, from, mid - 1);
        root.right = sortedListToBST(head, mid + 1, to);
        return root;
    }

    public static void main(String[] st) {
        ConvertSortedListToBinarySearchTree q = new ConvertSortedListToBinarySearchTree();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        TreeNode t = q.sortedListToBST(l);
        System.out.println(t);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(8);
        t = q.sortedListToBST(l2);
        System.out.println(t);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(4);
        l3.next.next.next.next = new ListNode(5);
        t = q.sortedListToBST(l3);
        System.out.println(t);

    }

}
