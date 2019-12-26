package interviewbit.Trees;

public class PopulateNextRightPointersTree {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        while (root != null) {
            handleLevelChildren(root);
            root = getNextLevelFirstNode(root);
        }
    }

    private void handleLevelChildren(TreeLinkNode currLvl) {
        while (currLvl != null) {
            handleChildren(currLvl);
            currLvl = currLvl.next;
        }
    }

    private TreeLinkNode getNextLevelFirstNode(TreeLinkNode root) {
        if (root.left != null)
            return root.left;
        if (root.right != null)
            return root.right;
        return nextRightForChildOf(root);
    }

    private void handleChildren(TreeLinkNode currLvl) {
        if (currLvl.left != null) {
            if (currLvl.right != null) {
                currLvl.left.next = currLvl.right;
            } else {
                currLvl.left.next = nextRightForChildOf(currLvl);
            }
        }
        if (currLvl.right != null) {
            currLvl.right.next = nextRightForChildOf(currLvl);
        }
    }

    private TreeLinkNode nextRightForChildOf(TreeLinkNode p) {
        p = p.next;
        while (p != null) {
            if (p.left != null) return p.left;
            if (p.right != null) return p.right;
            p = p.next;
        }
        return null;
    }

}
