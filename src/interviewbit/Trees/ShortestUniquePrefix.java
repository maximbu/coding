package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Find shortest unique prefix to represent each word in the list.
 *
 * Example:
 *
 * Input: [zebra, dog, duck, dove]
 * Output: {z, dog, du, dov}
 * where we can see that
 * zebra = z
 * dog = dog
 * duck = du
 * dove = dov
 *  NOTE : Assume that no word is prefix of another. In other words, the representation is always possible
 */
public class ShortestUniquePrefix {
    public ArrayList<String> prefix(ArrayList<String> A) {
        MultiNodeCharTree t = new MultiNodeCharTree();
        t.addAll(A);
        ArrayList<String> ans = new ArrayList<>();
        for (String st : A) {
            ans.add(t.unique(st));
        }
        return ans;
    }

    private static class MultiNodeCharTree {
        HashMap<Character, MultiNodeCharTree> children;

        public MultiNodeCharTree() {
            children = new HashMap<>();
        }

        public void addAll(List<String> list) {
            for (String s : list) {
                add(s);
            }
        }

        public void add(String s) {
            add(s, 0);
        }

        private void add(String s, int i) {
            if (s.length() <= i)
                return;
            Character c = s.charAt(i);

            MultiNodeCharTree childNode;
            if (children.containsKey(c)) {
                childNode = children.get(c);
            } else {
                childNode = new MultiNodeCharTree();
                children.put(c, childNode);
            }
            childNode.add(s, i + 1);
        }

        public String unique(String st) {
            return unique(st, 0);
        }

        private String unique(String st, int i) {
            if (st.length() <= i)
                return st;
            char c = st.charAt(i);
            MultiNodeCharTree child = children.get(c);
            if (child.children.size() == 1 && onlyChild(st, i)) {
                return st.substring(0, i + 1);
            }
            return child.unique(st, i + 1);
        }

        private boolean onlyChild(String st, int i) {
            if (st.length() <= i)
                return true;
            char c = st.charAt(i);
            MultiNodeCharTree child = children.get(c);
            return (child.children.size() < 2) && child.onlyChild(st, i + 1);
        }
    }

    public static void main(String[] st) {
        ShortestUniquePrefix q = new ShortestUniquePrefix();
        System.out.println(q.prefix(new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"))));
        System.out.println(q.prefix(new ArrayList<>(Arrays.asList("bearcat", "bert"))));
    }
}
