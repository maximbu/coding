package CodingInterviews2018.P17;

import java.util.*;

public class Node<T>{
    T data;
    Set<Node<T>> neighbours = new HashSet<>();

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public List<Node<T>> getNeighbours() {
        return new ArrayList<>(neighbours);
    }

    public void addNeighbour(Node<T> neighbour){
        if(neighbours.add(neighbour)) {
            neighbour.addNeighbour(this);
        }
    }

    public void removeNeighbour(Node<T> neighbour){
        if(neighbours.remove(neighbour)) {
            neighbour.removeNeighbour(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
