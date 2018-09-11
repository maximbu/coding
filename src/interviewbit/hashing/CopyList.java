package interviewbit.hashing;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
 *
 * Return a deep copy of the list.
 *
 * Example
 *
 * Given list
 *
 *    1 -> 2 -> 3
 * with random pointers going from
 *
 *   1 -> 3
 *   2 -> 1
 *   3 -> 1
 * You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 *
 *
 */
public class CopyList {

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode copyHead = new RandomListNode(head.label);
        map.put(head, copyHead);
        RandomListNode origHead = head;
        RandomListNode copy = copyHead;
        head = head.next;
        while (head != null) {
            RandomListNode copyNode = new RandomListNode(head.label);
            copy.next = copyNode;
            map.put(head, copyNode);
            head = head.next;
            copy = copyNode;
        }
        copy = copyHead;
        while (origHead != null) {
            if (origHead.random != null) {
                copy.random = map.get(origHead.random);
            }
            origHead = origHead.next;
            copy = copy.next;
        }
        return copyHead;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
