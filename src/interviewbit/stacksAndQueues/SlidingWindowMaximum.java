package interviewbit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.
 *
 * Example :
 *
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 *
 * Window position	Max
 *
 * [1 3 -1] -3 5 3 6 7	3
 * 1 [3 -1 -3] 5 3 6 7	3
 * 1 3 [-1 -3 5] 3 6 7	5
 * 1 3 -1 [-3 5 3] 6 7	5
 * 1 3 -1 -3 [5 3 6] 7	6
 * 1 3 -1 -3 5 [3 6 7]	7
 * Input: A long array A[], and a window width w
 * Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
 * Requirement: Find a good optimal way to get B[i]
 *
 *  Note: If w > length of the array, return 1 element with the max of the array.
 */
public class SlidingWindowMaximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        LinkedList<Integer> st = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (B > A.size()) {
            int max = A.stream().max(Integer::compareTo).get();
            ans.add(max);
            return ans;
        }

        for (int i = 0; i < B; i++) {
            while (!st.isEmpty() && A.get(i) >= A.get(st.getLast())) {
                st.removeLast();
            }
            st.addLast(i);
        }
        ans.add(A.get(st.getFirst()));

        for (int i = 1; i < A.size() - B + 1; i++) {
            int newE = A.get(i + B - 1);
            if (st.getFirst() < i) {
                st.removeFirst();
            }
            st = st.stream().filter(t -> A.get(t) > newE).collect(Collectors.toCollection(LinkedList::new));

            st.addLast(i + B - 1);
            ans.add(A.get(st.getFirst()));
        }

        return ans;
    }

    public static void main(String[] st) {
        SlidingWindowMaximum q = new SlidingWindowMaximum();
        System.out.println(q.slidingMaximum(Arrays.asList(1), 1));
        System.out.println(q.slidingMaximum(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), 2));
        System.out.println(q.slidingMaximum(Arrays.asList(648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368), 9));
    }
}
