package P4;


import java.util.Random;

/**
 * Created by max on 12/24/2016.
 */
public class q4_11 {
    public static class RandomTreeNode<T extends Comparable<T>>{

        private RandomTreeNode<T> left;
        private RandomTreeNode<T> right;
        private T val;
        private int size;

        private static class SearchNodeData<T extends Comparable<T>>{
            public RandomTreeNode<T> node;
            public RandomTreeNode<T> parent;
        }


        public RandomTreeNode(T val) {
            this.val = val;
            this.size= 1;
        }

        public RandomTreeNode(RandomTreeNode<T> left, RandomTreeNode<T> right, T val) {
            this.left = left;
            this.right = right;
            this.val = val;
            size = 1;
            updateSize(left);
            updateSize(right);
        }

        private void updateSize(RandomTreeNode<T> n){
            if(n != null){
                size+= n.getSize();
            }
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public RandomTreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(RandomTreeNode<T> left) {
            this.left = left;
            updateSize(left);
        }

        public RandomTreeNode<T> getRight() {
            return right;
        }

        public void setRight(RandomTreeNode<T> right) {
            this.right = right;
            updateSize(right);
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public void insert(T n){
            if(n.compareTo(val)<0){
                if(left == null){
                    left = new RandomTreeNode<T>(n);
                }
                else{
                    left.insert(n);
                }
            }
            else{
                if(right == null){
                    right = new RandomTreeNode<T>(n);
                }
                else{
                    right.insert(n);
                }
            }
            size++;
        }


        public RandomTreeNode<T> find(T n){
            SearchNodeData<T> searchNodeData = new SearchNodeData<T>();
            findInternal(n,searchNodeData);
            return searchNodeData.node;
        }

        protected void findInternal(T n, SearchNodeData<T> searchNodeData){
            if(n.compareTo(val)==0){
                searchNodeData.node = this;
                return ;
            }
            if(size == 0){
                searchNodeData.node = this;
                return ;
            }

            searchNodeData.parent = this;
            if(left != null) {
                left.findInternal(n,searchNodeData);
                if (searchNodeData.node != null) {
                    return;
                }
            }
            if (right != null) {
                right.findInternal(n,searchNodeData);
            }
        }

        public RandomTreeNode<T> remove(T n){
            SearchNodeData<T> searchNodeData = new SearchNodeData<T>();
            findInternal(n,searchNodeData);
            if(searchNodeData.node == null){
                return null;
            }
//            if(searchNodeData.node.size == 0){
//                searchNodeData.parent.size--;
//                if(searchNodeData.parent.left == searchNodeData.node){
//                    searchNodeData.parent.left=null;
//                }
//                else {
//                    searchNodeData.parent.right = null;
//                }
//            }
//            if(searchNodeData.node.left == null){
//
//            }

            return searchNodeData.node;
        }


        public RandomTreeNode<T> getRandomNode(){
            Random random = new Random();
            int leftSize =(left == null)? 0 : left.size;
            int index = random.nextInt(size);
            if(index<leftSize){
                return left.getRandomNode();
            }
            else if(index == leftSize){
                return this;
            }
            return right.getRandomNode();
        }

        @Override
        public String toString() {
            return "RandomTreeNode{" +
                    "val=" + val +
                    "left=" + left +
                    "right=" + right +
                    '}';
        }


    }

    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < 1000000; i++) {
            RandomTreeNode<Integer> tree = new RandomTreeNode<Integer>(1);
            int[] array = {0, 6, 2, 3, 9, 4, 5, 8, 7};
            for (int x : array) {
                tree.insert(x);
            }
            int d = tree.getRandomNode().getVal();
            counts[d]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }
}
