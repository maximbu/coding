package CodingInterviews.utils;

/**
 * Created by max on 12/17/2016.
 */

public class MyLinkedListNode<T> {

    public static <T> MyLinkedListNode<T> createList(T... data) {
        if(data.length == 0)
        {
            return new MyLinkedListNode<>();
        }
        MyLinkedListNode<T> head = new MyLinkedListNode<>(data[0]);
        MyLinkedListNode<T> curr = head;
        for (int i = 1; i < data.length; i++) {
            T d = data[i];
            curr.setNext(new MyLinkedListNode<>(d));
            curr = curr.getNext();
        }
        return head;
    }

    public static <T> String printList(MyLinkedListNode<T> head){
        StringBuilder sb = new StringBuilder();
        MyLinkedListNode<T> curr = head;
        while (curr != null){
            sb.append(curr);
            curr = curr.getNext();
            if(curr!= null)
            {
                sb.append("->");
            }
        }
        return sb.toString();
    }

    private MyLinkedListNode<T> next;
    private T data;

    public MyLinkedListNode(T d, MyLinkedListNode<T> n) {
        data = d;
        setNext(n);
    }

    public MyLinkedListNode(T d) {
        data = d;
    }

    public MyLinkedListNode() { }

    public void setNext(MyLinkedListNode<T> n) {
        next = n;
    }
    public MyLinkedListNode<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
