package ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid Capacity");
        }
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        checkIndex(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid Index!");
        }
    }

    public E remove(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        E removedElement = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> clonedList = new MyList<>(elements.length);
        clonedList.size = this.size;
        clonedList.elements = Arrays.copyOf(this.elements, this.size);
        return clonedList;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean add(E o) {
        ensureCapacity(size + 1);
        elements[size++] = o;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        checkIndex(i);
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
