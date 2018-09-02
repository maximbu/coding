package CodingInterviews2018.P4;

import CodingInterviews.utils.BinTreeNode;

public class q4_2 {

    public static BinTreeNode<Integer> minimalTree(int[] arr) {
        int mid = arr.length / 2;
        var root = new BinTreeNode<>(arr[mid]);
        root.setLeft(minimalTree(arr, 0, mid - 1));
        root.setRight(minimalTree(arr, mid + 1, arr.length - 1));
        return root;
    }

    private static BinTreeNode<Integer> minimalTree(int[] arr, int left,
            int right) {
        if (right < left)
            return null;
        int mid = (left + right) / 2;
        var curr = new BinTreeNode<>(arr[mid]);
        curr.setLeft(minimalTree(arr, left, mid - 1));
        curr.setRight(minimalTree(arr, mid + 1, right));
        return curr;
    }


    public static void main(String[] st) {
        int N = 6;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }
        BinTreeNode<Integer> tree = minimalTree(array);

    }
}
