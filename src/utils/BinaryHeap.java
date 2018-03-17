package utils;


import java.util.Arrays;

/**
 * Created by max on 1/1/2017.
 */
public class BinaryHeap<T extends Comparable<T>> {
    private static final int STARTING_CAPACITY = 10;
    private T[] a;
    protected int size;

    public BinaryHeap(){
        a = (T[])new Comparable[STARTING_CAPACITY];
        size = 0;
    }

    public void add(T n) {
        size++;
        if(size>=a.length){
            resize();
        }
        a[size]=n;
        bubbleUp();
    }



    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        return a[1];
    }

    public T remove() {
        T ans = peek();
        a[1] = a[size];
        a[size] = null;
        size--;

        bubbleDown();
        return ans;
    }

    private void bubbleDown() {
        int curr = 1;
        while (hasLeftChild(curr)){
            int sm = getSmallerChildInd(curr);
            if(a[curr].compareTo(a[sm])<=0){
                return;
            }
            swap(curr,sm);
            curr = sm;
        }
    }

    private int getSmallerChildInd(int curr) {
        int l = getLeftChildInd(curr);
        if (!hasRightChild(curr)) {
            return l;
        }
        int r = getRightChildInd(curr);
        return a[l].compareTo(a[r]) < 0 ? l : r;
    }

    private void bubbleUp() {
        int curr = size;
        while (hasParent(curr)){
            if(getParent(curr).compareTo(a[curr])<=0){
                return;
            }
            swap(curr,getParentInd(curr));
            curr = getParentInd(curr);
        }
    }

    public String toString() {
        return Arrays.toString(a);
    }


    private int getParentInd(int ind){
        return ind/2;
    }

    private T getParent(int ind){
        return a[getParentInd(ind)];
    }

    private boolean hasParent(int ind){
        return ind!=1;
    }

    private int getLeftChildInd(int ind){
        return ind*2;
    }

    private int getRightChildInd(int ind){
        return ind*2+1;
    }
    private boolean hasLeftChild(int ind){
        return getLeftChildInd(ind) <= size;
    }
    private boolean hasRightChild(int ind){
        return getRightChildInd(ind) <= size;
    }
    private void resize(){
        a = Arrays.copyOf(a,a.length*2);
    }
    private void swap(int i,int j){
        T tmp = a[i];
        a[i]= a[j];
        a[j]=tmp;
    }

}

