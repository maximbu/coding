package DataStructures;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList<E>  extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{

  private static final long serialVersionUID = 8683452581122892189L;
  private static final int DEFAULT_CAPACITY = 10;
  /**
   * Shared empty array instance used for empty instances.
   */
  private static final Object[] EMPTY_ELEMENTDATA = {};
  /**
   * Shared empty array instance used for default sized empty instances. We
   * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
   * first element is added.
   */
  private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
  /**
   * The array buffer into which the elements of the ArrayList are stored.
   * The capacity of the ArrayList is the length of this array buffer. Any
   * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
   * will be expanded to DEFAULT_CAPACITY when the first element is added.
   */
  transient Object[] elementData; // non-private to simplify nested class access

  private int size;

  /**
   * Constructs an empty list with the specified initial capacity.
   *
   * @param  initialCapacity  the initial capacity of the list
   * @throws IllegalArgumentException if the specified initial capacity
   *         is negative
   */
  public MyArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
      this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
      this.elementData = EMPTY_ELEMENTDATA;
    } else {
      throw new IllegalArgumentException("Illegal Capacity: "+
          initialCapacity);
    }
  }

  /**
   * Constructs an empty list with an initial capacity of ten.
   */
  public MyArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
  }

  /**
   * Constructs a list containing the elements of the specified
   * collection, in the order they are returned by the collection's
   * iterator.
   *
   * @param c the collection whose elements are to be placed into this list
   * @throws NullPointerException if the specified collection is null
   */
  public MyArrayList(Collection<? extends E> c) {
    this.elementData = c.toArray();
    if ((size = this.elementData.length) == 0) {
      // replace with empty array.
      this.elementData = EMPTY_ELEMENTDATA;
    }
  }


  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    return indexOf(o) >= 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new MyIterator<>();
  }


  @Override
  public void forEach(Consumer<? super E> action) {
    Objects.requireNonNull(action);
    final int expectedModCount = modCount;
    final Object[] es = elementData;
    final int size = this.size;
    for (int i = 0; modCount == expectedModCount && i < size; i++)
      action.accept(elementAt(es, i));
    if (modCount != expectedModCount)
      throw new ConcurrentModificationException();
  }

  static <E> E elementAt(Object[] es, int index) {
    return (E) es[index];
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(elementData, size);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> T[] toArray(T[] a) {
    if (a.length < size) {
      // Make a new array of a's runtime type, but my contents:
      return (T[]) Arrays.copyOf(elementData, size, a.getClass());
    }
    System.arraycopy(elementData, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  @Override
  public boolean add(E e) {
    modCount++;
    if (size == elementData.length) {
      elementData = grow();
    }
    elementData[size++] = e;
    return true;
  }

  private Object[] grow(int minCapacity) {
    return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
  }

  private Object[] grow() {
    return grow(size + 1);
  }

  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  private int newCapacity(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity > 0) {
      return (newCapacity - MAX_ARRAY_SIZE <= 0)
          ? newCapacity
          : hugeCapacity(minCapacity);
    }
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
      return Math.max(DEFAULT_CAPACITY, minCapacity);
    if (minCapacity < 0) // overflow
      throw new OutOfMemoryError();
    return minCapacity;
  }

  private static int hugeCapacity(int minCapacity) {
    if (minCapacity < 0) // overflow
      throw new OutOfMemoryError();
    return (minCapacity > MAX_ARRAY_SIZE)
        ? Integer.MAX_VALUE
        : MAX_ARRAY_SIZE;
  }


  @Override
  public boolean remove(Object o) {
    final Object[] es = elementData;
    int i = indexOf(o);
    if(i < 0) return false;
    fastRemove(es, i);
    return true;
  }
  private void fastRemove(Object[] es, int i) {
    modCount++;
    final int newSize;
    if ((newSize = size - 1) > i)
      System.arraycopy(es, i + 1, es, i, newSize - i);
    es[size = newSize] = null;
  }


  @Override
  public boolean addAll(Collection<? extends E> c) {
    Object[] a = c.toArray();
    modCount++;
    int numNew = a.length;
    if (numNew == 0)
      return false;
    Object[] elementData;
    final int s;
    if (numNew > (elementData = this.elementData).length - (s = size))
      elementData = grow(s + numNew);
    System.arraycopy(a, 0, elementData, s, numNew);
    size = s + numNew;
    return true;
  }


  private void rangeCheckForAdd(int index) {
    if (index > size || index < 0)
      throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    rangeCheckForAdd(index);

    Object[] a = c.toArray();
    modCount++;
    int numNew = a.length;
    if (numNew == 0)
      return false;
    Object[] elementData;
    final int s;
    if (numNew > (elementData = this.elementData).length - (s = size))
      elementData = grow(s + numNew);

    int numMoved = s - index;
    if (numMoved > 0)
      System.arraycopy(elementData, index,
          elementData, index + numNew,
          numMoved);
    System.arraycopy(a, 0, elementData, index, numNew);
    size = s + numNew;
    return true;
  }


  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean removeIf(Predicate<? super E> filter) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void replaceAll(UnaryOperator<E> operator) {

  }

  @Override
  public void sort(Comparator<? super E> c) {

  }

  @Override
  public void clear() {

  }

  @Override
  public boolean equals(Object o) {
    return false;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public E get(int index) {
    return null;
  }

  @Override
  public E set(int index, E element) {
    return null;
  }

  @Override
  public void add(int index, E element) {

  }

  @Override
  public E remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<E> listIterator() {
    return null;
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return null;
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    return null;
  }

  @Override
  public Spliterator<E> spliterator() {
    return null;
  }

  @Override
  public Stream<E> stream() {
    return null;
  }

  @Override
  public Stream<E> parallelStream() {
    return null;
  }

  private class MyIterator<E> implements Iterator<E> {

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public E next() {
      return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {

    }
  }

  public static void main(String[] args) {
    List l = Arrays.asList("a","b","c");
    var ml = new MyArrayList(l);
    var ml2 = new ArrayList(l);
  }


}


