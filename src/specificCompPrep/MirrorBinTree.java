package specificCompPrep;

public class MirrorBinTree {

    private static <T> TreeNode<T> createMirrorCopy(TreeNode<T> tree){
        if(tree == null) return null;
        TreeNode<T> left = createMirrorCopy(tree.getLeft());
        TreeNode<T> right = createMirrorCopy(tree.getRight());
        var copy = new TreeNode<>(tree.data);
        copy.setLeft(right);
        copy.setRight(left);
        return copy;
    }

    private static <T> TreeNode<T> mirrorize(TreeNode<T> tree) {
        if (tree == null) return null;
        TreeNode<T> left = mirrorize(tree.getLeft());
        TreeNode<T> right = mirrorize(tree.getRight());
        tree.setLeft(right);
        tree.setRight(left);
        return tree;
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(8);
        TreeNode<Integer> left = new TreeNode<>(4);
        TreeNode<Integer> right = new TreeNode<>(14);
        TreeNode<Integer> leftLeft = new TreeNode<>(3);
        TreeNode<Integer> leftRight = new TreeNode<>(5);
        TreeNode<Integer> leftRightRight = new TreeNode<>(6);
        TreeNode<Integer> rightRight = new TreeNode<>(18);
        TreeNode<Integer> rightRightLeft = new TreeNode<>(17);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        leftRight.setRight(leftRightRight);
        right.setRight(rightRight);
        rightRight.setLeft(rightRightLeft);
        System.out.println(root);
        TreeNode<Integer> mirrored = createMirrorCopy(root);
        System.out.println(mirrored);
        mirrorize(root);
        System.out.println(root);

    }
}
