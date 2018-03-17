package utils;

/**
 * Created by max on 12/17/2016.
 */

public class MyDoubleLinkedListNode<T> {
    private MyDoubleLinkedListNode<T> next;
    private MyDoubleLinkedListNode<T> prev;
    private T data;

    public MyDoubleLinkedListNode(T d, MyDoubleLinkedListNode<T> n, MyDoubleLinkedListNode<T> p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }

    public MyDoubleLinkedListNode(T d) {
        data = d;
    }

    public MyDoubleLinkedListNode() { }

    public void setNext(MyDoubleLinkedListNode<T> n) {
        next = n;
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(MyDoubleLinkedListNode<T> p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public MyDoubleLinkedListNode<T> getNext() {
        return next;
    }

    public MyDoubleLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(MyDoubleLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyDoubleLinkedListNode{" +
                "next=" + next +
                ", prev=" + prev +
                ", data=" + data +
                '}';
    }
}
